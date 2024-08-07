<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<!-- Util Page -->
<main class="py120 util_page">

	<section id="util_box">

		<div class="big_tit">
			<h3>
				<strong class="font">회원가입</strong>
			</h3>
		</div>

		<!-- Form_join -->
		<form class="tb_wrap" method="post" action="MemberJoinCon" id="joinForm" onsubmit="submitFormWithData(); return false;">
			<div class="bdr_wrap row">
				<table>
					<caption>회원가입</caption>
					<colgroup>
						<col width="30%">
					</colgroup>
					<tbody>
						<tr>
							<th>아이디</th>
							<td class="disf">
								<input type="text" name="id" maxlength="50" placeholder="아이디를 입력해주세요" autofocus>
								<!-- <input type="text" name="id_check" style="display:none;"> -->
								<button type="button" class="un_check btn grn" onclick="submitForm('MemberCheckCon')">중복확인</button></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pw" maxlength="50"
								placeholder="비밀번호를 입력해주세요"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" name="pw_check" maxlength="50"
								placeholder="비밀번호를 입력해주세요"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" placeholder="이름을 입력해주세요"></td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td><input type="number" name="phone"
								placeholder="- 는 제외하고 숫자만 입력해주세요"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td class="disf"><input type="text" id="email" name="mail"
								placeholder="이메일"> <span>@</span>
								<div class="select_wrap">
									<select name="slt_mail" id="emailname" class="select">
										<option selected>선택하세요</option>
										<option>naver.com</option>
										<option>gmail.com</option>
									</select>
								</div></td>
						</tr>
					</tbody>
				</table>
				<div class="btn_wrap center my30">
					<button onclick="submitFormEmail('MemberEmailCheckCon')" type="button" class="btn grn w200">회원가입</button>
				</div>
			</div>
		</form>
		<!-- //Form_join -->

	</section>

</main>
<!-- // Util Page -->

<%@include file="footer.jsp"%>