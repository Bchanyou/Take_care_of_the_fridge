package com.smhrd.member.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.member.model.MemberDAO;
import com.smhrd.member.model.MemberDTO;

public class MemberJoinCon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터에서 필요한 값 추출
        String mem_id = request.getParameter("id");
        String mem_pw = request.getParameter("pw");
        String mem_name = request.getParameter("name");
        String mem_phone = request.getParameter("phone");
        String mem_email = request.getParameter("mail") + "@" + request.getParameter("slt_mail");

        // 현재 시간 가져오기
        LocalDateTime joined_At = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // MemberDTO 객체 생성 및 데이터 설정
        MemberDTO member = new MemberDTO(mem_id, mem_pw, mem_name, mem_phone, mem_email, joined_At, null);

        // MemberDAO 객체 생성 및 회원 가입 처리
        MemberDAO dao = new MemberDAO();
        int row = dao.join(member);

        if (row > 0) {
            // 회원가입 성공
            System.out.println("회원가입 성공!!!!!");
            response.getWriter().write("success");
        } else {
            // 회원가입 실패
            System.out.println("회원가입 실패");
            response.getWriter().write("failure");
        }
    }
}
