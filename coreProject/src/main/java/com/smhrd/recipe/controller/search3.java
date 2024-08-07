package com.smhrd.recipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.member.model.MemberDTO;
import com.smhrd.recipe.model.recipeDAO;
import com.smhrd.recipe.model.recipeDAO;

public class search3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 2. 세션 가져오기
        HttpSession session = request.getSession(true);
        MemberDTO member = (MemberDTO) session.getAttribute("loginMember");

        // 3. 회원 아이디 확인
        if (member == null) {
            // 4. 쿠키에서 아이디 가져오기
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("savedId")) {
                        String savedId = cookie.getValue();
                        System.out.println("Saved Id from cookie: " + savedId);
                        // 5. DAO를 사용하여 품목 리스트 조회
                        recipeDAO dao = new recipeDAO();
                        List<recipeDAO> recipeList = dao.search3(savedId);
                        request.setAttribute("recipeList", recipeList);
                        System.out.println(" 출력 : " + recipeList);

                        // 6. JSP 페이지로 포워드
                        RequestDispatcher dis = request.getRequestDispatcher("recipe.jsp");
                        dis.forward(request, response);
                        return; // 처리 완료 후 리턴
                    }
                }
            }

            // 7. 쿠키에 저장된 아이디가 없는 경우 로그인 페이지로 리다이렉트
            System.out.println("쿠키에 저장된 아이디가 없습니다.");
            response.sendRedirect("login.jsp");
            return; // 리다이렉트 후 리턴
        } else {
            // 8. 세션에 저장된 회원 정보로 품목 리스트 조회
            String id = member.getMem_id();
            System.out.println("Saved Id from session: " + id);

            // 9. DAO를 사용하여 품목 리스트 조회
            recipeDAO dao = new recipeDAO();
            List<recipeDAO> recipeList = dao.search3(id);
            request.setAttribute("recipeList", recipeList);
            System.out.println(" 출력 : " + recipeList);

            // 10. JSP 페이지로 포워드
            RequestDispatcher dis = request.getRequestDispatcher("recipe.jsp");
            dis.forward(request, response);
            return; // 처리 완료 후 리턴
        }
    }
}
