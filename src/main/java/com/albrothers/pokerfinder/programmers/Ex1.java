package com.albrothers.pokerfinder.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {
			public static void main(String[] args) {
				Solution2 sol = new Solution2();
				System.out.println(sol.solution("-1234"));
		}
}

class Solution1 {
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

class Solution2 {
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

class Solution3 {
	public int solution(int n) {
		int answer = 0;
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			answer += s.charAt(i) - '0';
		}
		return answer;
	}
}

class Solution4 {
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

class Solution5 {
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

class Solution6 {
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

class Solution7 {
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

class Solution8 {
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

class Solution9 {
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

class Solution10 {
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

class Solution11 {
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

class Solution12 {
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

class Solution13 {
	public int solution(int[] numbers) {
		int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;
		for (int i = 0; i < numbers.length; i++) {
			sum -= numbers[i];
		}
		return sum;
	}
}

class Solution14 {
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

class Solution15 {
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

class Solution16 {
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

class Solution17 {
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