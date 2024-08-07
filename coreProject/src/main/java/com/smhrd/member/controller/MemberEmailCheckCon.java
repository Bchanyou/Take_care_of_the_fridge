package com.smhrd.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.smhrd.member.model.MemberDAO;

public class MemberEmailCheckCon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mem_email = request.getParameter("mail");
        String email_name = request.getParameter("slt_mail");
        String real_email = mem_email + "@" + email_name;

        MemberDAO dao = new MemberDAO();
        int count = dao.check2(real_email);

        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        if (count == -1) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else if (count > 0) {
            response.getWriter().write("unavailable");
        } else {
            response.getWriter().write("available");
            // sendRedirect를 클라이언트 측에서 처리하도록 함
        }
    }
}
