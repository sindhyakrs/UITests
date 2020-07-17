package autoapp.automation.pages;

import autoapp.automation.utility.BaseUtil;


import java.util.Random;

public class BasePage{

	private BaseUtil baseUtil;

	public BasePage(BaseUtil baseUtil) {
		this.baseUtil = baseUtil;
	}

	public int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
