package com.memory.color.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.memory.color.game.service.ColorGameService;

public class ColorDealer {

	public List<String> generateColorList(int level) {
		List<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("blue");
		colors.add("yellow");
		colors.add("green");
		return colors;
	}

	public String dealColor(int level) {
		List<String> colors = generateColorList(level);
		Random random = new Random();
		return colors.get(random.nextInt(colors.size() - 1));
	}

	public String generateNewColor(int level) {
		if (level == 2) {
			return "orange";
		} else if (level == 3) {
			return "pink";
		} else if (level == 4) {
			return "white";
		}
		return null;
	}

}
