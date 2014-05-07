package org.china.lottery.bruce.order3.model;

import java.util.ArrayList;
import java.util.List;

public class CellRow {

	private int[] winnerCode;

	private int cellRowId;

	private int[][] staticLoopValues;

	private int sequenceValue; // 0为NULL,否则为序列1～无穷的自然数

	public int[] getWinnerCode() {
		return winnerCode;
	}

	public List<Integer> getWinnerCodeForList() {
		if (getWinnerCode() == null) {
			return null;
		}
		List<Integer> array = new ArrayList<Integer>();
		for (int winnerCode : getWinnerCode()) {
			array.add(winnerCode);
		}
		return array;
	}

	public void setWinnerCode(int[] winnerCode) {
		this.winnerCode = winnerCode;
	}

	public int getCellRowId() {
		return cellRowId;
	}

	public void setCellRowId(int cellRowId) {
		this.cellRowId = cellRowId;
	}

	public int[][] getStaticLoopValues() {
		return staticLoopValues;
	}

	public void setStaticLoopValues(int[][] staticLoopValues) {
		this.staticLoopValues = staticLoopValues;
	}

	public int getSequenceValue() {
		return sequenceValue;
	}

	public void setSequenceValue(int sequenceValue) {
		this.sequenceValue = sequenceValue;
	}

}
