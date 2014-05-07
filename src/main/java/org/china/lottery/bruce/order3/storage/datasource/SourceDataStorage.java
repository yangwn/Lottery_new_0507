package org.china.lottery.bruce.order3.storage.datasource;

public interface SourceDataStorage {

	public void loadWinnerFile();

	public void refresh();

	public <T> T getSourceFile();

	public int[][] getAllWinnerCodes();

	public int[] getAllWinnerArray();

	public int[] getWinnerCodesArrayToShow();

	public void appendToWinnerSourceFile(int value);

	public int getLatestWinnerCode();

	public int getCountForWinner();
}
