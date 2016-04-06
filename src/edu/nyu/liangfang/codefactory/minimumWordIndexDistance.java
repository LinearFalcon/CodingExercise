package edu.nyu.liangfang.codefactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* This class will be given a list of words (such as might be tokenized
* from a paragraph of text), and will provide a method that takes two
* words and returns the shortest distance (in words) between those two
* words in the provided text. 
* Example:
*   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
*   assert(finder.distance("fox","the") == 3);
*   assert(finder.distance("quick", "fox") == 1);

*/

// we assume the input w1 is different from w2, if w1.equals(w2), return Integer.MAX_VALUE
public class minimumWordIndexDistance {

    // Frequently used version, pre-processing and save to HashMap
    private static Map<String, List<Integer>> map;

    public minimumWordIndexDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (map.containsKey(curr)) {
                map.get(curr).add(i);
            } else {
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(curr, list);
            }
        }
    }

    public int getDistanceFromMap(String w1, String w2) {
        if (!map.containsKey(w1) || !map.containsKey(w2)) {
            return -1;
        }
        List<Integer> list1 = map.get(w1);
        List<Integer> list2 = map.get(w2);

        int index1 = 0;
        int index2 = 0;
        int min = Integer.MAX_VALUE;
        while (index1 < list1.size() && index2 < list2.size()) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            min = Math.min(min, (int) Math.abs(num1 - num2));

            if (min == 1) {
                return min;
            }

            if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return min;
    }


    // CC 150 version
    public int distance_cc150(String[] words, String w1, String w2) {
        int min = Integer.MAX_VALUE;

        int lastpos1 = -1;
        int lastpos2 = -1;
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (curr.equals(w1)) {
                lastpos1 = i;
                int diff = lastpos1 - lastpos2;
                if (lastpos2 > -1 && diff < min) {
                    min = diff;
                }
            } else if (curr.equals(w2)) {
                lastpos2 = i;
                int diff = lastpos2 - lastpos1;
                if (lastpos1 > -1 && diff < min) {
                    min = diff;
                }
            }
        }
        return min;
    }


    // my version
    public int distance(String[] words, String w1, String w2) {
        int min = Integer.MAX_VALUE;

        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w1) || words[i].equals(w2)) {
                if (index == -1) {
                    index = i;
                } else {
                    if (words[i].equals(words[index])) {
                        index = i;
                    } else {
                        min = Math.min(min, i - index);
                        index = i;
                    }
                }
            }
        }
        return min;
    }
}
