package org.china.lottery.bruce.order3.storage.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangwunan
 */

public class LotteryStrategy {

	private final static int[][] rawArrayskill37 = {{4619, 4650, 4628},
			{4650, 4628, 1950}, {4628, 1950, 1928}, {1950, 1928, 5028},
			{1928, 5028, 4619}, {5028, 4619, 4650}};

	private final static int[][] rawArrayskill28 = {{3746, 3719, 3750},
			{3719, 3750, 4619}, {3750, 4619, 4650}, {4619, 4650, 1950},
			{4650, 1950, 3746}, {1950, 3746, 3719}};

	private final static int[][] rawArrayskill50 = {{2837, 2846, 2819},
			{2846, 2819, 3746}, {2819, 3746, 3719}, {3746, 3719, 4619},
			{3719, 4619, 2837}, {4619, 2837, 2846}};

	private final static int[][] rawArrayskill19 = {{5028, 5037, 5046},
			{5037, 5046, 2837}, {5046, 2837, 2846}, {2837, 2846, 3746},
			{2846, 3746, 5028}, {3746, 5028, 5037}};

	private final static int[][] rawArrayskill46 = {{1950, 1928, 1937},
			{1928, 1937, 5028}, {1937, 5028, 5037}, {5028, 5037, 2837},
			{5037, 2837, 1950}, {2837, 1950, 1928}};

	private static Map<Integer, int[][]> rawArrasy = new HashMap<Integer, int[][]>();

	static {
		rawArrasy.put(37, rawArrayskill37);
		rawArrasy.put(28, rawArrayskill28);
		rawArrasy.put(50, rawArrayskill50);
		rawArrasy.put(19, rawArrayskill19);
		rawArrasy.put(46, rawArrayskill46);
	}

	public static int[][] getSequencePartArray(int cancelValue) {
		return rawArrasy.get(cancelValue);
	}

	/**
	 * For all of kill value
	 */
	private final static int[] rawArrayskill37All = {4619, 4650, 4628, 1950,
			1928, 5028};

	private final static int[] rawArrayskill28All = {3746, 3719, 3750, 4619,
			4650, 1950};

	private final static int[] rawArrayskill50All = {2837, 2846, 2819, 3746,
			3719, 4619};

	private final static int[] rawArrayskill19All = {5028, 5037, 5046, 2837,
			2846, 3746};

	private final static int[] rawArrayskill46All = {1950, 1928, 1937, 5028,
			5037, 2837};

	private static Map<Integer, int[]> rawArrasForAll = new HashMap<Integer, int[]>();

	static {
		rawArrasForAll.put(37, rawArrayskill37All);
		rawArrasForAll.put(28, rawArrayskill28All);
		rawArrasForAll.put(50, rawArrayskill50All);
		rawArrasForAll.put(19, rawArrayskill19All);
		rawArrasForAll.put(46, rawArrayskill46All);
	}

	public static int[] getSequenceAllArray(int cancelValue) {
		return rawArrasForAll.get(cancelValue);
	}

}
