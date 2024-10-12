package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Solution solution = new Solution();
		solution.sol(n);
	}

	private static class Solution {
		private void sol(int n) {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
			System.out.println(result);
		}
	}
}
