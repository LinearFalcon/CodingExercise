package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class textJustification {
	public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>(); 
        if (words == null || words.length == 0) {
            return result;
        }
        
        int wordLengthSum = 0;  // 这个word前所有word的长度sum
        int last = 0;  // 这一行第一个word在words中的index
        
        for (int i = 0; i < words.length; i++) {
            //假设当前放上了这个单词，那么这一行单词跟单词间的间隔数就是i-last
            //判断这些总的长度加起来是不是大于L（超行数了）
            if (wordLengthSum + words[i].length() + (i - last) > L) {	//每个单词之间至少一个空格
                int spaceNum = 0;
                int extraNum = 0;
                //因为尝试的words[i]失败了，所以间隔数减1.此时判断剩余的间隔数是否大于0
                if (i - last - 1 > 0) {
                    spaceNum = (L - wordLengthSum) / (i - last - 1);    //是间隔的倍数
                    extraNum = (L - wordLengthSum) % (i - last - 1);    //不是间隔倍数
                }
                
                StringBuilder sb = new StringBuilder();
                for (int j = last; j < i; j++) {
                    sb.append(words[j]);
                    // 一行最后一个word之后就不用加空格
                    if (j < i - 1) {
                        for (int k = 0; k < spaceNum; k++) {
                            sb.append(" ");
                        }
                        
                        if (extraNum > 0) {
                            sb.append(" ");
                        }
                        extraNum--;
                    }
                    
                }
                
                //下面这个for循环作用于一行只有一个单词还没填满一行的情况
                for (int l = sb.length(); l < L; l++) {
                    sb.append(" ");     //一行只有一个单词的时候，才是在这个单词后面加空格
                }
                
                result.add(sb.toString());
                wordLengthSum = 0;
                last = i;
            }
            
            wordLengthSum += words[i].length();
        }
        
        // 处理最后一行，因为上面这个循环处理到最后一个单词时肯定没有超过L，然后循环就结束
        // 了所以还没有处理最后一行
        StringBuilder sb = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            sb.append(words[i]);
            if (sb.length() < L) {
                sb.append(" ");
            }
        }
        for (int i = sb.length(); i < L; i++) {
            sb.append(" ");
        }
        
        result.add(sb.toString());
        return result;
    }
}
