package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		Solution solution = new Solution();
		solution.sol(set);
	}

	private static class Solution {
		private void sol(Set<Integer> set) {
			StringBuilder sb = new StringBuilder();
			set.stream().sorted().forEach(e -> sb.append(e).append("\n"));
			System.out.println(sb);
		}
	}
}
