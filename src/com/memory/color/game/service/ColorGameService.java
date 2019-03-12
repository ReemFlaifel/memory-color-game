package com.memory.color.game.service;

import java.util.ArrayList;
import java.util.List;

import com.memory.color.game.model.ColorDealer;
import com.memory.color.game.model.Player;

public class ColorGameService {

	private ColorDealer dealer = new ColorDealer();

	public boolean isClickedColorCorrect(Player player, String clickedColor) throws Exception {
		if (!player.getDealedColors().get(player.getClicks() - 1).equalsIgnoreCase(clickedColor)) {
			return false;
		}
		return true;
	}

	public boolean levelUp(Player player) {
		if (player.getClicks() > 5) {
			List<String> colors = new ArrayList<String>();

			player.setClicks(0);
			player.setLevel(player.getLevel() + 1);
			colors.add(dealer.generateNewColor(player.getLevel()));
			player.setAvailableColors(colors);
			return true;
		}
		return false;
	}

	public boolean playTurn(Player player, String clickedColor) throws Exception {

		if (player == null) {
			throw new IllegalArgumentException();
		}
		List<String> colors = player.getDealedColors();
		if (isClickedColorCorrect(player, clickedColor)) {
			colors.add(dealer.dealColor(player.getLevel()));
			player.setClicks(player.getLevel() + 1);
			player.setScore(player.getScore() + 1);
			player.setDealedColors(colors);
			return true;
		}
		return false;
	}

	public void updatePlayerColorList(Player player) {
		List<String> colors = new ArrayList<String>();
		colors.add(dealer.dealColor(player.getClicks()));
		player.setDealedColors(colors);
		player.setClicks(1);

	}
}