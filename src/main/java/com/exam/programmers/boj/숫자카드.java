package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> sangunList = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sangunList.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		List<Integer> targetList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			targetList.add(Integer.parseInt(st.nextToken()));
		}

		Solution solution = new Solution();
		solution.sol(sangunList, targetList);
	}

	private static class Solution {
		private void sol(List<Integer> sangunList, List<Integer> targetList) {
			StringBuilder sb = new StringBuilder();

			sangunList.sort(Comparator.naturalOrder());

			int rt = sangunList.size();
			int lt = 0;

			for (int i = 0; i < targetList.size(); i++) {
				int target = targetList.get(i);
				boolean flag = false;
				while (lt <= rt) {
					int mid = (lt + rt) / 2;
					if (mid >= sangunList.size()) {
						break;
					}
					if (sangunList.get(mid) == target) {
						flag = true;
						break;
					} else if (sangunList.get(mid) < target) {
						lt = mid + 1;
					} else {
						rt = mid - 1;
					}
				}
				sb.append(flag ? 1 : 0).append(" ");
				lt = 0;
				rt = sangunList.size();
			}

			System.out.println(sb);
		}
	}
}
