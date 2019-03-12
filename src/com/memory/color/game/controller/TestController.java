package com.memory.color.game.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memory.color.game.model.ColorDealer;
import com.memory.color.game.model.Player;

public class TestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Hi bata ");
		HttpSession session = req.getSession();
		Player player = (Player) session.getAttribute("player");
		if (player == null) {
			player = createPlayer();
		} else {
			player.setClicks(player.getClicks() + 1);
		}
		ColorDealer dealer = new ColorDealer();

		List<String> colors = player.getDealedColors();
		colors.add(dealer.dealColor(player.getLevel()));
		player.setDealedColors(colors);

		session.setAttribute("player", player);

		resp.getWriter().append(player.getAvailableColors().toString());
		resp.getWriter().append(player.getDealedColors().toString());

		resp.getWriter().append(player.getLevel() + " ");
		resp.getWriter().append(player.getClicks() + " ");
	}

	private Player createPlayer() {

		Player newPlayer = new Player(0, 1, 1);
		newPlayer.setDealedColors(new ArrayList<String>());
		newPlayer.setAvailableColors(new ColorDealer().generateColorList(newPlayer.getLevel()));
		return newPlayer;
	}

}
