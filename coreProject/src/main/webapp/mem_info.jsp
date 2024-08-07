<%@page import="com.smhrd.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberDTO member=(MemberDTO)session.getAttribute("loginMember");
%>

<%@include file ="header.jsp"%>


<!-- Util Page -->
<main class="py120 util_page">

	<section id="util_box">

		<div class="big_tit">
			<h3>
				<strong class="font">회원정보관리</strong>
			</h3>
		</div>

		<div class="bdr_wrap row">

			<div class="mid_tit" style="text-align: center;">
				<h3 class="font">
					<strong>비밀번호 확인</strong>
				</h3>
			</div>
			<p class="find_guide">회원님의 정보를 안전하게 보호하기 위해 비밀번호를 입력해주세요.</p>

			<!-- Form_PW_Check -->
			<form method="post" action="MemberEditLoginCon" name="">
				<div class="tb_wrap my50">
					<table>
						<caption>회원정보관리 비밀번호 확인</caption>
						<colgroup>
							<col width="30%">
						</colgroup>
						<tbody>
							<tr>
								<th>아이디</th>
								<!-- 아이디 반환 -->
								<td style="text-align: left;"><%
								String savedId = null;

								if (session != null) {
									savedId = (String) session.getAttribute("savedId");
								}

								if (savedId == null) {
									Cookie[] cookies = request.getCookies();
									if (cookies != null) {
										for (Cookie cookie : cookies) {
									if ("savedId".equals(cookie.getName())) {
										savedId = cookie.getValue();
										break;
									}
										}
									}
								}
								%> <%=savedId != null ? savedId : ""%></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pw"
									placeholder="비밀번호를 입력해주세요" autofocus></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_wrap center my30">
					<a href="index.jsp" class="btn bg w200">메인으로</a>
					<button type="submit" class="btn grn w200">확인</button>
				</div>
			</form>
			<!-- //Form_PW_Check -->
	</section>

</main>
<!-- // Util Page -->

<%@include file ="footer.jsp"%>