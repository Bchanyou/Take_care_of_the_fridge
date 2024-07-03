<%@page import="com.smhrd.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<%
MemberDTO member = (MemberDTO)session.getAttribute("loginMember");

%>


<!-- Util Page -->
<main class="py120 util_page">

	<section id="util_box">

		<div class="big_tit">
			<h3>
				<strong class="font">회원가입 완료</strong>
			</h3>
		</div>

		<div class="bdr_wrap join_succ">
			<div class="imgBlock">
				<img src="./images/utilPage/welcome.jpg" alt="환영합니다">
			</div>
			<div class="mid_tit">

				<!-- 이름 반환 -->
				<h4 class="my30">
					<strong><span><%= request.getAttribute("mem_name") %> 님!</span><br>회원가입을 축하드립니다!</strong>
				</h4>
				<p>로그인하여 식품들의 유통기한을 간편하게 관리해보세요!</p>

			</div>
			<div class="btn_wrap center my30">
				<a href="login.jsp" class="btn grn w200">로그인</a>
			</div>
		</div>


	</section>

</main>
<!-- // Util Page -->


<%@include file="footer.jsp"%>