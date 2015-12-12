package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class simplifyPath {
	public String simplifyPath(String path) {
        String[] dirs = path.split("/");    // will produce empty string, slash doesn't need to be escaped
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < dirs.length; i++) {        	
            if (dirs[i].length() == 0) {		// deal with input like "/ac///b"
                continue;
            }
            if (dirs[i].equals("..")) {		// must use String.equals rather than "=="!!!
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!dirs[i].equals(".")) {		
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
