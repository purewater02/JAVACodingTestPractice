package com.albrothers.pokerfinder.programmers;

import java.util.Arrays;

public class Lv2 {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.solution("1 2 3 4"));
	}

	private static class Solution1 {
		public String solution(String s) {
			String[] stringArr = s.split(" ");
			int[] intArr = new int[stringArr.length];
			for (int i = 0; i < stringArr.length; i++) {
				intArr[i] = Integer.parseInt(stringArr[i]);
			}
			int min = Arrays.stream(intArr).min().getAsInt();
			int max = Arrays.stream(intArr).max().getAsInt();
			StringBuilder sb = new StringBuilder();
			sb.append(min).append(" ").append(max);
			return sb.toString();
		}
	}
}
