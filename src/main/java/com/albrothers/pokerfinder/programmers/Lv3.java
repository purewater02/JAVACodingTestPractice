package com.albrothers.pokerfinder.programmers;

import java.util.*;

public class Lv3 {
	public static void main(String[] args) {
		등굣길DP solution1 = new 등굣길DP();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(solution1.solution(m, n, puddles));
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

	private static class 이중우선순위큐 {
		public int[] solution(String[] operations) {
			int[] answer = {};
			Deque<Integer> que = new ArrayDeque<>();
			for (String operation: operations) {
				String[] split = operation.split(" ");
				if (split[0].equals("I")) {
					que.add(Integer.parseInt(split[1]));
				} else {
					if (que.isEmpty()) {
						continue;
					}
					if (split[1].equals("1")) {
						que.remove(que.stream().max(Integer::compareTo).get());
					} else {
						que.remove(que.stream().min(Integer::compareTo).get());
					}
				}
			}

			if (que.isEmpty()) {
				answer = new int[] {0, 0};
			} else {
				answer = new int[] {que.stream().max(Integer::compareTo).get(), que.stream().min(Integer::compareTo).get()};
			}

			return answer;
		}
	}

	private static class 정수삼각형 {
		public int solution(int[][] triangle) {
			int answer = 0;

			for (int i = 1; i < triangle.length ; i++) {
				for (int j = 0; j < triangle[i].length; j++) {
					if (j == 0) {
						triangle[i][j] += triangle[i-1][j];
					} else if (j == triangle[i].length - 1) {
						triangle[i][j] += triangle[i-1][j-1];
					} else {
						triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
					}
				}
			}

			answer = Arrays.stream(triangle[triangle.length - 1]).max().orElseGet(() -> 0);

			return answer;
		}

	}

	private static class 등굣길_dfs_시간초과 {
		static final int[] dx = {1, 0};
		static final int[] dy = {0, 1};

		static int answer = 0;

		static Set<String> puddleSet = new HashSet<>();
		public int solution(int m, int n, int[][] puddles) {
			for (int[] puddle : puddles) {
				puddleSet.add(String.format("%d, %d", puddle[0], puddle[1]));
			}
			dfs(1, 1, m, n);

			return answer;
		}

		private static void dfs(int curX, int curY, int m, int n) {
			String current = String.format("%d, %d", curX, curY);
			if (puddleSet.contains(current)) {
				return;
			}

			System.out.println(String.format("curX: %d, curY: %d", curX, curY));
			if (curX == m && curY == n) {
				System.out.println(String.format("answer: %d", answer));
				answer = (answer + 1) % 1_000_000_007;
				return;
			}

			for (int i = 0; i < 2; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX > m || nextY > n) continue;
				dfs(nextX, nextY, m, n);
			}
		}
	}

	private static class 등굣길DP {
		public int solution(int m, int n, int[][] puddles) {
			// 이건 사실상 계단 문제랑 비슷한 거임. 어떤 지점에 가는 경우의 수 = 위에서 오는 경로 + 왼쪽에서 오는 경로임.
			// 어떤 지점에 가는 경우의 수를 담은 DP 테이블을 만들어야 함.
			// DP 테이블을 만들 때, 물웅덩이가 있는 곳은 0으로 초기화해야 함.
			int[][] dp = new int[m+1][n+1];
			dp[1][1] = 1;

			for (int[] puddle : puddles) {
				dp[puddle[0]][puddle[1]] = -1;
			}

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (dp[i][j] == -1) {
						dp[i][j] = 0; // 웅덩이인 경우 0. 못 가니까.
						continue;
					}

					if (i > 1) {
						dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1_000_000_007;
					}

					if (j > 1) {
						dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1_000_000_007;
					}
				}
			}

			return dp[m][n];
		}
	}

	private static class 숫자게임 {
		public int solution(int[] A, int[] B) {
			int answer = 0;
			Arrays.sort(A);
			Arrays.sort(B);

			int i = 0;
			int j = 0;

			while (i < A.length && j < B.length) {
				if (A[i] < B[j]) {
					answer++;
					i++;
					j++;
				} else {
					j++;
				}
			}

			return answer;
		}

	}

	private static class 숫자게임_큐 {
		public int solution(int[] A, int[] B) {
			int answer = 0;

			Arrays.sort(A);
			Arrays.sort(B);

			Deque<Integer> dequeA = new ArrayDeque<>();
			Deque<Integer> dequeB = new ArrayDeque<>();

			for (int i = 0; i < A.length; i++) {
				dequeA.offerLast(A[i]);
				dequeB.offerLast(B[i]);
			}

			while (!dequeA.isEmpty() && !dequeB.isEmpty()) {
				if (dequeA.peekFirst() < dequeB.peekFirst()) {
					dequeA.pollFirst();
					dequeB.pollFirst();
					answer++;
				} else {
					dequeB.pollFirst();
				}
			}

			return answer;
		}
	}

	private static class 단속카메라_그리디 {
		public int solution(int[][] routes) {
			int answer = 0;
			// 차량 진출 지점 기준으로 오름차순 정렬
			Arrays.sort(routes, Comparator.comparingInt(e -> e[1]));

			int camera = Integer.MIN_VALUE;
			// 제일 먼저 진출하는 차량부터 진출하는 지점에 카메라 설치
			// 그 다음 차량을 확인해서 카메라 위치보다 진입 지점이 나중에 있다면 추가 설치.
			for (int i = 0; i < routes.length; i++) {
				if (camera < routes[i][0]) {
					camera = routes[i][1];
					answer++;
				}
			}
			return answer;
		}
	}

	private static class 섬연결하기_그리디_최소신장트리_Kruskal {
		public int solution(int n, int[][] costs) {
			int answer = 0;

			// 그래프를 만들어서 최소 비용으로 연결되는 다리를 찾아야 함.
			// n-1개의 다리면 다 연결이 되지만 순환이 없어야 함. => Kruskal 알고리즘을 사용해야 함.
			// 참고: https://youtu.be/jSZT_INJKK8
			// 모든 노드가 최소 한 개의 다리는 가지고 있어야 함.
			// 그리디 알고리즘을 사용하면 됨.
			// 최소 비용으로 연결되는 다리를 찾기 위해 비용을 기준으로 오름차순 정렬.
			Arrays.sort(costs, Comparator.comparingInt(e -> e[2]));

			// Union-Find 알고리즘을 사용해야 함.
			// 처음에는 모든 노드가 자기 자신을 가리키도록 함.
			int[] parent = new int[n];

			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < costs.length ; i++) {
				if (findParent(costs[i][0], parent) != findParent(costs[i][1], parent)) {
					unionParent(costs[i][0], costs[i][1], parent);
					answer += costs[i][2];
				}
			}

			return answer;
		}

		private int findParent(int node, int[] parent) {
			if (parent[node] != node) {
				parent[node] = findParent(parent[node], parent);
			}
			return parent[node];
		}

		private void unionParent(int a, int b, int[] parent) {
			int rootA = findParent(a, parent);
			int rootB = findParent(b, parent);

			if (rootA < rootB) {
				parent[rootB] = rootA;
			} else {
				parent[rootA] = rootB;
			}
		}
	}

	private static class 합승택시요금 {
		public int solution(int n, int s, int a, int b, int[][] fares) {
			int answer = 0;
			return answer;
		}
	}
}
