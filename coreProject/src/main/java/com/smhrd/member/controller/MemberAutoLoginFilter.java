package com.smhrd.member.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.member.model.MemberDAO;
import com.smhrd.member.model.MemberDTO;

public class MemberAutoLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("자동로그인필터 시작");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false); // 이미 존재하는 세션을 가져옴

        if (session == null || session.getAttribute("loginMember") == null) { // 세션이 없거나 로그인 정보가 없는 경우
            System.out.println("세션이 없거나 로그인 정보가 없습니다.");
            // 쿠키에서 autoLogin 정보를 가져옴
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("autoLogin")) {
                        System.out.println("autoLogin 쿠키 발견");
                        try {
                            // 쿠키에서 인코딩된 정보를 디코딩하여 아이디와 비밀번호를 가져옴
                            String decodedValue = new String(Base64.getDecoder().decode(cookie.getValue()));
                            System.out.println("디코딩된 쿠키 값: " + decodedValue);
                            String[] loginInfo = decodedValue.split(":");
                            if (loginInfo.length == 2) {
                                String mem_id = loginInfo[0];
                                String mem_pw = loginInfo[1];
                                System.out.println("디코딩된 정보: ID=" + mem_id + ", PW=" + mem_pw);

                                MemberDAO dao = new MemberDAO();
                                MemberDTO member = dao.selectMember(new MemberDTO(mem_id, mem_pw, null, null, null, null, null));
                                if (member != null) {
                                    session = httpRequest.getSession(); // 새로운 세션을 생성하거나 기존 세션을 가져옴
                                    session.setAttribute("loginMember", member); // 세션에 로그인 정보를 저장
                                    System.out.println("자동 로그인되었습니다");
                                } else {
                                    System.out.println("멤버를 찾을 수 없습니다");
                                }
                            } else {
                                System.out.println("로그인 정보가 올바르지 않습니다");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("쿠키 디코딩 중 오류 발생: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("예상치 못한 오류 발생: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("쿠키가 없습니다");
            }
        } else {
            System.out.println("이미 로그인된 상태입니다");
        }

        System.out.println("자동로그인필터 종료");
        chain.doFilter(request, response); // 다음 필터로 요청과 응답을 전달
    }

    public void destroy() {}
}