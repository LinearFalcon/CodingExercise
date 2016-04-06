package edu.nyu.liangfang.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeMap;

/*
 *  Newspaper's membernumber - Newspaper's circulation pair
 */
class newsSold {
    public int newsId;
    public int circulation;

    newsSold(int nId, int circ) {
        newsId = nId;
        circulation = circ;
    }
}

/*
 * Store all counties' information
 */
class countyInfo {
    public int countyId;
    public String countyName;
    public String countyCode;

    countyInfo(int id, String name, String code) {
        countyId = id;
        countyName = name;
        countyCode = code;
    }
}

public class renjieQuestion {
    private TreeMap<Integer, HashSet<Integer>> headquartered = new TreeMap<Integer, HashSet<Integer>>();
    private TreeMap<Integer, ArrayList<newsSold>> countyNewsSold = new TreeMap<Integer, ArrayList<newsSold>>();
    private Hashtable<Integer, countyInfo> countyTable = new Hashtable<Integer, countyInfo>();

    /*
     * Read file from input file and store information we need to 'headquartered', 'countyNewsSold' and 'countyTable'
     *
     * @param filePath  input file path
     */
    public void readFile(String filePath) throws IOException {
        BufferedReader br = null;

        try {
            String currentLine;
            br = new BufferedReader(new FileReader(filePath));

            currentLine = br.readLine();                                    // first line is titles, useless

            // Read line by line from input file and store info into treemap
            int maxCirculation = 0;                                            // initial max circ for one newspaper
            int previousNewsId = -1;                                        // previous line's membernumber
            int countyIdToAdd = 0;                                            // for headquartered use
            int newsIdToAdd = 0;                                            // for headquartered use
            while ((currentLine = br.readLine()) != null) {
                String[] line = currentLine.split("\t");                    // sections in one line is separated by tab '\t'
                int newsId = Integer.parseInt(line[0]);
                String newsName = line[1];
                int countyId = Integer.parseInt(line[2]);
                String countyName = line[3];
                String countyCode = line[4];
                int circulation = Integer.parseInt(line[5]);

                // Create county info list
                if (!countyTable.containsKey(countyId)) {
                    countyTable.put(countyId, new countyInfo(countyId, countyName, countyCode));
                }

                // Create countyNewsSold treemap
                if (countyNewsSold.containsKey(countyId)) {
                    countyNewsSold.get(countyId).add(new newsSold(newsId, circulation));
                } else {
                    ArrayList<newsSold> newsSoldOut = new ArrayList<newsSold>();
                    newsSoldOut.add(new newsSold(newsId, circulation));
                    countyNewsSold.put(countyId, newsSoldOut);
                }

                // Create headquatered treemap
                if (previousNewsId == -1 || newsId == previousNewsId) {        // find headquartered newspapaer
                    if (circulation > maxCirculation) {
                        newsIdToAdd = newsId;
                        countyIdToAdd = countyId;
                        maxCirculation = circulation;
                    }
                } else {
                    if (headquartered.containsKey(countyIdToAdd)) {
                        headquartered.get(countyIdToAdd).add(newsIdToAdd);
                    } else {
                        headquartered.put(countyIdToAdd, new HashSet<Integer>(newsIdToAdd));
                    }
                    newsIdToAdd = newsId;
                    countyIdToAdd = countyId;
                    maxCirculation = circulation;
                }
                previousNewsId = newsId;
            }

            // process last couple of lines of the same newspapers records
            if (headquartered.containsKey(countyIdToAdd)) {
                headquartered.get(countyIdToAdd).add(newsIdToAdd);
            } else {
                headquartered.put(countyIdToAdd, new HashSet<Integer>(newsIdToAdd));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*
     * Output result to file
     *
     * @param resultFilePath  path for result file
     */
    public void output(String resultFilePath) throws IOException {
        File file = new File(resultFilePath);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int cId : headquartered.keySet()) {
            for (int cId2 : countyNewsSold.keySet()) {
                if (cId != cId2) {
                    List<newsSold> list = countyNewsSold.get(cId2);
                    int sum = 0;
                    for (newsSold ns : list) {
                        if (headquartered.get(cId).contains(ns.newsId)) {
                            sum += ns.circulation;
                        }
                    }
                    if (sum != 0) {
                        try {
                            bw.write(cId + "\t" + countyTable.get(cId).countyName + "\t"
                                    + cId2 + "\t" + countyTable.get(cId2).countyName + "\t"
                                    + countyTable.get(cId2).countyCode + "\t"
                                    + sum + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        bw.close();

    }
}
