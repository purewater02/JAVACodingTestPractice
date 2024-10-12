package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class 다리놓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			BigDecimal result = factorial(m).divide((factorial(n).multiply(factorial(m - n))));
			System.out.println(result);
		}
	}

	private static BigDecimal factorial(int n) {
		if (n == 0 || n == 1) {
			return BigDecimal.ONE;
		}
		BigDecimal result = BigDecimal.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigDecimal.valueOf(i));
		}
		return result;
	}
}
