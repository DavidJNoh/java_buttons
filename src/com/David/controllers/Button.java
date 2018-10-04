package com.David.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class Button extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Button() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	HttpSession session = request.getSession();

			if(session.getAttribute("counter")==null) {
				System.out.println("Start");
				session.setAttribute("counter", 0);
			}
        	
			else {
				System.out.println("Hello Hello");
				int current = (int) session.getAttribute("counter");
				current ++;
				session.setAttribute("counter", current);
			}
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Home.jsp");
            view.forward(request, response);

        }
	}