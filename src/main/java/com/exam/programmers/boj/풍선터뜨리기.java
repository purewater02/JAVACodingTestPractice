package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 풍선터뜨리기 {

	static class Balloon {
		int num;
		int index;

		public Balloon(int num, int index) {
			this.num = num;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Balloon> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			deque.add(new Balloon(num, i + 1));
		}
		Solution solution = new Solution();
		solution.sol(deque);
	}

	private static class Solution {
		private void sol(Deque<Balloon> deque) {
			StringBuilder sb = new StringBuilder();
			Balloon polled = deque.pollFirst();
			sb.append(polled.index).append(" ");
			while (!deque.isEmpty()) {
				if (polled.num > 0) {
					for (int i = 0; i < polled.num - 1; i++) {
						deque.addLast(deque.pollFirst());
					}
					polled = deque.pollFirst();
					sb.append(polled.index).append(" ");
				} else {
					for (int i = 0; i < Math.abs(polled.num) - 1; i++) {
						deque.addFirst(deque.pollLast());
					}
					polled = deque.pollLast();
					sb.append(polled.index).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
