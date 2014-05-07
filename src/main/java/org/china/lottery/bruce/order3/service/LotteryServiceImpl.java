package org.china.lottery.bruce.order3.service;

import org.china.lottery.bruce.order3.model.Area;
import org.china.lottery.bruce.order3.model.CellRow;
import org.china.lottery.bruce.order3.model.Group;
import org.china.lottery.bruce.order3.storage.LotteryStroage;
import org.china.lottery.bruce.order3.storage.datasource.SourceDataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryServiceImpl implements LotteryService {

	@Autowired
	private LotteryStroage lotteryStroage;

	@Autowired
	private SourceDataStorage sourceDataStorage;

	public Group getGroupByKillValue(int killValue) {
		return lotteryStroage.getGroupByKillValue(killValue);
	}

	public int[][] getmergeDataByKillValue(int killValue) {
		Group group = this.getGroupByKillValue(killValue);
		Area[] areas = group.getAreas();

		int[][] mergeData = new int[sourceDataStorage.getCountForWinner()][6];
		for (int i = 0; i < areas.length; i++) {
			Area area = areas[i];
			// －1 为了将最后一期(还没有开奖)去掉
			for (int j = 0; j < area.getCellRows().length - 1; j++) {
				CellRow cellRow = area.getCellRows()[j];
				mergeData[j][i] = cellRow.getSequenceValue();
			}
		}
		return mergeData;
	}
	

	public Group getGroupByAllKillValue(int killValue) {
		return lotteryStroage.getGroupKillAllByValue(killValue);
	}

	public int[][] getmergeDataByAllKillValue(int killValue) {
		Group group = this.getGroupByAllKillValue(killValue);
		Area[] areas = group.getAreasForKillAll();

		int[][] mergeData = new int[sourceDataStorage.getCountForWinner()][6];
		for (int i = 0; i < areas.length; i++) {
			Area area = areas[i];
			// －1 为了将最后一期(还没有开奖)去掉
			for (int j = 0; j < area.getCellRows().length - 1; j++) {
				CellRow cellRow = area.getCellRows()[j];
				mergeData[j][i] = cellRow.getSequenceValue();
			}
		}
		return mergeData;
	}
	@Override
	public int getLastWinnerCode() {
		return sourceDataStorage.getLatestWinnerCode();
	}

	@Override
	public int getCountForWinner() {
		return sourceDataStorage.getCountForWinner();
	}

	@Override
	public int[][] getWinnerCode() {
		return sourceDataStorage.getAllWinnerCodes();
	}

}
