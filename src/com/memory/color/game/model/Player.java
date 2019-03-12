package com.memory.color.game.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int score;
	private int clicks;
	private int level;
	private List<String> dealedColors;
	private List<String> availableColors;

	public Player(int score, int clicks, int level) {
		this.score = score;
		this.clicks = clicks;
		this.level = level;
	}

	public List<String> getDealedColors() {
		return dealedColors;
	}

	public void setDealedColors(List<String> dealedColors) {
		this.dealedColors = dealedColors;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<String> getAvailableColors() {
		return availableColors;
	}

	public void setAvailableColors(List<String> availableColors) {
		this.availableColors = availableColors;
	}

}
