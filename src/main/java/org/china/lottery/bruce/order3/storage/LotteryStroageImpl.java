package org.china.lottery.bruce.order3.storage;

import org.china.lottery.bruce.order3.common.CommonUtils;
import org.china.lottery.bruce.order3.model.Area;
import org.china.lottery.bruce.order3.model.CellRow;
import org.china.lottery.bruce.order3.model.Group;
import org.china.lottery.bruce.order3.storage.datasource.SourceDataStorage;
import org.china.lottery.bruce.order3.storage.strategy.LotteryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LotteryStroageImpl implements LotteryStroage {

	@Autowired
	private SourceDataStorage sourceDataStorage;

	@Override
	public Group getGroupByKillValue(int cancelValue) {

		Group group = new Group();
		group.setKillValue(cancelValue);
		group.setAreas(getAreaForPart(cancelValue));
		return group;
	}

	@Override
	public Group getGroupKillAllByValue(int cancelValue) {

		Group group = new Group();
		group.setKillValue(cancelValue);
		group.setAreasForKillAll(getAreaForAll(cancelValue));
		return group;
	}

	private Area[] getAreaForAll(int cancelValue) {

		int[][] winnerCodes = sourceDataStorage.getAllWinnerCodes();
		int[] staticLoopData = LotteryStrategy.getSequenceAllArray(cancelValue);

		Area[] areas = new Area[6];
		for (int i = 0; i < staticLoopData.length; i++) {

			int staticLoopValue = staticLoopData[i]; // 4619
			Area area = new Area();
			area.setAreaId(i);

			int maxContinuousRowValue = 0;
			int maxContinuousRowForStartValue = 0;
			int existslength = 1;

			CellRow[] cellRows = new CellRow[winnerCodes.length + 1];
			int beforeStaticLoopValue = 0;

			int winneridx = 0;
			while (winneridx < winnerCodes.length) {

				int[] winnerCode = winnerCodes[winneridx];

				if (winneridx == 0) {
					beforeStaticLoopValue = staticLoopValue;
				} else {
					beforeStaticLoopValue = CommonUtils
							.getNextValue(beforeStaticLoopValue);
				}

				CellRow cellRow = new CellRow();
				cellRow.setCellRowId(winneridx);
				cellRow.setWinnerCode(winnerCode);

				boolean ifExists = CommonUtils.ifExistsKillAll(staticLoopValue,
						winnerCode);
				if (ifExists) {
					cellRow.setSequenceValue(existslength++);
				} else {
					cellRow.setSequenceValue(0);
					existslength = 1;
				}

				if (maxContinuousRowValue < existslength) {
					maxContinuousRowValue = existslength - 1;
					maxContinuousRowForStartValue = winneridx - existslength
							+ 3;
				}
				int[][] arrayStaticLoopValues = new int[1][];
				arrayStaticLoopValues[0] = CommonUtils
						.getRawValueForArray(beforeStaticLoopValue);
				cellRow.setStaticLoopValues(arrayStaticLoopValues);
				cellRows[winneridx] = cellRow;
				winneridx++;
			}

			CellRow cellRow = new CellRow();
			int[][] arrayStaticLoopValues = new int[1][];
			arrayStaticLoopValues[0] = CommonUtils
					.getRawValueForArray(CommonUtils
							.getNextValue(beforeStaticLoopValue));
			cellRow.setStaticLoopValues(arrayStaticLoopValues);
			int[] winnerCode = {-1, -1, -1};
			cellRow.setWinnerCode(winnerCode);
			cellRow.setSequenceValue(-1);
			cellRows[winnerCodes.length] = cellRow;

			area.setCellRows(cellRows);
			area.setMaxContinuousRowForStartValue(maxContinuousRowForStartValue);
			area.setMaxContinuousRowValue(maxContinuousRowValue);
			areas[i] = area;
		}
		return areas;
	}

	private Area[] getAreaForPart(int cancelValue) {

		int[][] winnerCodes = sourceDataStorage.getAllWinnerCodes();
		int[][] staticLoopDatas = LotteryStrategy
				.getSequencePartArray(cancelValue);

		Area[] areas = new Area[6];
		for (int i = 0; i < staticLoopDatas.length; i++) {

			int[] staticLoopArray = staticLoopDatas[i];
			int winneridx = 0;
			int existslength = 1;
			int beforeFirstStaticLoopValue = 0;
			int beforeSencondStaticLoopValue = 0;
			int beforeThridStaticLoopValue = 0;

			Area area = new Area();
			area.setAreaId(i);

			int maxContinuousRowValue = 0;
			int maxContinuousRowForStartValue = 0;

			CellRow[] cellRows = new CellRow[winnerCodes.length + 1];

			while (winneridx < winnerCodes.length) {

				int[] winnerCode = winnerCodes[winneridx];
				CellRow cellRow = new CellRow();
				cellRow.setCellRowId(winneridx);
				cellRow.setWinnerCode(winnerCode);

				int staticLoopUnit = 0;
				boolean ifFirstExists = false;
				boolean ifSecondExists = false;
				boolean ifThridExists = false;

				if (winneridx == 0) {
					staticLoopUnit = staticLoopArray[0];
					int winnerUnit = winnerCode[0];
					ifFirstExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeFirstStaticLoopValue = staticLoopUnit;

					staticLoopUnit = staticLoopArray[1];
					winnerUnit = winnerCode[1];
					ifSecondExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeSencondStaticLoopValue = staticLoopUnit;

					staticLoopUnit = staticLoopArray[2];
					winnerUnit = winnerCode[2];
					ifThridExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeThridStaticLoopValue = staticLoopUnit;
				} else {
					staticLoopUnit = CommonUtils
							.getNextValue(beforeFirstStaticLoopValue);
					int winnerUnit = winnerCode[0];
					ifFirstExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeFirstStaticLoopValue = staticLoopUnit;

					staticLoopUnit = CommonUtils
							.getNextValue(beforeSencondStaticLoopValue);
					winnerUnit = winnerCode[1];
					ifSecondExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeSencondStaticLoopValue = staticLoopUnit;

					staticLoopUnit = CommonUtils
							.getNextValue(beforeThridStaticLoopValue);
					winnerUnit = winnerCode[2];
					ifThridExists = CommonUtils.ifExists(staticLoopUnit,
							winnerUnit);
					beforeThridStaticLoopValue = staticLoopUnit;
				}

				if (ifFirstExists || ifSecondExists || ifThridExists) {
					cellRow.setSequenceValue(existslength++);
				} else {
					cellRow.setSequenceValue(0);
					existslength = 1;
				}

				if (maxContinuousRowValue < existslength) {
					maxContinuousRowValue = existslength - 1;
					maxContinuousRowForStartValue = winneridx - existslength
							+ 3;
				}
				int[][] arrayStaticLoopVlues = {
						CommonUtils
								.getRawValueForArray(beforeFirstStaticLoopValue),
						CommonUtils
								.getRawValueForArray(beforeSencondStaticLoopValue),
						CommonUtils
								.getRawValueForArray(beforeThridStaticLoopValue)};
				cellRow.setStaticLoopValues(arrayStaticLoopVlues);
				cellRows[winneridx] = cellRow;
				winneridx++;
			}

			CellRow cellRow = new CellRow();
			int[][] arrayStaticLoopVlues = {
					CommonUtils.getRawValueForArray(CommonUtils
							.getNextValue(beforeFirstStaticLoopValue)),
					CommonUtils.getRawValueForArray(CommonUtils
							.getNextValue(beforeSencondStaticLoopValue)),
					CommonUtils.getRawValueForArray(CommonUtils
							.getNextValue(beforeThridStaticLoopValue))};
			cellRow.setStaticLoopValues(arrayStaticLoopVlues);
			int[] winnerCode = {-1, -1, -1};
			cellRow.setWinnerCode(winnerCode);
			cellRow.setSequenceValue(-1);
			cellRows[winnerCodes.length] = cellRow;

			area.setCellRows(cellRows);
			area.setMaxContinuousRowForStartValue(maxContinuousRowForStartValue);
			area.setMaxContinuousRowValue(maxContinuousRowValue);
			areas[i] = area;
		}
		return areas;
	}
}
