package com.exam.programmers;

import java.util.*;

public class Lv2 {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		String str = "3people  Unfollowed  Me";
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

	private static class Solution2 {
		boolean solution(String s) {
			Deque<Character> deque = new ArrayDeque<>();

			for (char c : s.toCharArray()) {
				if (deque.isEmpty()) {
					deque.addFirst(c);
					continue;
				}

				if (deque.peekFirst() == '(' && c == ')') {
					deque.removeFirst();
				} else {
					deque.add(c);
				}
			}

			return deque.isEmpty();
		}
	}

	private static class Solution3 {
		public int solution (int[] A, int[] B) {
			// A를 오름차순으로, B를 내림차순으로 정렬한 뒤 요소끼리 곱한 값을 더한다.
			Arrays.sort(A);
			// int[] descendingB = Arrays.stream(B).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
			// 주석처럼 stream을 사용하면 Integer로 갔다가 다시 int로 돌아오느라 성능 떨어짐.
			Arrays.sort(B);

			int answer = 0;

			for (int i = 0; i < A.length; i++) {
				// 걍 내림차순 정렬하지 말고 오름차순 정렬해서 역순으로 순회시킴.
				answer += A[i] * B[A.length - i - 1];
			}

			return answer;
		}
	}

	private static class Solution4 {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
			boolean capitalizeNext = true;

			for (char c : s.toCharArray()) {
				if (c == ' ') {
					sb.append(c);
					capitalizeNext = true;
				} else {
					if (capitalizeNext) {
						sb.append(Character.toUpperCase(c));
					} else {
						sb.append(Character.toLowerCase(c));
					}
					capitalizeNext = false;
				}
			}

