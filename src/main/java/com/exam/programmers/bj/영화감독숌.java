package com.exam.programmers.bj;

import java.util.Scanner;

public class 영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution solution = new Solution();
		System.out.println(Solution.sol(n));
	}

	private static class Solution {
		private static int sol(int n) {
			for (int i = 666; i < Integer.MAX_VALUE; i++) {
				if (String.valueOf(i).contains("666")) {
					n--;
				}
				if (n == 0) {
					return i;
				}
			}
			return 0;
		}
	}
}
