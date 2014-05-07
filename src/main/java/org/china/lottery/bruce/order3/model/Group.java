package org.china.lottery.bruce.order3.model;

public class Group {

	private int killValue;

	private Area[] areas;

	private Area[] areasForKillAll;

	public int getKillValue() {
		return killValue;
	}

	public void setKillValue(int killValue) {
		this.killValue = killValue;
	}

	public Area[] getAreas() {
		return areas;
	}

	public void setAreas(Area[] areas) {
		this.areas = areas;
	}

	public Area[] getAreasForKillAll() {
		return areasForKillAll;
	}

	public void setAreasForKillAll(Area[] areasForKillAll) {
		this.areasForKillAll = areasForKillAll;
	}

}
