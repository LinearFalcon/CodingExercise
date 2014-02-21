import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.LinkedList;

class Tree {
	public int x;
	public Tree l;
	public Tree r;
	public Tree(int i) {
		x = i;
	}
}

class Fun {
	public void merge(int[] A, int[] B, int lenA, int lenB) {
		int[] helper = new int[lenA];
		for (int  i = 0; i < lenA; i ++) {
			helper[i] = A[i];
		}

		int pointA = 0, pointB = 0;
		int count  = 0;
		while (pointA < lenA && pointB < lenB) {
			if (helper[pointA] < B[pointB]) {
				A[count] = helper[pointA];
				pointA++;
			}
			else {
				A[count] = B[pointB];
				pointB++;
			}
			count++;
		}
		
		if (pointA < lenA) {
			while (pointA < lenA) {
				A[count] = helper[pointA];
				pointA++;
				count++;
			}
		}
		else if (pointB < lenB) {
			while (pointB < lenB) {
				A[count] = B[pointB];
				pointB++;
				count++;
			}
		}
	}
	
	public void merge2(int[] A, int[] B, int lenA, int lenB) {
		int mergeIndex = lenA + lenB - 1;
		int indexA = lenA - 1;
		int indexB = lenB - 1;
		
		while (indexB >= 0) {
			if (indexA >= 0 && A[indexA] > B[indexB]) {
				A[mergeIndex] = A[indexA];
				indexA--;
			}
			else {
				A[mergeIndex] = B[indexB];
				indexB--;
			}
			mergeIndex--;
		}
	}
	
	public void anagramSort(String[] str) {
		if (str.length == 0) return;
		
		Hashtable<String, Boolean> sorted = new Hashtable<String, Boolean>();
		int pos = 0;
		while (pos < str.length) {
			if (!sorted.containsKey(str[pos])) {
				sorted.put(str[pos], true);
				int afterpos = pos + 1;
				int count = afterpos;
				while (count < str.length) {
					if (isAnagram(str[pos], str[count])) {
						exchange(str, afterpos, count);
						sorted.put(str[afterpos], true);
						afterpos++;		
					}
					count++;
				}
			}
			pos++;
		}
	}

	public boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s1.length(); i++) {
			list.add(s1.charAt(i));
		}
		for (int j = 0; j < s2.length(); j++) {
			if (!list.contains(s2.charAt(j)))
				return false;
			else
				list.remove(list.indexOf(s2.charAt(j)));
		}
		return true;
	}
	
	public void exchange(String[] str, int a, int b) {
		String temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
	
	public void anagramSort2(String[] str) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for (String s : str) {
			String temp = sortStr(s);
			if (!hash.containsKey(temp)) {
				hash.put(temp, new LinkedList<String>());
			}
			hash.get(temp).add(s);
		}
		
		int count = 0;
		for (String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for (String ss : list) {
				str[count] = ss;
				count++;
			}
		}
	}
	
	public String sortStr(String s) {
		char[] set = s.toCharArray();
		Arrays.sort(set);
		return new String(set);
	}
	
	public int searchInRotateArray(int[] arr, int left, int right, int x) {
		int mid = (left + right) / 2;
		if (arr[mid] == x)
			return mid;
		if (left > right)
			return -1;

		if (arr[left] < arr[mid]) {
			if (x >= arr[left] && x <= arr[mid])
				return searchInRotateArray(arr, left, mid - 1, x);
			else
				return searchInRotateArray(arr, mid + 1, right, x); 
		}
		else if (arr[left] > arr[mid]) {
			if (x >= arr[mid] && x <= arr[right])
				return searchInRotateArray(arr, mid + 1, right, x);
			else
				return searchInRotateArray(arr, left, mid - 1, x); 
		}
		else {
			return searchInRotateArray(arr, mid + 1, right, x); 
		}

	}
	
	public int searchInArrayWithEmptyStrings(String[] arr, int left, int right, String x) {
		int mid = (left + right) / 2;
		if (arr[mid] == x)
			return mid;
		if (left > right)
			return -1;

		if (arr[mid] != "" && arr[mid].compareTo(x) > 0) {
			return searchInArrayWithEmptyStrings(arr, left, mid - 1, x);
		}
		else if (arr[mid] != "" && arr[mid].compareTo(x) < 0) {
			return searchInArrayWithEmptyStrings(arr, mid + 1, right, x);
		}
		else {
			int index = searchInArrayWithEmptyStrings(arr, left, mid - 1, x);
			if (index >= 0)
				return index;
			else
				return searchInArrayWithEmptyStrings(arr, mid + 1, right, x);
		}
	}
	
	public int searchInArrayWithEmptyStrings2(String[] arr, int left, int right, String x) {
		int mid = (left + right) / 2;
		if (arr[mid] == x)
			return mid;
		if (left > right)
			return -1;

		if (arr[mid].isEmpty()) {
			int l = mid - 1;
			int r = mid + 1;
			while (true) {
				if (l < left && r > right) {
					return -1;
				}
				else if (l >= left && !arr[l].isEmpty()) {
					mid = l;
					break;
				}
				else if (r <= right && !arr[r].isEmpty()) {
					mid = r;
					break;
				}
				l--;
				r++;
			}
		}
		
		if (arr[mid].compareTo(x) > 0) {
			return searchInArrayWithEmptyStrings(arr, left, mid - 1, x);
		}
		else if (arr[mid].compareTo(x) < 0) {
			return searchInArrayWithEmptyStrings(arr, mid + 1, right, x);
		}
		else {
			return mid;
		}
	}
	
	public String[][] createS() {
		String[][] arr = new String[6][6];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				arr[i][j] = "S" + (i+1) + (j+1);
		return arr;
	}
	
	public int solution(int A[], int N) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		int pos = 0;
		int count = 0;
		while (true) {
			if (table.get(pos) != null && table.get(pos) == true) {
				return -1;
			}
			table.put(pos, true);
			if (pos >= A.length || pos < 0) {
				return count;
			}
			pos += A[pos];
			count++;
		}
	}
	
	public int solution2(Tree T) {
		int max = T.x;
		return num(T, max);
	}
	
	public int num(Tree T, int max) {

		int lnum = 0, rnum = 0;
		int count = 0;
		if (T.x >= max) {
			count++; 
		}
		if (T.l != null) {
			int max2 = max;
			if (max2 < T.l.x)
				max2 = T.l.x;
			lnum = num(T.l, max2);
		}
		if (T.r != null) {
			int max3 = max;
			if (max3 < max)
				max3 = T.r.x;
			rnum = num(T.r, max3);
		}
		
		return count + lnum + rnum;
	}
}


public class coding {
	public static void main(String[] args) {
		Fun f = new Fun();
		TwoSumThreeSum fun = new TwoSumThreeSum();
		ClimbingStairs fun3 = new ClimbingStairs();
		MergeSortedArray fun4 = new MergeSortedArray();
		Panlindrome fun5 = new Panlindrome();
		WordLadder fun6 = new WordLadder();
		SetMatrixZeros fun7 = new SetMatrixZeros();
		InsertInterval fun8 = new InsertInterval();
		MergeIntervals fun9 = new MergeIntervals();
		
		ArrayList<Interval> in = new ArrayList<Interval>();
		in.add(new Interval(2,3));in.add(new Interval(5,5));
		in.add(new Interval(2,2));in.add(new Interval(3,4));
		in.add(new Interval(3,4));
		System.out.println(fun9.merge(in).get(0).end);
	
	}
}
