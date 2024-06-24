package com.smhrd.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		String id_check = request.getParameter("id_check");
		System.out.println(id_check);

		// 현재 시간 가져오기
		LocalDateTime joined_At = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// MemberDTO 객체 생성 및 데이터 설정
		MemberDTO member = new MemberDTO(mem_id, mem_pw, mem_name, mem_phone, mem_email, joined_At, null);

		// MemberDAO 객체 생성 및 회원 가입 처리
		MemberDAO dao = new MemberDAO();
		int row = dao.join(member);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (id_check != null && id_check.equals("중복확인완료")) {
			if (row > 0) {
				// 회원가입 성공
				System.out.println("회원가입 성공!!!!!");
				out.println("<script>alert('회원가입 성공!!!!!'); location.href='login.jsp';</script>");
			} else {
				// 회원가입 실패
				System.out.println("회원가입 실패");
				out.println("<script>alert('회원가입 실패'); history.back();</script>");
			}
		} else {
			System.out.println("아이디 중복을 확인해주세요!!!!!");
			out.println("<script>alert('아이디 중복을 확인해주세요!!!!!'); history.back();</script>");
		}
		out.close();
	}
}
