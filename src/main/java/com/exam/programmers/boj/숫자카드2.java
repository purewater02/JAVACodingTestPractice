package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> sangunList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			sangunList.add(Integer.parseInt(st.nextToken()));
		}
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int card : sangunList) {
			countMap.put(card, countMap.getOrDefault(card, 0) + 1);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> targetList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			targetList.add(Integer.parseInt(st.nextToken()));
		}

		Solution solution = new Solution();
		solution.sol(countMap, targetList);
	}

	private static class Solution {
		private void sol(Map<Integer, Integer> countMap, List<Integer> targetList) {
			StringBuilder sb = new StringBuilder();
			for (int target: targetList) {
				sb.append(countMap.getOrDefault(target, 0)).append(" ");
			}
			System.out.print(sb);
		}
	}
}
