package edu.nyu.liangfang.leetcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//Two Sigma online challenge

public class mixSort {

    /**
     * Main function
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
            if (line != null && line.length() <= 1000) {            // maybe not necessary!!!!!!!!!!!!!!!
                new mixSort().mixSort(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort words and numbers separately
     *
     * @param line input string
     */
    public void mixSort(String line) {
        ArrayList<String> wordList = new ArrayList<String>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        // index for wordList and numList
        int wordIndex = 0;
        int numIndex = 0;

        // split words and numbers and store into array
        String[] strArray = line.split(" ");

        // extract word and number
        for (int i = 0; i < strArray.length; i++) {
            if (isNumeric(strArray[i])) {
                numList.add(Integer.valueOf(strArray[i]));
                // mark this position as 'number'
                strArray[i] = "n";
            } else {
                wordList.add(strArray[i]);
                // mark this position as 'word'
                strArray[i] = "w";
            }
        }

        // sort wordList and numlist
        Collections.sort(wordList);
        Collections.sort(numList);

        // put sorted element into right position
        for (int i = 0; i < strArray.length; i++) {
            // this position should be put number
            if (strArray[i] == "n") {
                strArray[i] = String.valueOf(numList.get(numIndex));
                numIndex++;
            } else {
                strArray[i] = wordList.get(wordIndex);
                wordIndex++;
            }
        }

        // output sorted string
        output(strArray);
    }

    /**
     * Output sorted array
     *
     * @param strArray sorted array
     */
    public void output(String[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[arr.length - 1]);
        }
    }

    /**
     * Determine if a string is numeric
     *
     * @param str string to determine
     * @return boolean value
     */
    public static boolean isNumeric(String str) {
        return str.matches("[-+]?\\d*\\.?\\d+");
    }
}
