package com.exam.programmers;

import java.util.HashMap;
import java.util.Map;

public class TlvParser {
	public static Map<Integer, byte[]> parseTLV(byte[] tlvData, int offset, int remainingLength) {
		// SIMPLE-TLV라고 가정
		Map<Integer, byte[]> resultMap = new HashMap<>();

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

		resultMap.put(tag, value);

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
				(byte) 0x03,       // Length
				(byte) 0x64, (byte) 0x65, (byte) 0x76, // Value

				(byte) 0x03, (byte) 0x04, // Tag
				(byte) 0x03,       // Length
				(byte) 0x41, (byte) 0x42, (byte) 0x43 // Value
		};

		// TLV 데이터 파싱
		Map<Integer, byte[]> resultMap = parseTLV(tlvData, 0, tlvData.length);

		// 출력
		for (Map.Entry<Integer, byte[]> entry : resultMap.entrySet()) {
			System.out.printf("Type: %04X, Value: %s\n",entry.getKey(), new String(entry.getValue()));
		}
	}
}
