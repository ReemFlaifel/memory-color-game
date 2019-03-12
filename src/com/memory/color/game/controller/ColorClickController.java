package com.memory.color.game.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.memory.color.game.model.ColorDealer;
import com.memory.color.game.model.Player;
import com.memory.color.game.service.ColorGameService;

public class ColorClickController extends HttpServlet {
	ColorGameService gameService = new ColorGameService();
	ColorDealer dealer = new ColorDealer();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Player player = (Player) session.getAttribute("player");
		String clickedColor = (String) req.getParameter("clickedcolor");

		try {
			if (player.getClicks() == player.getDealedColors().size()) {
				gameService.updatePlayerColorList(player);
			}
			gameService.playTurn(player, clickedColor);

		} catch (Exception e) {
			System.err.println(e);
		}

		if (gameService.levelUp(player)) {
			resp.getWriter().write("Next Level");
		}

		resp.getWriter().write(player.getDealedColors().toString());
		resp.getWriter().write(player.getClicks());

	}
}