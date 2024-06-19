package com.smhrd.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.member.model.MemberDAO;

public class MemberEmailCheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_email = request.getParameter("mail");
        MemberDAO dao = new MemberDAO();
        int count = dao.check(mem_email);

        if (count == -1) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else if (count > 0) {
            response.getWriter().write("unavailable");
        } else {
            response.getWriter().write("available");
        }
    }
}
