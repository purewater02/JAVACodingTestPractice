package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Solution solution = new Solution();
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			solution.sol(str);
		}
	}

	private static class Solution {
		private void sol(String str) {
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			for (char c : str.toCharArray()) {
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty()) {
						sb.append("NO").append("\n");
						System.out.print(sb);
						return;
					}
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}

			System.out.print(sb);
		}
	}
}
