package com.exam.programmers;


import java.util.*;
import java.util.stream.Collectors;

public class InflearnJavaPS {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		int input2 = in.nextInt();
		int[] intArray = new int[input1];
		for (int i = 0; i < input1; i++) {
			intArray[i] = in.nextInt();
		}
		응급실 sol = new 응급실();
		sol.solution(input1, input2, intArray);
	}

	private static class 문자찾기 {
		private int solution(String str, char target) {
			int answer = 0;
			str = str.toUpperCase();
			target = Character.toUpperCase(target);
			for (char c : str.toCharArray()) {
				if (c == target) {
					answer++;
				}
			}

			return answer;
		}
	}

	private static class 대소문자변환 {
		private String solution(String str) {
			StringBuilder answer = new StringBuilder();
			for (char c : str.toCharArray()) {
				if (Character.isLowerCase(c)) {
					answer.append(Character.toUpperCase(c));
				} else {
					answer.append(Character.toLowerCase(c));
				}
			}
			return answer.toString();
		}
	}

	private static class 문장속단어 {
		private String solution(String str) {
			String[] words = str.split(" ");
			String answer = "";
			for (String word : words) {
				if (word.length() > answer.length()) {
					answer = word;
				}
			}
			return answer;
		}
	}

	private static class 가장짧은문자거리 {
		private String solution(String str, char c) {
			char[] chars = str.toCharArray();
			int n = str.length();
			int[] distancesLeft = new int[n];
			int[] distancesRight = new int[n];
			int[] result = new int[n];

			int targetIndex = -1000;
			for (int i = 0; i < str.length(); i++) {
				if (chars[i] == c) {
					targetIndex = i;
				}
				distancesLeft[i] = i - targetIndex;
			}

			targetIndex = 1000;
			for (int i = str.length() - 1; i >= 0; i--) {
				if (chars[i] == c) {
					targetIndex = i;
				}
				distancesRight[i] = targetIndex - i;
			}

			for (int i = 0; i < n; i++) {
				result[i] = Math.min(distancesLeft[i], distancesRight[i]);
			}

			return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		}
	}

	private static class 두배열합치기 {
		private List<Integer> solution(int[] a, int[] b) {
			List<Integer> list = new ArrayList<>();
			for (int i : a) {
				list.add(i);
			}
			for (int i : b) {
				list.add(i);
			}
			list.sort(Integer::compareTo);
			return list;
		}
	}

	private static class 공통원소구하기 {
		private List<Integer> solution(int[] a, int[] b) {
			List<Integer> aList = new ArrayList<>(Arrays.stream(a).boxed().toList());
			List<Integer> bList = Arrays.stream(b).boxed().toList();

			aList.addAll(bList);
			// aList 의 원소들 중 2번 등장하는 것들만 필터링
			return aList.stream().filter(i -> Collections.frequency(aList, i) > 1).distinct().sorted().collect(Collectors.toList());
		}
	}

	private static class 공통원소구하기_Set교집합활용 {
		private List<Integer> solution(Set<Integer> a, Set<Integer> b) {
			a.retainAll(b); // setA에 setB와의 교집합만 남김.

			List<Integer> result = new ArrayList<>(a);
			result.sort(Integer::compareTo);

			return result;
		}
	}

	private static class 공통원소구하기_투포인터활용 {
		private List<Integer> solution(int[] a, int[] b) {
			List<Integer> answer = new ArrayList<>();
			Arrays.sort(a);
			Arrays.sort(b);
			int p1 = 0, p2 = 0;
			while (p1 < a.length && p2 < b.length) {
				if (a[p1] == b[p2]) {
					answer.add(a[p1]);
					p1++;
					p2++;
				} else if (a[p1] < b[p2]) {
					p1++;
				} else {
					p2++;
				}
			}
			answer.forEach(i -> System.out.println(i + " "));
			return answer;
		}
	}

	private static class 학급회장 {
		private void solution(String str) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : str.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			map.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e -> {
				System.out.print(e.getKey());
			});
		}
	}

	private static class 아나그램 {
		private void solution(String a, String b) {
			Map<Character, Integer> mapA = new HashMap<>();
			Map<Character, Integer> mapB = new HashMap<>();
			for (char c : a.toCharArray()) {
				mapA.put(c, mapA.getOrDefault(c, 0) + 1);
			}
			for (char c : b.toCharArray()) {
				mapB.put(c, mapB.getOrDefault(c, 0) + 1);
			}
			if (mapA.equals(mapB)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static class 매출액의종류 {
		private void solution(int n, int k, int[] arr) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n - k  + 1; i++) {
				for (int j = i; j < i + k; j++) {
					set.add(arr[j]);
				}
				if (i == n - k) {
					System.out.print(set.size());
				} else {
					System.out.print(set.size() + " ");
				}
				set.clear();
			}
		}
	}

	private static class 올바른괄호 {
		private void solution(String str) {
			Deque<Character> stack = new ArrayDeque<>();
			for (char c : str.toCharArray()) {
				if (stack.isEmpty()) {
					stack.addLast(c);
					continue;
				}
				if (c == '(') {
					stack.addLast(c);
				} else if (c == ')' && stack.peekLast().equals('(')) {
					stack.pollLast();
				}
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static class 응급실 {
		private static class Person {
			int id;
			int priority;

			public Person(int id, int priority) {
				this.id = id;
				this.priority = priority;
			}
		}

		private void solution(int n, int m, int[] arr) {
			Deque<Person> queue = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				queue.addLast(new Person(i, arr[i]));
			}
			int answer = 0;
			while (!queue.isEmpty()) {
				Person current = queue.pollFirst();
				if (queue.stream().anyMatch(person -> person.priority > current.priority)) {
					queue.addLast(current);
				} else {
					answer++;
					if (current.id == m) {
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}


}
