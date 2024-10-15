package com.exam.programmers;

import java.util.HashMap;
import java.util.Map;

public class TlvParser {
	private static boolean isConstructedType(int tag) {
		// Tag가 2바이트라고 했고 BER-TLV라면 왼쪽에서 3번째 비트가 0,1인지에 따라 Primitive, Contructed를 구분
		// 이 경우 다음 5비트가 11111이라면, 다음 1비트의 첫번째 비트가 1,0인지에 따라 Tag가 더 있는지 없는지가 구분된다.
		// 하지만 태그가 2바이트라고 했으니  두 번째 바이트의 첫번째 비트는 무조건 0이다.
		return (tag & 0x20) != 0;
	}

	public static Map<Integer, Object> parseTLV(byte[] tlvData, int offset, int remainingLength) {
		Map<Integer, Object> resultMap = new HashMap<>();

		// Tag 추출 (2 bytes)
		if (remainingLength < 3) { // 최소한 type(2) + length(1)의 데이터가 있어야 함
			throw new IllegalArgumentException("Insufficient data");
		}

		int tag = ((tlvData[offset] & 0xFF) << 8) | (tlvData[offset + 1] & 0xFF);  // 2 byte type (or tag)
		offset += 2;
		remainingLength -= 2;

		// Length 추출 (1 byte)
		int length = tlvData[offset] & 0xFF;  // 1 byte length
		offset += 1;
		remainingLength -= 1;

		// Value 추출 (length byte 만큼 value)
		if (remainingLength < length) { // length 값만큼 남은 데이터가 있는지 확인
			throw new IllegalArgumentException("Length exceeds remaining data");
		}

		byte[] value = new byte[length];
		System.arraycopy(tlvData, offset, value, 0, length);
		offset += length;
		remainingLength -= length;

		// ConstructedType인지 확인
		if (isConstructedType(tag)) {
			Map<Integer, Object> nestedTLV = parseTLV(value, 0, value.length);
			resultMap.put(tag, nestedTLV);
		} else {
			resultMap.put(tag, value);
		}

		// 재귀로 나머지 TLV 데이터 파싱
		if (remainingLength > 0) {
			resultMap.putAll(parseTLV(tlvData, offset, remainingLength));
		}

		return resultMap;
	}

	public static void main(String[] args) {
		// 예시 TLV 데이터
		byte[] tlvData = new byte[]{
				(byte) 0x3F, (byte) 0x0F, // Tag
				(byte) 0x0B,       // Length
				(byte) 0x03, (byte) 0x02, (byte) 0x03, (byte) 0x64, (byte) 0x65, (byte) 0x76, // Nested TLV
				(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x56, (byte) 0x78, // Nested TLV


				(byte) 0x03, (byte) 0x04, // Tag
				(byte) 0x03,       // Length
				(byte) 0x41, (byte) 0x42, (byte) 0x43 // Value
		};

		// TLV 데이터 파싱
		Map<Integer, Object> resultMap = parseTLV(tlvData, 0, tlvData.length);

		// 출력
		for (Map.Entry<Integer, Object> entry : resultMap.entrySet()) {
			System.out.println("Type: " + entry.getKey().byteValue() + " Value: " + entry.getValue());
		}
	}
}
