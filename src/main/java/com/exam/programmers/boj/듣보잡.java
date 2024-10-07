package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> nonHeardMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			nonHeardMap.put(br.readLine(), 0);
		}
		for (int i = 0; i < m; i++) {
			String nonSeen = br.readLine();
			nonHeardMap.put(nonSeen, nonHeardMap.getOrDefault(nonSeen, -1) + 1);
		}
		Solution solution = new Solution();
		solution.sol(nonHeardMap);
	}

	private static class Solution {
		private void sol(Map<String, Integer> nonHeardMap) {
			List<String> answerList = nonHeardMap.entrySet().stream()
					.filter(e -> e.getValue() == 1)
					.map(e -> e.getKey())
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.toList());


			StringBuilder sb = new StringBuilder();
			sb.append(answerList.size()).append("\n");
			for (String answer : answerList) {
				sb.append(answer).append("\n");
			}

			System.out.print(sb);
		}
	}
}
