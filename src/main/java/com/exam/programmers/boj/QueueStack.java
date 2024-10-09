package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QueueStack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] type = new int[n];
		for (int i = 0; i < n; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (type[i] == 0) {
				deque.addLast(num);
			}
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			deque.addFirst(num);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
