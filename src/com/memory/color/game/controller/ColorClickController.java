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

public class ColorClickController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clickedColor = (String) req.getParameter("clickedcolor");
		HttpSession session = req.getSession();
		List<String> colors = (List) session.getAttribute("colorList");
		int clicks = (int) session.getAttribute("colorList");

		if (!colors.get(clicks).equals(clickedColor)) {
			resp.getWriter().println("Falied");
		}
		else {
			resp.getWriter().println("sucess");
		}

	}
}