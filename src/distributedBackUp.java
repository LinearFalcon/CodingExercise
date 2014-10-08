package edu.nyu.liangfang.leetcode;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Two Sigma online challenge

public class distributedBackUp {

	/**
	 * Main Function
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			if (line != null) {
				int dataCenterNum = Integer.valueOf(line);
				String[] dataLine = new String[dataCenterNum];
				for (int i = 0; i < dataCenterNum; i++) {
					dataLine[i] = br.readLine();
				}
				new distributedBackUp().outputBackUp(dataCenterNum, dataLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void outputBackUp(int dataCenterNum, String[] dataLine) {
		// store set for each line of data center
		List<Set<Integer>> dataCenters = new ArrayList<Set<Integer>>();
		// store all data
		Set<Integer> allData = new HashSet<Integer>();
		// map data to index of data sets
		Map<Integer, Integer> reversedIndex = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < dataCenterNum; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			String[] data = dataLine[i].split(" ");
			int dataNum = Integer.valueOf(data[0]);
			for (int j = 1; j <= dataNum; j++) {
				int singleData = Integer.valueOf(data[j]);
				// put data into allData set
				if (!allData.contains(singleData)) {
					allData.add(singleData);
				}
				// put (data, datacenter index) pair into reversedIndex
				if (!reversedIndex.containsKey(singleData)) {
					reversedIndex.put(singleData, i + 1);
				}
				// store data for this data set
				if (!set.contains(singleData)) {
					set.add(singleData);
				}
			}
			dataCenters.add(set);
		}
		
		// check each data center and output copy operation
		for (int i = 0; i < dataCenters.size(); i++) {
			Set<Integer> set = dataCenters.get(i);
			for (int data : allData) {
				if (!set.contains(data)) {
					System.out.println(data + " " + reversedIndex.get(data) 
							+ " " + (i + 1));
				}
			}
		}
		System.out.println("done");
	}
}
