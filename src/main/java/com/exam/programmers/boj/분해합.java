package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Solution solution = new Solution();
		System.out.println(Solution.sol(n));
	}

	private static class Solution {
		private static int sol(int n) {
			// 생성자 찾기
			int tempSum;

			for (int i = 1; i < n; i++) {
				int indexSum = 0;
				int temp = i;

				while (temp > 0) {
					indexSum += temp % 10;
					temp /= 10;
				}

				tempSum = i + indexSum;

				if (tempSum == n) {
					return i; // 가장 작은 생성자를 찾는 것이기 때문에 return을 여기서 만나면 정답
				}
			}
			return 0; // 생성자가 없는 경우
		}
	}
}
