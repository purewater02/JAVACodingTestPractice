package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution solution = new Solution();
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			solution.sol(str);
		}
	}

	private static class Solution {
		private void sol(String str) {
			StringBuilder sb = new StringBuilder();
			Stack<String> stack = new Stack<>();
			for (char c : str.toCharArray()) {
				if (c == '(' || c == '[') {
					stack.push(String.valueOf(c));
				} else if (c == ')') {
					if (stack.isEmpty() || !stack.peek().equals("(")) {
						sb.append("no").append("\n");
						System.out.print(sb);
						return;
					}
					stack.pop();
				} else if (c == ']') {
					if (stack.isEmpty() || !stack.peek().equals("[")) {
						sb.append("no").append("\n");
						System.out.print(sb);
						return;
					}
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
			System.out.print(sb);
		}
	}
}
