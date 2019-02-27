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

public class TestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Hi bata ");
		HttpSession session = req.getSession();
		if (session.isNew()) {
			session.setAttribute("level", 1);
			session.setAttribute("clicks", 1);
		} else {
			session.setAttribute("clicks", ((int) session.getAttribute("clicks")) + 1);
		}
		
		ColorDealer dealer = new ColorDealer();

		List<String> dealedColors = (List<String>) session.getAttribute("dealedColors");

		if (dealedColors == null || dealedColors.isEmpty()) {
			dealedColors = new ArrayList<String>();
			session.setAttribute("dealedColors", dealedColors);
		}
		dealedColors.add(dealer.dealColor((int) session.getAttribute("level")));

		if ((int) (session.getAttribute("clicks")) > 5) {
			session.setAttribute("level", ((int) session.getAttribute("level")) + 1);
			session.setAttribute("clicks", 1);
		}

		List<String> generateColorList = (List) session.getAttribute("colorList");
		if (generateColorList == null || generateColorList.isEmpty()) {
			session.setAttribute("colorList", dealer.generateColorList((int) session.getAttribute("level")));
		}

		resp.getWriter().append(session.getAttribute("colorList").toString() + " ");
		resp.getWriter().append(session.getAttribute("dealedColors").toString() + " ");

		resp.getWriter().append(session.getAttribute("level").toString() + " ");
		resp.getWriter().append(session.getAttribute("clicks").toString());
	}
}
