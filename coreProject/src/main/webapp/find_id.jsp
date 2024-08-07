<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<!-- Util Page -->
<main class="py120 util_page">

	<section id="util_box">

		<div class="big_tit">
			<h3>
				<strong class="font">아이디 찾기</strong>
			</h3>
		</div>

		<!-- Form_Find_ID -->
		<form class="tb_wrap" method="post" action="MemberIdFindCon" name="">
			<div class="bdr_wrap row">

				<p class="find_guide">
					회원님의 소중한 개인정보 보호를 위하여 본인확인이 필요합니다.</br>회원가입 시 등록한 이름과 이메일을 입력해 주세요.
				</p>

				<table>
					<caption>아이디 찾기</caption>
					<colgroup>
						<col width="25%">
					</colgroup>
					<tbody>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" maxlength="50"
								placeholder="이름을 입력해주세요" autofocus></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td class="disf"><input type="text" name="mail"
								placeholder="이메일을 입력해주세요."> <span>@</span>
								<div class="select_wrap">
									<select name="slt_mail" class="select">
										<option selected>선택하세요</option>
										<option>naver.com</option>
										<option>gmail.com</option>
									</select>
								</div></td>
						</tr>
					</tbody>
				</table>

				<div class="btn_wrap center my30">
					<button type="submit" class="btn grn w200">아이디 찾기</button>
				</div>

			</div>
		</form>
		<!-- //Form_Find_ID -->

	</section>

</main>
<!-- // Util Page -->

<%@include file="footer.jsp"%>
