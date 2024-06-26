package com.smhrd.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.member.model.MemberDAO;
import com.smhrd.member.model.MemberDTO;

public class MemberLoginCon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 한글 인코딩
        request.setCharacterEncoding("UTF-8");

        // 2. 데이터 가져오기
        String mem_id = request.getParameter("id");
        String mem_pw = request.getParameter("pw");
        String save_login = request.getParameter("save_login");
        String save_id = request.getParameter("save_id");

        boolean isSaveLoginChecked = save_login != null;
        boolean isSaveIdChecked = save_id != null;

        MemberDAO dao = new MemberDAO();
        MemberDTO member = dao.login(new MemberDTO(mem_id, mem_pw, null, null, null, null, null));

        if (member != null) {
            // 아이디 저장 처리
            if (isSaveIdChecked) {
            	HttpSession session = request.getSession(true); // 세션이 없으면 새로 생성
            	session.setAttribute("loginMember", member);
                session.setAttribute("savedId", mem_id);
                session.removeAttribute("loginMember");
                System.out.println("아이디저장");
            } else {
            	HttpSession session = request.getSession(true); // 세션이 없으면 새로 생성
            	session.setAttribute("loginMember", member);
                session.invalidate();
                System.out.println("아이디저장안됨");
            }

            // 자동 로그인 처리
            if (isSaveLoginChecked) {
            	HttpSession session = request.getSession(true); // 세션이 없으면 새로 생성
            	session.setAttribute("loginMember", member);
                // 세션 유지 시간 설정 (예: 30일)
                int maxAge = 30 * 24 * 60 * 60; // 30일을 초로 계산
                session.setMaxInactiveInterval(maxAge);
                session.setAttribute("autoLogin", true);
                System.out.println("자동로그인");
            } else {
            	HttpSession session = request.getSession(true); // 세션이 없으면 새로 생성
            	
                session.setAttribute("autoLogin", false);
                System.out.println("자동로그인안됨");
            }

            response.sendRedirect("my_fridge.html");
            System.out.println("로그인 성공");
            System.out.println("Session ID: " + member.getMem_id());
            System.out.println("Session Password: " + member.getMem_pw());

        } else {
            response.sendRedirect("login.html");
            System.out.println("로그인 실패");
        }
    }
}
