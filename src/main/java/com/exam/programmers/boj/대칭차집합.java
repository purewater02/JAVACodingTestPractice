package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> union = new HashSet<>();
		union.addAll(setA);
		union.addAll(setB);

		Set<Integer> intersection = new HashSet<>();
		setA.forEach(e -> {
			if (setB.contains(e)) {
				intersection.add(e);
			}
		});

		union.removeAll(intersection);

		System.out.println(union.size());
	}
}
