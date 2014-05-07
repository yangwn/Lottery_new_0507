package org.china.lottery.bruce.order3.storage;

import org.china.lottery.bruce.order3.model.Group;

public interface LotteryStroage {

	public Group getGroupByKillValue(int cancelValue);

	public Group getGroupKillAllByValue(int cancelValue);

}
