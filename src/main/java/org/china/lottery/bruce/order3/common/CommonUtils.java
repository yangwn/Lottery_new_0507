package org.china.lottery.bruce.order3.common;

import com.google.common.primitives.Ints;

public class CommonUtils {

	public static boolean ifExists(int rawValue, int compareValue) {
		int[] rawCombinCodes = getRawValueForArray(rawValue);
		return Ints.contains(rawCombinCodes, compareValue);
	}

	public static boolean ifExistsKillAll(int rawValue, int[] compareValues) {
		int[] rawCombinCodes = getRawValueForArray(rawValue);
		for (int compareValue : compareValues) {
			boolean isExists = Ints.contains(rawCombinCodes, compareValue);
			if (isExists) {
				return true;
			}
		}
		return false;
	}

	public static int getNextValue(int rawCombinValue) {
		int[] rawCombinCodes = getRawValueForArray(rawCombinValue);
		return Integer.valueOf(Ints.join("", rawCombinCodes[1],
				rawCombinCodes[2], rawCombinCodes[3], rawCombinCodes[0]));
	}

	public static int[] getRawValueForArray(int rawCombinValue) {

		int[] rawCombinCodes = new int[4];
		rawCombinCodes[3] = rawCombinValue % 10; // firstPositionValue
		rawCombinCodes[2] = (rawCombinValue / 10) % 10; // secondPositionValue
		rawCombinCodes[1] = (rawCombinValue / 100) % 10; // thirdPositionValue
		rawCombinCodes[0] = (rawCombinValue / 1000) % 10; // forthPositionValue
		return rawCombinCodes;
	}

}
