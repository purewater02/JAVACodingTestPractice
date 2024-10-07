package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Map<String, String> workingMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			workingMap.put(name, status);
		}
		workingMap.entrySet().stream()
				.filter(e -> e.getValue().equals("enter"))
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(e -> System.out.println(e.getKey()));
	}
}
