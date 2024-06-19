package com.smhrd.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // 세션이 존재하지 않을 경우 null 반환
		System.out.println(session);
		
		if (session.getAttribute("loginMember") != null) {
			session.invalidate(); // 세션 무효화
			System.out.println("로그아웃 되었습니다");
		} else{
			System.out.println("로그인 상태가 아닙니다");
		}

		response.sendRedirect("index.jsp");
	}
}
