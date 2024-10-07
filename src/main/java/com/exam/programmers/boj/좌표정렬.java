package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 좌표정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		Solution solution = new Solution();
		solution.sol(list);
	}

	private static class Solution {
		private void sol(List<String> list) {
			list.stream().distinct().sorted((s1, s2) -> {
				int size1 = s1.length();
				int size2 = s2.length();
				if (size1 == size2) {
					return s1.compareTo(s2);
				} else {
					return size1 - size2;
				}
			}).forEach(s -> {
				System.out.println(s);
			});
		}
	}
}
