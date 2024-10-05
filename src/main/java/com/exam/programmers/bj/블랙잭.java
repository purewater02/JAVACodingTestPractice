package com.exam.programmers.bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Solution solution = new Solution();
		int[] cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
		System.out.println(solution.sol(cards, m));
	}

	private static class Solution {
		public int sol(int[] cards, int target) {
			// cards 배열에서 3장 고르기 (조합)
			List<List<Integer>> result = new ArrayList<>();
			combination(cards, result, new ArrayList<>(), cards.length, 3, 0);

			int max = result.stream()
					.filter(list -> list.stream().mapToInt(Integer::intValue).sum() <= target)
					.max((list1, list2) -> list1.stream().mapToInt(Integer::intValue).sum() - list2.stream().mapToInt(Integer::intValue).sum())
					.map(list -> list.stream().mapToInt(Integer::intValue).sum())
					.get();

			return max;
		}

		private static void combination(int[] arr, List<List<Integer>> result, List<Integer> temp, int n, int r, int start) {
			if (temp.size() == r) {
				result.add(new ArrayList<>(temp));
				return;
			}

			for (int i = start; i < n; i++) {
				temp.add(arr[i]);
				combination(arr, result, temp, n, r, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
