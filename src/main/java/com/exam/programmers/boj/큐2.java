package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Solution solution = new Solution();
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			solution.sol(command, br, sb, queue);
		}
		System.out.println(sb);
	}

	private static class Solution {
		private void sol(String command, BufferedReader br, StringBuilder sb, Queue<Integer> queue) throws IOException {
			switch (command) {
				case "pop":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.poll()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(((LinkedList<Integer>) queue).getLast()).append("\n");
					}
					break;
				default:
					StringTokenizer st = new StringTokenizer(command);
					st.nextToken();
					int x = Integer.parseInt(st.nextToken());
					queue.add(x);
					break;
			}
		}
	}
}
