package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베라의패션 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// n! / (n-2)!
		int result = (n * (n - 1));
		System.out.println(result);
	}
}
