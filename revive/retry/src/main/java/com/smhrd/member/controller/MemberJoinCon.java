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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("join controller!");
		// 1. 한글 인코딩
		request.setCharacterEncoding("UTF-8");

		// 2. 데이터 가지고 오기
		String mem_id = request.getParameter("id");
		String mem_pw = request.getParameter("pw");
		String mem_pw_check = request.getParameter("pw_check");
		String mem_name = request.getParameter("name");
		String mem_phone = request.getParameter("phone");
		String mem_email = request.getParameter("mail")+"@"+request.getParameter("slt_mail");
		String joinAtString = request.getParameter("joinAt");
//		String mem_type = request.getParameter("mem_type");

		// 현재 시간 가져오기
		LocalDateTime joined_At = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (mem_pw_check.equals(mem_pw)&&mem_pw.length()>=13) {

			try {
				if (joinAtString != null && !joinAtString.isEmpty()) {
					joined_At = LocalDateTime.parse(joinAtString, formatter); // 문자열을 LocalDateTime으로 변환
				} else {
					joined_At = LocalDateTime.now(); // 현재 시간을 기본값으로 설정
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 예외 처리: 날짜 포맷이 맞지 않는 경우 처리
			}

			// MemberDTO 객체 생성 및 데이터 설정
			MemberDTO member = new MemberDTO(mem_id, mem_pw, mem_name, mem_phone, mem_email, joined_At, null);

			// MemberDAO 객체 생성 및 회원 가입 처리
			MemberDAO dao = new MemberDAO();
			int row = dao.join(member);

			if (row > 0) {
				// 회원가입 성공
				System.out.println("회원가입 성공");
				response.sendRedirect("login.jsp");
			} else {
				// 회원가입 실패
				System.out.println("회원가입 실패");
				response.sendRedirect("join.html");
			}

		} else {
			System.out.println("회원가입 실패");
			response.getWriter().write("password_invalid"); // Ajax 응답으로 비밀번호 불일치 메시지 전송
			
//			//비밀번호 규칙
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter writer = response.getWriter();
//			writer.println("<script>alert('비밀번호는 13글자 이상입니다'); location.href='"+"join.html"+"';</script>"); 
//			writer.close();
		}

	}

}
