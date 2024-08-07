package com.smhrd.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.member.model.MemberDAO;
import com.smhrd.member.model.MemberDTO;

public class MemberIdFindCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("join controller");

		// 1. 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 2. 파라미터 받기
		String mem_name = (String) request.getParameter("name"); // 이름 파라미터 받기
		System.out.println(mem_name);
		String mem_email = (String) request.getParameter("mail") + "@" + request.getParameter("slt_mail"); // 이메일 파라미터
																											// 받기
		System.out.println(mem_email);
		// 3. DAO 호출 및 처리
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.findId(mem_name, mem_email);
		
		if (memberList != null && !memberList.isEmpty()) {
			MemberDTO member = memberList.get(0); // 여기서는 첫 번째 회원만 가져온다고 가정
			// JSP에 전달할 데이터 설정
			request.setAttribute("userName", member.getMem_name());
			request.setAttribute("userId", member.getMem_id());

			// JSP 페이지로 포워드
			RequestDispatcher dis = request.getRequestDispatcher("find_id_succ.jsp");
			dis.forward(request, response);
		} else {
			// 회원을 찾지 못한 경우 처리
			// JavaScript alert를 사용하여 알림창 띄우기
			String alertScript = "<script>alert('" + "회원 정보를 찾을 수 없습니다. 다시 입력해 주세요." + "'); location.href='"
					+ request.getContextPath() + "/find_id.jsp';</script>";
			response.getWriter().println(alertScript);
		}
	}
}
