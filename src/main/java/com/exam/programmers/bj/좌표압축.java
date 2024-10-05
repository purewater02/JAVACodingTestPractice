package com.exam.programmers.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 좌표압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> sortedList = list.stream().distinct().sorted().collect(Collectors.toList());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < sortedList.size(); i++) {
			map.put(sortedList.get(i), i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(map.get(list.get(i))).append(" ");
		}
		System.out.println(sb);
	}
}
