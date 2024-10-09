package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(st.nextToken());

		Solution solution = new Solution();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int x = 0;
			if (command == 1) {
				x = Integer.parseInt(st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			solution.sol(command, x, stack, sb);
			System.out.print(sb);
		}
	}

	private static class Solution {
		private void sol(int command, int x, Stack<Integer> stack, StringBuilder sb) {
			switch (command) {
				case 1:
					stack.add(x);
					break;
				case 2:
					if (!stack.isEmpty()) {
						int pop = stack.pop();
						sb.append(pop).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					if (stack.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case 5:
					if (!stack.isEmpty()) {
						sb.append(stack.peek()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
	}
}
