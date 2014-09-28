package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;

public class simplifyPath {
	public String simplifyPath(String path) {
        String[] dirs = path.split("/");    // will produce empty string
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < dirs.length; i++) {        	
            if (dirs[i].length() == 0) {
                continue;
            }
            if (dirs[i].equals("..")) {		// must use String.equals rather than "=="!!!
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!dirs[i].equals(".")) {		// must use String.equals rather than "=="!!!
            	System.out.println("dirs[i] " + dirs[i] );
                list.add(dirs[i]);
            }
        }
                
        String result = "/";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if (i != list.size() - 1)
                result += "/";
        }
        return result;
    }
}
