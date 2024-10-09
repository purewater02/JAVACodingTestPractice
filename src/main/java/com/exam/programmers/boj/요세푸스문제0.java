package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Solution solution = new Solution();
		solution.sol(n, k);
	}

	private static class Solution {
		private void sol(int n, int k) {
			StringBuilder sb = new StringBuilder();
			sb.append("<");
			Deque<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				queue.add(i);
			}
			while (!queue.isEmpty()) {
				for (int i = 0; i < k - 1; i++) {
					queue.add(queue.poll());
				}
				sb.append(queue.poll()).append(", ");
			}
			sb.append(">");
			System.out.println(sb.toString().replace(", >", ">"));
		}
	}
}
