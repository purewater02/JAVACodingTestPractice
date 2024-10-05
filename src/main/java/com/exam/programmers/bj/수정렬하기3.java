package com.exam.programmers.bj;

import java.io.*;

public class 수정렬하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[10001];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num >= 1 && num <= 10000) {
				count[num]++;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
