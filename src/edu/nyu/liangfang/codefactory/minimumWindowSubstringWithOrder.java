package edu.nyu.liangfang.codefactory;

import java.util.HashSet;
import java.util.Set;

// 给一个string，比如UAXXBAUB，给一个pattern，比如AB，返回包含pattern的最短
// substring，结果是AUB,考虑pattern是有序的

// Thought:shrink的时候碰到pattern里面第一个字符就停下来
// 还需要考虑pattern是不是全是一样的字母，如果是，下一次循环前，先把start弄到第二个pattern字符的位置；
// 只要不是都是一样的字符，start直接等于当前 i + 1
// Attention: 如果pattern里面没有duplicate，每次shrink完就只用把start置为 i + 1；当前程序还考虑pattern有重复char   有bug！！！！
public class minimumWindowSubstringWithOrder {
	public int minWindow(String s, String p) {
		if (s.length() == 0) return 0;
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < p.length(); i++) {
			set.add(p.charAt(i));
		}
		boolean allSame = set.size() == 1;
		
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		int foundNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == p.charAt(foundNum)) {
				foundNum++;
				if (foundNum == p.length()) {
					while (s.charAt(start) != p.charAt(0)) {
						start++;
					}
		
					minLen = Math.min(minLen, i - start + 1);
					
					if (!allSame) {
						start = i + 1;
						foundNum = 0;
					} else {
						start++;
						while (s.charAt(start) != p.charAt(0)) {
							start++;
						}
						foundNum--;
					}
				}
			}
		}
		return minLen;
	}
	
	
	
	// test
	public static void main(String[] args) {
		minimumWindowSubstringWithOrder o = new minimumWindowSubstringWithOrder();
//		System.out.println(o.minWindow("UAXXBAUB", "AB"));
		System.out.println(o.minWindow("UAXSSXSXAAUB", "XXA"));				// 有bug!!!
	}
}
