package org.china.lottery.bruce.order3.common;

import java.util.List;

public class PageUtils {

	public static String getColor(List<Integer> winnerCodes, int showNum) {

		if (winnerCodes.contains(showNum)) {
			return "w";
		} else {
			return "";
		}
	}

	public static String getColor(List<List<Integer>> winnerCodes,
			int rowIndex, int groupIndex, int showNum) {

		if (winnerCodes.size() <= rowIndex) {
			return "";
		}
		int res = winnerCodes.get(rowIndex).get(groupIndex);
		if (res == showNum) {
			return "d";
		} else if (winnerCodes.get(rowIndex).contains(showNum)) {
			return "w";
		} else {
			return "";
		}
	}

	public static String getColor(List<Integer> winnerCodes, int columnIndex,
			int showNum) {

		int res = winnerCodes.get(columnIndex - 1);
		if (res == showNum) {
			return "w";
		} else {
			return "";
		}
	}

	public static String getColor(int value) {
		if (value == 0) {
			return "d";
		}else if(value == -1){
			return "white";
		}
		return "";
	}

}
