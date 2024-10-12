package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 녹색거탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = (int) Math.pow(2, n);
		System.out.println(result);
	}
}
