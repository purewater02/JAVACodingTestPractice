package com.exam.programmers.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		System.out.println(Solution.sol(a, b, c, d, e, f));
	}

	private static class Solution {
		private static String sol(int a, int b, int c, int d, int e, int f) {
			int x = 0;
			int y = 0;
			int denominator = a * e - b * d;
			x = (c * e - b * f) / denominator;
			y = (a * f - c * d) / denominator;
			return x + " " + y;
		}
	}
}
