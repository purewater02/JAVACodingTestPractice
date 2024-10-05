package com.exam.programmers.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 나이순정렬 {
	private static class Person {
		int age;
		String name;
		int index;

		public Person(int age, String name, int index) {
			this.age = age;
			this.name = name;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int age = Integer.parseInt(str[0]);
			String name = str[1];
			list.add(new Person(age, name, count));
			count++;
		}
		Solution solution = new Solution();
		solution.sol(list);
	}

	private static class Solution {
		private void sol(List<Person> list) {
			list.stream().sorted((p1, p2) -> {
				if (p1.age == p2.age) {
					return p1.index - p2.index;
				} else {
					return p1.age - p2.age;
				}
			}).forEach(p -> {
				System.out.println(p.age + " " + p.name);
			});
		}
	}
}
