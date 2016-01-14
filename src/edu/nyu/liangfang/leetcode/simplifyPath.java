package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class simplifyPath {
	public String simplifyPath(String path) {
        String[] arr = path.split("/");        
        List<String> list = new ArrayList();
        
        for (String s : arr) {
            if (s.length() != 0) {              // in case "///a/c/"
                if (s.equals("..")) {
                    if (!list.isEmpty())
                        list.remove(list.size() - 1);
                } else if (!s.equals(".")) {
                   list.add(s);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String dir : list) {
            sb.append("/").append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
