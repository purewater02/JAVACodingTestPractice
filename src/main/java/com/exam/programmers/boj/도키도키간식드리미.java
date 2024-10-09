package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도키도키간식드리미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		Solution solution = new Solution();
		solution.sol(queue, stack);
	}

	private static class Solution {
		private void sol(Queue<Integer> queue, Stack<Integer> stack) {
			int count = 1;
			// 먼저 대기열부터 처리
			while (!queue.isEmpty()) {
				if (queue.peek() == count) {
					queue.poll();
					count++;
				} else if (!stack.isEmpty() && stack.peek() == count) {
					stack.pop();
					count++;
				} else {
					stack.push(queue.poll());
				}
			}

			// 잔반 처리
			while (!stack.isEmpty()) {
				if (stack.peek() == count) {
					stack.pop();
					count++;
				} else {
					System.out.println("Sad");
					return;
				}
			}

			System.out.println("Nice");
		}
	}
}
