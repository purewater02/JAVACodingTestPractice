package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			set.add(st.nextToken());
		}
		List<String> targetList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			targetList.add(st.nextToken());
		}
		Solution solution = new Solution();
		solution.sol(set, targetList);
	}

	private static class Solution {
		private void sol(Set<String> set, List<String> targetList) {
			int count = 0;
			for (String tartget : targetList) {
				if (set.contains(tartget)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
