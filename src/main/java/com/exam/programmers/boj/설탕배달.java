package com.exam.programmers.boj;

import java.util.Scanner;

public class 설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution solution = new Solution();
		System.out.println(solution.sol(n));
	}

	private static class Solution {
		private int sol(int n) {
			int count = 0;
			while (n >= 0) {
				if (n % 5 == 0) {
					return n / 5 + count;
				} else {
					n -= 3;
					count++;
				}
			}
			return -1;
		}
	}
}
