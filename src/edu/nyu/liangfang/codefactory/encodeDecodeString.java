package edu.nyu.liangfang.codefactory;
import java.util.ArrayList;
import java.util.List;

/*
 * 先将每个单词里面的反斜杠'\'加倍变成连续2个'\'，然后将每个每个单词里面的逗号','前面加上一个反斜杠'\'。最后在每个单词中间加上一个逗号','。得到输出的字符串。
 * 反序列化的时候遇到第一个反斜杠就先跳过，然后加上后面的字符。这样就可以解码了。
 */
public class encodeDecodeString {
	public String encode(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			// 因为java里面 '\' 是escape sign，所以一个string给了java，要表示一个'\'前面必须有一个escaped '\'，
		    // 同理当系统读出一个string为 "a\b"，在系统里面表示为 "a\\b"，因为我们需要输出"a\\b"，那么给系统的字符串
			// 应该是 "a\\\\b"，因此我们需要把两个 '\' 变成4个，在java程序里面就要写成8个
			sb.append(s.replaceAll("\\\\", "\\\\\\\\").replaceAll(",", "\\\\,")).append(",");	// comma means end of a string
		}
//		sb.deleteCharAt(sb.length() - 1);	不需要这一步，否则最后一个string不能decode
		return sb.toString();
	}
	
	public List<String> decode(String s) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean escaped = false;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '\\' && !escaped) {
				escaped = true;
			} else if (ch == ',' && !escaped) {
				result.add(sb.toString());
				sb.setLength(0);
			} else {
				sb.append(ch);
				escaped = false;
			}
		}
		return result;
	}
	
}
