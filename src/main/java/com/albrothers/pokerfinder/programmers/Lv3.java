package com.albrothers.pokerfinder.programmers;

import java.util.*;

public class Lv3 {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1);
	}

	private static class 네트워크_재도전해보기 {
		public int solution(int n, int[][] computers) {
			int answer = 0;
			boolean[] visited = new boolean[n];
			Deque<Integer> deque = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					continue;
				}

				deque.offer(i);
				answer++;

				while (!deque.isEmpty()) {
					int current = deque.poll();
					if (visited[current]) {
						continue;
					}
					visited[current] = true;

					for (int j = 0; j < n; j++) {
						if (computers[current][j] == 1 && !visited[j]) {
							deque.offer(j);
						}
					}
				}
			}
			return answer;
		}
	}

	private static class 여행경로 {

		List<String> route;
		public String[] solution(String[][] tickets) {
			route = new ArrayList<>();

			Map<String, List<String>> graph = new HashMap<>();
			for (String[] ticket : tickets) {
				graph.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
			}

			for (List<String> dest : graph.values()) {
				dest.sort(Comparator.naturalOrder());
			}

			dfs("ICN", tickets.length, graph, new ArrayList<>());

			return route.toArray(new String[0]);
		}

		private boolean dfs(String current, int remain, Map<String, List<String>> graph, List<String> path) {
			path.add(current);

			if (remain == 0) {
				route = new ArrayList<>(path);
				return true;
			}

			if (graph.containsKey(current)) {
				for (int i = 0; i < graph.get(current).size(); i++) {
					String next = graph.get(current).remove(i);
					if (dfs(next, remain - 1, graph, path)) {
						return true;
					}
					graph.get(current).add(i, next); // 백트래킹
				}
			}

			path.remove(path.size() - 1);
			return false;
		}
	}

	private static class 단어변환 {
		List<Integer> answerList = new ArrayList<>();
		Map<String, Boolean> visited = new HashMap<>();

		public int solution(String begin, String target, String[] words) {
			Map<String, List<String>> graph = new HashMap<>();
			List<String> newWords = new ArrayList<>(Arrays.asList(words));
			newWords.add(begin);
			for (String word : newWords) {
				visited.put(word, false);
				graph.put(word, new ArrayList<>());
				// 현재 word를 제외한 나머지 word 중에서 한 글자만 다른 것을 찾아 넣는다.
				for (String other : words) {
					if (isOneDiff(word, other)) {
						graph.get(word).add(other);
					}
				}
			}

			dfs(begin, target, graph, 0);

			return answerList.stream().min(Comparator.comparingInt(Integer::intValue)).orElseGet(() -> 0);
		}

		private boolean isOneDiff(String a, String b) {
			int diff = 0;
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i)) {
					diff++;
				}
			}
			return diff == 1;
		}

		private void dfs(String current, String target, Map<String, List<String>> graph, int count) {
			if (current.equals(target)) {
				answerList.add(count);
				return;
			}

			visited.put(current, true);

			if (graph.containsKey(current)) {
				for (int i = 0; i < graph.get(current).size(); i++) {
					String next = graph.get(current).get(i);
					if (Boolean.TRUE.equals(visited.get(next))) continue;
					dfs(next, target, graph, count + 1);
				}

				visited.put(current, false); // 백트래킹
			}
		}
	}

}
