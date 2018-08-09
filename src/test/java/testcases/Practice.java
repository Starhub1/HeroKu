package testcases;

import java.util.HashMap;
import java.util.Map;

public class Practice {
	public static void main(String[] args) {
		Practice.getEachCharacterCountofString("Eclipse IDE");
		Practice.getEachCharacterCountofString1("Eclipse IDE");
		Practice.getDuplicateCharacters("Eclipsee IDE");
	}
	
	public static void getEachCharacterCountofString(String str) {
		Map<Character,Integer> map = new HashMap<>();
		char[] strcArray = str.toCharArray();
		for(char c: strcArray) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
		System.out.println("==========");
	}
	
	public static void getEachCharacterCountofString1(String str) {
		char[] strcArray = str.toCharArray();
		int cnt = 0;
		for(int i =0; i<strcArray.length;i++) {
			char c = strcArray[i];
			for(int j=i ;j<strcArray.length;j++) {
				if(c==strcArray[j])
					++cnt;
			}
			System.out.println(c+ "=" + cnt + ", " );
			cnt=0;
		}
		System.out.println("==========");
	}
	
	public static void getDuplicateCharacters(String str) {
		Map<Character,Integer> map = new HashMap<>();
		char[] strcArray = str.toCharArray();
		for(char c: strcArray) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		map.entrySet().stream().filter(c->c.getValue()>1).forEach(System.out::println);;
		System.out.println("==========");
		//System.out.println(map);
	}
	
	public static void getDuplicateCharacters1(String str) {
		char[] strcArray = str.toCharArray();
		int cnt = 0;
		for(int i =0; i<strcArray.length;i++) {
			char c = strcArray[i];
			for(int j=i ;j<strcArray.length;j++) {
				if(c==strcArray[j])
					++cnt;
			}
			System.out.println(c+ "=" + cnt + ", " );
			cnt=0;
		}
		System.out.println("==========");
	}
}
