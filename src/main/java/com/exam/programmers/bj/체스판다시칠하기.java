package com.exam.programmers.bj;

import java.util.Scanner;

public class 체스판다시칠하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();

		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = sc.nextLine().toCharArray();
		}

		int minChanges = Integer.MAX_VALUE;

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				minChanges = Math.min(minChanges, calculateRepaint(board, i, j));
			}
		}
		System.out.println(minChanges);
	}

	private static int calculateRepaint(char[][] board, int n, int m) {
		char[][] pattern1 = {
				{'W', 'B'}, {'B', 'W'}
		};
		char[][] pattern2 = {
				{'B', 'W'}, {'W', 'B'}
		};

		int count1 = 0;
		int count2 = 0;

		for (int i = n; i < n + 8; i++) {
			for (int j = m; j < m + 8; j++) {
				if (board[i][j] != pattern1[i % 2][j % 2]) {
					count1++;
				}
				if (board[i][j] != pattern2[i % 2][j % 2]) {
					count2++;
				}
			}
		}

		return Math.min(count1, count2);
	}
}
