package com.smhrd.member.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.member.model.MemberDAO;
import com.smhrd.member.model.MemberDTO;

public class MemberAutoLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("자동로그인서블릿");
        HttpSession session = request.getSession(false); // 이미 존재하는 세션을 가져옴
        System.out.println("자동 로그인되었습니다");
        if (session == null || session.getAttribute("loginMember") == null) { // 세션이 없거나 로그인 정보가 없는 경우
            // 쿠키에서 autoLogin 정보를 가져옴
            javax.servlet.http.Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (javax.servlet.http.Cookie cookie : cookies) {
                    if (cookie.getName().equals("autoLogin")) {
                        // 쿠키에서 인코딩된 정보를 디코딩하여 아이디와 비밀번호를 가져옴
                        String[] loginInfo = new String(Base64.getDecoder().decode(cookie.getValue())).split(":");
                        if (loginInfo.length == 2) {
                            String mem_id = loginInfo[0];
                            String mem_pw = loginInfo[1];

                            MemberDAO dao = new MemberDAO();
                            MemberDTO member = dao.selectMember(new MemberDTO(mem_id, mem_pw, null, null, null, null, null));
                            if (member != null) {
                                session = request.getSession(); // 새로운 세션을 생성하거나 기존 세션을 가져옴
                                session.setAttribute("loginMember", member); // 세션에 로그인 정보를 저장
                                System.out.println("자동 로그인되었습니다");
                            }
                        }
                    }
                }
            }
        }

        response.sendRedirect("index.jsp"); // 메인 페이지로 리다이렉트
    }
}