			return sb.toString();
		}
	}

	private static class Solution5 {
		public int[] solution(String s) {
			int [] answer = {};
			int zeroCount = 0;
			int count = 0;
			while (!Objects.equals(s, "1")) {
				String zeroRemovedString = s.replace("0", "");
				int zeroRemovedStringLength = zeroRemovedString.length();
				count++;
				zeroCount += s.length() - zeroRemovedStringLength;
				s = zeroRemovedStringLength == 1 ? "1" : Integer.toBinaryString(zeroRemovedStringLength);
			}
			answer = new int[]{count, zeroCount};
			return answer;
		}
	}

	private static class Solution6 {
		public int solution(int n) {
			int answer = 0;
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j++) {
					sum += j;
					if (sum == n) {
						answer++;
						sum = 0;
						break;
					} else if (sum > n) {
						sum = 0;
						break;
					}
				}
			}
			return answer;
		}
	}

	private static class Solution7 {
		public int solution(int n) {
			int countOnes = Integer.bitCount(n);

			int nextNumber = n + 1;

			while (true) {
				int countOnesInNext = Integer.bitCount(nextNumber);
				if (countOnes == countOnesInNext) {
					return nextNumber;
				}
				nextNumber++;
			}
		}
	}

	private static class Solution8 {
		static int[] memo = new int[100001];
		public int solution(int n) {
			return getFibonacci(n);
		}

		public static int getFibonacci(int n) {
			if (n == 0) {
				return 0;
			} else if (n == 1) {
				return 1;
			} else {
				if (memo[n] == 0) {
					memo[n] = (getFibonacci(n - 1) + getFibonacci(n - 2)) % 1234567;
				}
				return memo[n];
			}
		}

	}

	private static class Solution9 {
		public int solution(String s) {
			Deque<Character> deque = new ArrayDeque<>();
			for (char c : s.toCharArray()) {
				if (deque.isEmpty()) {
					deque.addFirst(c);
				} else {
					if (deque.peekFirst() == c) {
						deque.removeFirst();
					} else {
						deque.addFirst(c);
					}
				}
			}

			return deque.isEmpty() ? 1 : 0;
		}
	}

	private static class Solution10 {
		public int[] solution(int brown, int yellow) {
			int[] answer = {};
			int total = brown + yellow;
			for (int i = 3; i <= total; i++) {
				if (total % i == 0) {
					int width = total / i;
					int height = i;
					if ((width - 2) * (height - 2) == yellow) {
						answer = new int[]{width, height};
						break;
					}
				}
			}
			return answer;
		}
	}

	private static class Solution11 {
		public int solution(int[] people, int limit) {
			int answer = 0;
			// 탐욕법 사용
			Arrays.sort(people);
			int left = 0; // 가장 가벼운 사람
			int right = people.length - 1; // 가장 무거운 사람

			while (left <= right) {
				if (people[left] + people[right] <= limit) {
					left++;
				}
				right--; // 무거운 사람은 항상 태워야 함.
				answer++;
			}
			return answer;
		}
	}

	private static class Solution12 {
		// 택배 배달과 수거 문제
		public long solution(int cap, int n, int[] deliveries, int[] pickups) {
			// 가장 멀리있는 집부터 배달, 수거 해야 한다.
			long distance = 0;
			int delivery = 0;
			int pickup = 0;
			for (int i = n - 1; i >= 0; i--) {
				// 배달 또는 수거할 게 하나라도 있으면 방문해야 함.
				if (deliveries[i] > 0 || pickups[i] > 0) {
					delivery += deliveries[i];
					pickup += pickups[i];
				}
				while (delivery > 0 || pickup > 0) {
					// 한 번에 최대 적재 가능 용량까지 가능. 배달 / 수거가 하나라도 남은 경우 방문해야 함.
					// delivery, pickup이 음수인 상태는 오면서/가면서 처리했다는 뜻임.
					delivery -= cap;
					pickup -= cap;
					distance += (long) (i + 1) * 2;
				}
			}

			return distance;
		}
	}

	private static class Solution13 {
		public int solution(int[][] land) {
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, -1, 0, 1};

			Queue<int[]> que = new LinkedList<>();
			int[] totalOilByX = new int[land[0].length];

			for (int x = 0; x < land[0].length; x++) {
				for (int y = 0; y < land.length; y++) {
					if (land[y][x] == 0 || land[y][x] == -1) continue;
					que.offer(new int[] {x, y});
					int cnt = 0;
					int[] visitedX = new int[land[0].length];

					while (!que.isEmpty()) {
						int[] cur = que.poll();
						int curX = cur[0];
						int curY = cur[1];

						if (land[curY][curX] == 0 || land[curY][curX] == -1 || curX >= land[0].length || curX < 0 || curY < 0) continue;

						cnt++;
						land[curY][curX] = -1;
						visitedX[curX] = 1;

						for (int i = 0; i < 4; i++) {
							int nextX = curX + dx[i];
							int nextY = curY + dy[i];
							if (nextX < 0 || nextY < 0 || nextX >= land[0].length || nextY >= land.length || land[nextY][nextX] == -1 || land[nextY][nextX] == 0) continue;
							que.offer(new int[] {nextX, nextY});
						}
					}

					for (int j = 0; j < visitedX.length; j++) {
						if (visitedX[j] == 1) {
							totalOilByX[j] += cnt;
						}
					}
				}
			}

			return Arrays.stream(totalOilByX).max().getAsInt();
		}
	}

	private static class Solution14 {
		int[] numbers;
		int target;
		int answer;

		void dfs (int index, int sum) {
			if (index == numbers.length) {
				if (sum == target) {
					answer++;
				}
				return;
			}

			dfs(index + 1, sum + numbers[index]);
			dfs(index + 1, sum - numbers[index]);
		}

		public int solution(int[] numbers, int target) {
			this.numbers = numbers;
			this.target = target;

			dfs(0,0);

			return answer;
		}
	}

	private static class Solution15 {
		final int[] dx = {-1, 0, 1, 0};
		final int[] dy = {0, -1, 0, 1};

		int n, m;
		int[][] visited;
		int possibleAnswer = Integer.MAX_VALUE;


		void bfs (int[][] maps) {
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {0, 0, 1});
			visited[0][0] = 1;

			while (!que.isEmpty()) {
				int[] currentPosition = que.poll();
				int x = currentPosition[0];
				int y = currentPosition[1];
				int distance = currentPosition[2];

				for (int i = 0; i < 4; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];

					if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && visited[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
						visited[nextX][nextY] = 1;
						que.add(new int[] {nextX, nextY, distance + 1});

						if (nextX == n - 1 && nextY == m - 1) {
							possibleAnswer = Math.min(possibleAnswer, distance + 1);
						}
					}
				}
			}
		}
		public int solution(int[][] maps) {
			n = maps.length;
			m = maps[0].length;
			visited = new int[n][m];
			bfs(maps);
			if (possibleAnswer == Integer.MAX_VALUE) return -1;
			return possibleAnswer;
		}
	}

	public static class 큰수만들기 {
		public String solution(String number, int k) {
			// 숫자의 순서가 바뀌지 않는 상태에서 k개의 숫자를 제거하는 문제였다.
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < number.length(); i++) {
				int current = number.charAt(i) - '0';

				while (!deque.isEmpty() && k > 0 && deque.peekLast() < current) {
					deque.pollLast();
					k--;
				}

				deque.offerLast(current);
			}

			// 위 과정을 다 했는데 아직 k를 소진하지 못한 케이스 처리
			while (k > 0) {
				deque.pollLast();
				k--;
			}

			StringBuilder sb = new StringBuilder();
			while (!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}

			return sb.toString();
		}
	}

	private static class 징검다리건너기_효율성실패 {
			public int solution(int[] stones, int k) {
				int answer = 0;

				while (Boolean.FALSE.equals(IsConsecutiveZeros(stones, k))) {
					for (int i = 0; i < stones.length; i++) {
						if (stones[i] > 0) {
							stones[i]--;
						}
					}
					answer++;
				}

				return answer;
			}

			private boolean IsConsecutiveZeros(int[] arr, int k) {
				int zeroCount = 0;

				for (int num : arr) {
					if (num == 0) {
						zeroCount++;
						if (zeroCount == k) {
							return true;
						}
					} else {
						zeroCount = 0;
					}
				}

				return false;
			}
	}

	private static class 징검다리건너기_이분탐색 {
		public int solution(int[] stones, int k) {
			int left = 1;
			int right = Arrays.stream(stones).max().getAsInt();
			int answer = 0;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (canCross(stones, k, mid)) {
					answer = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			return answer;
		}

		private boolean canCross(int[] stones, int k, int mid) {
			int zeroCount = 0;

			for (int stone : stones) {
				if (stone - mid < 0) {
					zeroCount++;
					if (zeroCount >= k) {
						// 연속된 0이 k개 이상이면 못 건넌다.
						return false;
					}
				} else {
					zeroCount = 0;
				}
			}

			return true;
		}
	}


	private static class 입국심사_이분탐색 {
		public long solution(int n, int[] times) {
			long answer = 0;
			long left = 1;
			long right = (long) n * Arrays.stream(times).max().getAsInt(); // 여기 형변환 안하면 오답 나옴.

			while (left <= right) {
				long mid = (left + right) / 2;

				if (canProcessAll(n, times, mid)) {
					answer = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			return answer;
		}

		private boolean canProcessAll(int people, int[] times, long mid) {
			long totalPeople = 0;

			for (int time : times) {
				totalPeople += mid / time; // 시도해보려는 최소 시간 동안 각 심사관이 최대 몇 명을 처리할 수 있는지 더함.
				if (totalPeople >= people) {
					return true;
				}
			}

			return totalPeople >= people;
		}
	}


}
