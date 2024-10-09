package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "1":
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "2":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "3":
					if (!deque.isEmpty()) {
						sb.append(deque.pollFirst()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "4":
					if (!deque.isEmpty()) {
						sb.append(deque.pollLast()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "5":
					sb.append(deque.size()).append("\n");
					break;
				case "6":
					if (deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "7":
					if (!deque.isEmpty()) {
						sb.append(deque.peekFirst()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "8":
					if (!deque.isEmpty()) {
						sb.append(deque.peekLast()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
