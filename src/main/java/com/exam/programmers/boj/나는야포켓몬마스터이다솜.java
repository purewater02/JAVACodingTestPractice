package com.exam.programmers.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer, String> numToPokemon = new HashMap<>();
		Map<String, Integer> pokemonToNum = new HashMap<>();
		List<String> questionList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			numToPokemon.put(i + 1, name);
			pokemonToNum.put(name, i + 1);
		}
		for (int i = 0; i < m; i++) {
			questionList.add(br.readLine());
		}
		Solution solution = new Solution();
		solution.sol(numToPokemon, pokemonToNum, questionList);
	}

	private static class Solution {
		private void sol(Map<Integer, String> numToPokemon, Map<String, Integer> pokemonToNum, List<String> questionList) {
			StringBuilder sb = new StringBuilder();
			for (String question : questionList) {
				if (Character.isDigit(question.charAt(0))) {
					String name = numToPokemon.get(Integer.parseInt(question));
					sb.append(name).append("\n");
				} else {
					int num = pokemonToNum.get(question);
					sb.append(num).append("\n");
				}
			}
			System.out.print(sb);
		}
	}
}
