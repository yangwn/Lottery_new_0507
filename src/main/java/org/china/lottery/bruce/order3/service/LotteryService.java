package org.china.lottery.bruce.order3.service;

import org.china.lottery.bruce.order3.model.Group;

public interface LotteryService {

	public Group getGroupByKillValue(int killValue);

	public int[][] getmergeDataByKillValue(int killValue);

	public Group getGroupByAllKillValue(int killValue);

	public int[][] getmergeDataByAllKillValue(int killValue);

	public int getLastWinnerCode();

	public int getCountForWinner();

	public int[][] getWinnerCode();
}
