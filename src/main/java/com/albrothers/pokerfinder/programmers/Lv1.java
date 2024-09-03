package com.albrothers.pokerfinder.programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Lv1 {
			public static void main(String[] args) {
				Solution30 sol = new Solution30();
				int answer = sol.solution(new String[] {"joy", "brad", "alessandro", "conan", "david"}, new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"});
				System.out.println(answer);
		}

	private static class Solution1 {
		boolean solution(String s) {
			s = s.toLowerCase();

			int pCount = 0;
			int yCount = 0;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == 'p') {
					pCount++;
				} else if (ch == 'y') {
					yCount++;
				}
			}

			return pCount == yCount;
		}
	}

	private static class Solution2 {
		public int solution(String s) {
			int answer = 0;
			String sign = s.substring(0, 1);
			if (sign.equals("+")) {
				s = s.substring(1);
			} else if (sign.equals("-")) {
				s = s.substring(1);
				answer = Integer.parseInt(s);
				answer = -answer;
				return answer;
			}
			answer = Integer.parseInt(s);
			return answer;
		}
	}

	private static class Solution3 {
		public int solution(int n) {
			int answer = 0;
			String s = Integer.toString(n);
			for (int i = 0; i < s.length(); i++) {
				answer += s.charAt(i) - '0';
			}
			return answer;
		}
	}

	private static class Solution4 {
		public int[] solution(long n) {
			int[] answer = {};
			String s = Long.toString(n);
			answer = new int[s.length()];
			// 문자열을 숫자로 바꿀 때 char로 받은 다음 - '0' 해주면 int로 변환된다.
			for (int i = 0; i < s.length(); i++) {
				answer[i] = s.charAt(s.length() - i - 1) - '0';
			}
			return answer;
		}
	}

	private static class Solution5 {
		public long solution(long n) {
			long answer = 0;
			String s = Long.toString(n);
			List<String> list = new ArrayList<>(List.of(s.split("")));
			list.sort((a, b) -> Integer.parseInt(b) - Integer.parseInt(a));
			String sortedStr = list.stream().collect(Collectors.joining());
			answer = Long.parseLong(sortedStr);
			return answer;
		}
	}

	private static class Solution6 {
		public long solution(long n) {
			long answer = 0;
			// 제곱근이 정수라면 제곱근 + 1을 제곱한 값을 리턴
			if (Math.sqrt(n) % 1 == 0) {
				answer = (long) Math.pow(Math.sqrt(n) + 1, 2);
			} else {
				answer = -1;
			}
			return answer;
		}
	}

	private static class Solution7 {
		public boolean solution(int x) {
			boolean answer = true;
			int sum = 0;
			String s = Integer.toString(x);
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - '0';
			}
			if (x % sum != 0) {
				answer = false;
			}
			return answer;
		}
	}

	private static class Solution8 {
		public long solution(int a, int b) {
			// 두 정수 사이의 합
			long answer = 0;
			if (b > a) {
				for (int i = a; i <= b; i++) {
					answer += i;
				}
			} else if (a > b) {
				for (int i = b; i <= a; i++) {
					answer += i;
				}
			} else {
				answer = a;
			}
			return answer;
		}
	}

	private static class Solution9 {
		// 정수를 담고 있는 배열 arr의 평균값을 return하는 함수
		public double solution(int[] arr) {
			double answer = 0;
			double sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			answer = sum / arr.length;
			return answer;
		}
	}

	private static class Solution10 {
		// 서울에서 김서방 찾기
		public String solution(String[] seoul) {
			String answer = "";
			for (int i = 0; i < seoul.length; i++) {
				if (seoul[i].equals("Kim")) {
					answer = "김서방은 " + i + "에 있다";
				}
			}
			return answer;
		}
	}

	private static class Solution11 {
		public int solution(int num) {
			// 콜라츠 추측
			long longNum = num;
			int answer = 0;
			while (longNum != 1) {
				if (longNum % 2 == 0) {
					longNum /= 2;
				} else {
					longNum = longNum * 3 + 1;
				}
				answer += 1;
				if (answer == 500) {
					answer = -1;
					break;
				}
			}
			return answer;
		}
	}

	private static class Solution12 {
		public int solution(int[] absolutes, boolean[] signs) {
			int answer = 0;
			for (int i = 0; i < absolutes.length; i++) {
				if (signs[i]) {
					answer += absolutes[i];
				} else {
					answer -= absolutes[i];
				}
			}
			return answer;
		}
	}

	private static class Solution13 {
		public int solution(int[] numbers) {
			int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;
			for (int i = 0; i < numbers.length; i++) {
				sum -= numbers[i];
			}
			return sum;
		}
	}

	private static class Solution14 {
		public int[] solution(int[] arr, int divisor) {
			List<Integer> result = new ArrayList<>();
			for (int num : arr) {
				if (num % divisor == 0) {
					result.add(num);
				}
			}
			if (result.isEmpty()) {
				return new int[] {-1};
			}
			Collections.sort(result);

			int[] answer = new int[result.size()];
			for (int i = 0; i < result.size(); i++) {
				answer[i] = result.get(i);
			}

			return answer;
		}
	}

	private static class Solution15 {
		public int[] solution(int[] arr) {
			int[] answer = {};
			List<Integer> list = new ArrayList<>();
			for (int num : arr) {
				list.add(num);
			}
			list.remove(list.stream().min(Integer::compare).get());
			answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			if (list.isEmpty()) {
				return new int[] {-1};
			}
			return answer;
		}
	}

	private static class Solution16 {
		public String solution(String phone_number) {
			String answer = "";
			for (int i = 0; i < phone_number.length(); i++) {
				if (i < phone_number.length() - 4) {
					answer += "*";
				} else {
					answer += phone_number.charAt(i);
				}
			}
			return answer;
		}
	}

	private static class Solution17 {
		public String[] solution(String[] strings, int n) {
			Arrays.sort(strings, (a, b) -> {
				if (a.charAt(n) == b.charAt(n)) {
					return a.compareTo(b);
				} else {
					return Character.compare(a.charAt(n), b.charAt(n));
				}
			});
			return strings;
		}
	}

	private static class Solution18 {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			// 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도
			String[] answer = new String[n];
			String[] binaryArr1 = new String[n];
			String[] binaryArr2 = new String[n];
			for (int i = 0; i < n; i++) {
				binaryArr1[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
				binaryArr2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
			}
			for (int i = 0; i < n; i++) {
				StringBuilder str = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (binaryArr1[i].charAt(j) == '1' || binaryArr2[i].charAt(j) == '1') {
						str.append("#");
					} else {
						str.append(" ");
					}
				}
				answer[i] = str.toString();
			}
			return answer;
		}
	}

	private static class Solution19 {
		public int solution(int a, int b, int n) {
			// 콜라 문제
			int answer = 0;
			while(n >= a) {
				int newCola = (n/a) * b;
				answer += newCola;
				n = newCola + (n % a);
			}
			return answer;
		}
	}

	private static class Solution20 {
		public int[] solution(int k, int[] score) {
			int[] answer = new int[score.length];
			List<Integer> list = new ArrayList<>();
			for (int i : score) {
				list.add(i);
			}

			for (int j = 0; j < score.length; j++) {
				List<Integer> slicedList = list.subList(0, j+1);
				List<Integer> sortedList = slicedList.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());

				if (sortedList.size() >= k) {
					answer[j] = sortedList.get(k-1);
				} else {
					answer[j] = sortedList.get(sortedList.size() - 1);
				}
			}
			return answer;
		}
	}

	private static class Solution21 {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			// Map에 이름 : 추억 점수를 저장
			Map<String, Integer> yearningMap = new HashMap<>();
			for (int i = 0; i < name.length; i++) {
				yearningMap.put(name[i], yearning[i]);
			}

			// 정답 배열 초기화
			int[] answer = new int[photo.length];

			for (int i = 0; i < photo.length; i++) {
				int sum = 0;
				for (String personName : photo[i]) {
					sum += yearningMap.getOrDefault(personName, 0);
				}
				answer[i] = sum;
			}

			return answer;
		}
	}

	private static class Solution22 {
		public String solution(String[] cards1, String[] cards2, String[] goal) {
			// goal의 순서에 맞게 cards1과 cards2에서 뽑을 수 있는지 확인하고 둘 다 안되면 "No"
			int cards1Index = 0;
			int cards2Index = 0;

			for (String word : goal) {
				if (cards1Index < cards1.length && word.equals(cards1[cards1Index])) {
					cards1Index++;
				} else if (cards2Index < cards2.length && word.equals(cards2[cards2Index])) {
					cards2Index++;
				} else {
					return "No";
				}
			}

			return "Yes";
		}
	}

	private static class Solution23 {
		public int solution(int[] nums) {
			int answer = 0;
			// 뽑을 수 있는 포켓몬의 종류 수만 중요하다. 실제로 어떤 걸 뽑았는지 알 필요가 없기 때문에 조합을 이용할 필요가 없음.
			Set<Integer> uniquePokemons = new HashSet<>();
			for (int num : nums) {
				uniquePokemons.add(num);
			}

			// 이 서로다른 포켓몬들 중에 최대 N/2개 선택될 수 있고 N/2개보다 unique한 개수가 적으면 그만큼만이 정답.
			answer = Math.min(nums.length / 2, uniquePokemons.size());

			return answer;
		}
	}

	private static class Solution24 {
		public String solution(int a, int b) {
			String answer = "";
			LocalDate date = LocalDate.of(2016, a, b);
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			answer = dayOfWeek.toString().substring(0, 3);
			return answer;
		}
	}

	private static class Solution25 {
		public int solution(int number, int limit, int power) {
			int answer = 0;

			// number가 10만까지 가기 때문에 O(n^2) 알고리즘은 사용할 수 없다.
			// 약수 찾기는 제곱근까지만 확인하면 된다. 약수는 쌍으로 나오기 때문.
			for (int i = 1; i <= number; i++) {
				int divisors = 0;
				int sqrt = (int) Math.sqrt(i);
				for (int j = 1; j <= sqrt; j++) {
					if (i % j == 0) {
						divisors++; // j = i 인 경우는 여기 포함된다.
						if (j != i / j) {
							divisors++; // j로 나눈 몫도 약수다.
						}
					}
				}
				if (divisors > limit) {
					answer += power;
				} else {
					answer += divisors;
				}
			}

			return answer;
		}
	}

	private static class Solution26 {
		public int[] solution(int[] answers) {
			int[] answer = {};

			int[] person1 = {1, 2, 3, 4, 5};
			int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
			int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

			int[] correct = new int[3];

			for (int i = 0; i < answers.length; i++) {
				if (answers[i] == person1[i % person1.length]) {
					correct[0]++;
				}
				if (answers[i] == person2[i % person2.length]) {
					correct[1]++;
				}
				if (answers[i] == person3[i % person3.length]) {
					correct[2]++;
				}
			}

			int max = Math.max(correct[0], Math.max(correct[1], correct[2]));

			for (int i = 0; i < correct.length; i++) {
				if (correct[i] == max) {
					answer = Arrays.copyOf(answer, answer.length + 1);
					answer[answer.length - 1] = i + 1;
				}
			}

			return answer;
		}
	}

	private static class Solution27 {
		public int solution(int[] nums) {
			int count = 0;

			List<List<Integer>> combinations = getCombinations(nums, 3);

			for (List<Integer> combination : combinations) {
				int sum = combination.stream().mapToInt(Integer::intValue).sum();
				if (isPrime(sum)) {
					count++;
				}
			}

			return count;
		}

		public List<List<Integer>> getCombinations(int[] nums, int r) {
			List<List<Integer>> combinations = new ArrayList<>();
			generateCombinations(nums, r, 0, new ArrayList<>(), combinations);
			return combinations;
		}

		public void generateCombinations(int[] nums, int r, int start, List<Integer> current, List<List<Integer>> combinations) {
			if (current.size() == r) {
				combinations.add(new ArrayList<>(current));
				return;
			}

			for (int i = start; i < nums.length; i++) {
				current.add(nums[i]);
				generateCombinations(nums, r , i + 1, current, combinations);
				current.remove(current.size() - 1);
			}
		}

		public boolean isPrime(int num) {
			if (num < 2) return false;

			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					return false;
				}
			}

			return true;
		}
	}

	private static class Solution28 {
		public int solution(int k, int m, int[] score) {
			int answer = 0;

			// score 배열을 내림차순으로 정리
			List<Integer> scoreList = Arrays.stream(score).boxed().collect(Collectors.toList());
			scoreList.sort(Comparator.reverseOrder());

			// scoreList를 앞에서부터 m개씩 잘라서 새 리스트에 저장
			List<List<Integer>> slicedScoreList = new ArrayList<>();
			for (int i = 0; i < scoreList.size(); i += m) {
				slicedScoreList.add(scoreList.subList(i, Math.min(i + m, scoreList.size())));
			}

			for (List<Integer> eachBox : slicedScoreList) {
				if (eachBox.size() < m) {
					continue;
				}
				// eachBox의 원소 중 최소값 찾기
				int min = eachBox.stream().min(Integer::compare).get();
				if (min < k) {
					answer += min * m;
				} else {
					answer += k * m;
				}
			}

			return answer;
		}
	}

	private static class Solution29 {
		public int solution(int n, int m, int[] section) {
			int answer = 0;
			int currentEnd = 0;

			for (int target : section) {
				if (target > currentEnd) {
					answer++;
					currentEnd = target + m - 1;
				}
			}

			return answer;
		}
	}

	private static class Solution30 {
		public int solution(String[] friends, String[] gifts) {
			Map<String, Integer> giveMap = new HashMap<>();
			Map<String, Integer> receiveMap = new HashMap<>();

			for (String friend : friends) {
				giveMap.put(friend, 0);
				receiveMap.put(friend, 0);
			}

			// 선물 지수 계산을 위한 맵.
			for (String gift : gifts) {
				String[] split = gift.split(" ");
				String giver = split[0];
				String receiver = split[1];

				giveMap.put(giver, giveMap.get(giver) + 1);
				receiveMap.put(receiver, receiveMap.get(receiver) + 1);
			}

			// 다음 달 받을 선물 계산
			Map<String, Integer> nextMonthExpectedGifts = new HashMap<>();
			for (String friend : friends) {
				nextMonthExpectedGifts.put(friend, 0);
			}

			for (int i = 0; i < friends.length; i++) {
				for (int j = i + 1; j < friends.length; j++) {
					String friend1 = friends[i];
					String friend2 = friends[j];

					int friend1ToFriend2 = countMutualGifts(gifts, friend1, friend2);
					int friend2ToFriend1 = countMutualGifts(gifts, friend2, friend1);

					if (friend1ToFriend2 > friend2ToFriend1) {
						nextMonthExpectedGifts.put(friend1, nextMonthExpectedGifts.get(friend1) + 1);
					} else if (friend1ToFriend2 < friend2ToFriend1) {
						nextMonthExpectedGifts.put(friend2, nextMonthExpectedGifts.get(friend2) + 1);
					} else {
						// 둘이 주고 받은 갯수가 같거나 주고받은 적인 없는 경우 지수를 비교
						int friend1Index = giveMap.get(friend1) - receiveMap.get(friend1);
						int friend2Index = giveMap.get(friend2) - receiveMap.get(friend2);

						if (friend1Index > friend2Index) {
							nextMonthExpectedGifts.put(friend1, nextMonthExpectedGifts.get(friend1) + 1);
						} else if (friend1Index < friend2Index) {
							nextMonthExpectedGifts.put(friend2, nextMonthExpectedGifts.get(friend2) + 1);
						}
					}
				}
			}

			// 최다 선물 받은 친구의 선물 갯수 계산
			int maxGifts = 0;
			for (String friend : friends) {
				maxGifts = Math.max(maxGifts, nextMonthExpectedGifts.get(friend));
			}

			return maxGifts;
		}

		private int countMutualGifts(String[] gifts, String giver, String receiver) {
			int count = 0;
			for (String gift : gifts) {
				String[] split = gift.split(" ");
				if (split[0].equals(giver) && split[1].equals(receiver)) {
					count++;
				}
			}
			return count;
		}
	}


	private static class Solution31 {
		public int solution(int[] bandage, int health, int[][] attacks) {
			int answer = 0;

			Map<Integer, Integer> attackMap = new HashMap<>();
			for (int[] attack : attacks) {
				attackMap.put(attack[0], attack[1]);
			}

			int lastIndex = attacks[attacks.length - 1][0];
			int successStreak = 0;
			int maxHealth = health;

			for (int i = 1; i <= lastIndex; i++) {
				if (attackMap.containsKey(i)) {
					health -= attackMap.get(i);
					successStreak = 0;
					if (health <= 0) {
						answer = -1;
						break;
					}
					continue;
				}
				health += bandage[1];
				successStreak++;
				if (successStreak == bandage[0]) {
					health += bandage[2];
					successStreak = 0;
				}
				if (health >= maxHealth) {
					health = maxHealth;
				}
			}

			if (answer != -1) {
				answer = health;
			}

			return answer;
		}
	}
}