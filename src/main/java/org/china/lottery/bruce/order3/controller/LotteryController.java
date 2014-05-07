package org.china.lottery.bruce.order3.controller;

import org.china.lottery.bruce.order3.model.Group;
import org.china.lottery.bruce.order3.service.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LotteryController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LotteryService lotteryService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String order3Index(ModelMap model) {
		return "redirect:/kill/19";
	}

	@RequestMapping(value = "/kill/{number}", method = RequestMethod.GET)
	public String killValue(@PathVariable Integer number, ModelMap model) {

		Group group = lotteryService.getGroupByKillValue(number);
		int latestWinnerCode = lotteryService.getLastWinnerCode();
		int countOfWinners = lotteryService.getCountForWinner();
		int[][] allWinnerCode = lotteryService.getWinnerCode();

		model.addAttribute("killvalue", number);
		model.addAttribute("areas", group.getAreas());
		model.addAttribute("latestWinnerCode", latestWinnerCode);
		model.addAttribute("latestCycleNum", countOfWinners);
		model.addAttribute("allWinnerCode", allWinnerCode);
		return "lottery";
	}

	@RequestMapping(value = "/merge/{number}", method = RequestMethod.GET)
	public String megerValue(@PathVariable Integer number, ModelMap model) {

		int[][] mergeDatas = lotteryService.getmergeDataByKillValue(number);
		int latestWinnerCode = lotteryService.getLastWinnerCode();
		int countOfWinners = lotteryService.getCountForWinner();
		int[][] allWinnerCode = lotteryService.getWinnerCode();

		model.addAttribute("killvalue", number);
		model.addAttribute("mergeDatas", mergeDatas);
		model.addAttribute("latestWinnerCode", latestWinnerCode);
		model.addAttribute("latestCycleNum", countOfWinners);
		model.addAttribute("allWinnerCode", allWinnerCode);
		return "merge";
	}

	@RequestMapping(value = "/killall/{number}", method = RequestMethod.GET)
	public String killAllValue(@PathVariable Integer number, ModelMap model) {

		Group group = lotteryService.getGroupByAllKillValue(number);
		int latestWinnerCode = lotteryService.getLastWinnerCode();
		int countOfWinners = lotteryService.getCountForWinner();
		int[][] allWinnerCode = lotteryService.getWinnerCode();

		model.addAttribute("killvalue", number);
		model.addAttribute("areasKillAll", group.getAreasForKillAll());
		model.addAttribute("latestWinnerCode", latestWinnerCode);
		model.addAttribute("latestCycleNum", countOfWinners);
		model.addAttribute("allWinnerCode", allWinnerCode);
		return "lottery_killall";
	}

	@RequestMapping(value = "/allMerge/{number}", method = RequestMethod.GET)
	public String megerAllValue(@PathVariable Integer number, ModelMap model) {

		int[][] mergeDatas = lotteryService.getmergeDataByAllKillValue(number);
		int latestWinnerCode = lotteryService.getLastWinnerCode();
		int countOfWinners = lotteryService.getCountForWinner();
		int[][] allWinnerCode = lotteryService.getWinnerCode();

		model.addAttribute("killvalue", number);
		model.addAttribute("mergeDatas", mergeDatas);
		model.addAttribute("latestWinnerCode", latestWinnerCode);
		model.addAttribute("latestCycleNum", countOfWinners);
		model.addAttribute("allWinnerCode", allWinnerCode);
		return "merge_all";
	}

	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String greetRequest(
			@RequestParam(required = false, defaultValue = "John Doe") String name,
			ModelMap model) {
		logger.debug("Method greetRequest");
		model.addAttribute("name", name);
		model.addAttribute("contentName", "title");
		return "forms";
	}
}
