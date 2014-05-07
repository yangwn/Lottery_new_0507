package org.china.lottery.bruce.order3.model;

public class Area {

	private int areaId;

	private int maxContinuousRowValue;

	private int maxContinuousRowForStartValue;

	private CellRow[] cellRows;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getMaxContinuousRowValue() {
		return maxContinuousRowValue;
	}

	public void setMaxContinuousRowValue(int maxContinuousRowValue) {
		this.maxContinuousRowValue = maxContinuousRowValue;
	}

	public int getMaxContinuousRowForStartValue() {
		return maxContinuousRowForStartValue;
	}

	public void setMaxContinuousRowForStartValue(
			int maxContinuousRowForStartValue) {
		this.maxContinuousRowForStartValue = maxContinuousRowForStartValue;
	}

	public CellRow[] getCellRows() {
		return cellRows;
	}

	public void setCellRows(CellRow[] cellRows) {
		this.cellRows = cellRows;
	}

}
