package com.exam.programmers.bj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 좌표정렬하기 {
	public static class Coord {
		int x;
		int y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Coord> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			list.add(new Coord(x, y));
		}
		Solution solution = new Solution();
		solution.sol(list);
	}

	private static class Solution {
		private void sol(List<Coord> list) throws IOException {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			List<Coord> sortedList = list.stream().sorted((c1, c2) -> {
				if (c1.x == c2.x) {
					return c1.y - c2.y;
				}
				return c1.x - c2.x;
			}).collect(Collectors.toList());

			for (int i = 0; i < sortedList.size(); i++) {
				Coord coord = sortedList.get(i);
				bw.write(coord.x + " " + coord.y);
				if (i != sortedList.size() - 1) {
					bw.write("\n");
				}
			}

			bw.flush();
			bw.close();
		}
	}
}
