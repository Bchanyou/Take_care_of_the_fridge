
/*
 * File Name : common.js
 * 작성일 : 2024-06-14
 */


/********************************************************
 
 *  Common
 
 ********************************************************/

$(function () {

	"use strict";

	/*Document Ready Start---------------------------------------------------*/

	/*-----------------------------------------------------------------------------
	 *  Drop Down
	 *----------------------------------------------------------------------------*/

	$(".drop_sub").hide();

	$('.drop_title').on("click", function (event) {
		event.stopPropagation();
		$(".drop_sub").slideUp("fast");
		$('.drop_title').removeClass("active");
		if (!$(this).next("ul").is(":visible")) {
			$(this).next("ul").slideDown("fast");
			$(this).addClass("active");
		}
	});

	$(document).on("click", function () {
		$('.drop_sub').slideUp("fast");
		$('.drop_title').removeClass("active");
	});


	/*-----------------------------------------------------------------------------
	 *  Check All
	 *----------------------------------------------------------------------------*/

	$("#check_all").click(function () {

		var check = $("#check_all").prop("checked");
		if (check) {
			$("input.chk").prop("checked", true);
		} else {
			$("input.chk").prop("checked", false);

		}

	})


	/*-----------------------------------------------------------------------------
	 *  Modal 
	 *----------------------------------------------------------------------------*/

	$(".btn_modal").click(function () {
		$(".modal_box").addClass("on");
		$(".modal_back").fadeIn();
	})

	$(".btn_modal_close").click(function () {
		$(".modal_back").fadeOut();
		$(".modal_box").removeClass("on");
	})


	



	// 구매일 설정
	var today = new Date().toISOString().split('T')[0];
	var dateInput = document.getElementById('date_buy');
	dateInput.value = today;

	// yy-mm-dd 포맷
	function formatDate() {

		var input = document.getElementsByClassName("date_format");

		// Get the selected date (YYYY-MM-DD format)
		var selectedDate = input[0].value;
		console.log(selectedDate)

		// Split the date string by "-"
		var parts = selectedDate.split("-");

		// Extract year, month, and day
		var year = parts[0].substring(2); // Get last two digits of the year
		var month = parts[1];
		var day = parts[2];

		// Format the date as 24-06-17
		var formattedDate = year + "-" + month + "-" + day;
		console.log(formattedDate)

		// Display the formatted date
		// document.getElementsByClassName("date_format")[0].value = formattedDate;
	}


});


/*-----------------------------------------------------------------------------
*  품목추가
*----------------------------------------------------------------------------*/

$(document).ready(function () {

	// 테이블 상태 업데이트 함수
	function updateFridgeTable() {
		var rowCount = $('.fridge_list tbody tr').length;
		console.log(rowCount)
		if (rowCount === 0) {
			// 행이 없을 경우
			$('.fridge_null').show();
			$('.check_del').hide();
			
		} else {
			// 행이 있을 경우
			$('.fridge_null').hide(); 
			$('.check_del').show();
		}
	}

	updateFridgeTable(); // 테이블 상태 업데이트
	
	// 행 추가 및 삭제
	$(".row_add").click(function () {
		var rowCnt = $(".add_list tbody tr").length;
		rowCnt += 1;
		let rowAdd = $(".add_list tbody").append("<tr><td>" + rowCnt + "</td><td><input type='text' placeholder='품목명 입력'></td><td class='unit'><input type='text'><div class='select_wrap'><select name='unit' class='select' title='품목 단위'><option selected>개</option><option>ml</option></select></div></td><td><input type='number' value='1'></td><td class='date_picker'><input type='date' id='date_buy" + rowCnt + "' class='date_format' onchange='formatDate()'></td><td class='date_picker'><div class='file_wrap'><input type='date' id='date_exp" + rowCnt + "' class='date_format' onchange='formatDate()'><input type='file' id='file" + rowCnt + "' class='inpFile' style='display: none;'><label for='file" + rowCnt + "' class='file_upload'><i class='fa-regular fa-image' style='color: #2ec758;'></i></label></div></td><td><div class='select_wrap loca'><select name='location' class='select' title='보관위치'> <option selected>냉장칸</option><option>야채칸</option><option>날개칸</option></select></div></td><td><div class='row_del'><a href='#;'><img src='/images/sub/delete.png' alt='행 삭제 버튼'></a></div></td></tr>");

		// 행 삭제 버튼 클릭
		rowAdd.find('.row_del').click(function (e) {
			e.preventDefault(); // 기본 동작 방지
			$(this).closest('tr').remove(); // 해당 행 삭제
			updateRowCnt(); // 행 삭제 후 행 번호 업데이트
		});

		$('.add_list tbody').append(rowAdd); // 새로운 행 추가

	});

	// 행 삭제 후 행 번호 업데이트
	function updateRowCnt() {
		var rowCntNew = 1;
		$('.add_list tbody tr').each(function (index) {
			$(this).find('td:first-child').text(rowCntNew++);
		});
	}


	/*Document Ready End----------------------------------------------------*/
})


/*-----------------------------------------------------------------------------
 *  Select
 *----------------------------------------------------------------------------*/

/*
 * Project: Select_box
 * Description: Select dropdown jQuery plug-in
 * Author: https://github.com/Wancieho
 * License: MIT
 * Version: 0.0.4
 * Dependancies: jquery-1.*
 * Date: 24/11/2016
 */
!function (t, e, i, s) { "use strict"; function n(e, i) { this.$select = t(e), this.$clicker = null, this.$ul = null, this.settings = t.extend({}, h, i), l.apply(this) } function l() { var e = this, n = "" !== this.settings.theme && this.settings.theme !== s ? " " + this.settings.theme : ""; if (this.$select.attr("name") === s) throw this.$select.wrap('<span style="outline: 5px solid red">'), "Name attribute must be specified"; this.$select.wrap('<div class="select_box' + n + '"></div>').parent().append('<a href="#" class="select_title"><span></span><div class="arrow"></div></a><ul></ul>'), this.$clicker = this.$select.siblings(".select_title"), this.$ul = this.$select.siblings("ul"), this.$clicker.on("click", function (s) { s.preventDefault(), s.stopPropagation(), 0 === d.length && t(i).on("click", function () { e.close() }), e.settings.allowMultiple || e.close(null, e.$select), e.$ul.find("li").length > 0 && (t(this).hasClass("open") ? e.close(e.$select) : (t(this).addClass("open"), e.$ul.stop(!0).slideDown(e.settings.transitionSpeed))) }), 0 === d.length && t(i).on("click", function () { e.close() }), d.push(this.$select), this.update() } function a(t) { t !== o.apply(this) && (this.$select.find("option").removeAttr("selected").prop("selected", !1).eq(t).attr("selected", "selected").prop("selected", !0), this.$select.trigger("change"), c.apply(this)), this.close() } function c() { this.$clicker.find("span").text(this.$select.find("option:selected").text()), this.$ul.find("a").removeClass("selected"), this.$ul.find('a[data-index="' + o.apply(this) + '"]').addClass("selected") } function o() { if (this.$select.find("optgroup").length > 0) { var e = 0, i = 0; return t.each(this.$select.find("optgroup"), function () { t.each(t(this).find("option"), function () { t(this).is(":selected") && (i = e), e++ }) }), i } return this.$select.find("option:selected").index() } var p = "select_box", h = { transitionSpeed: 150, allowMultiple: !0, theme: "" }, d = []; t.extend(n.prototype, { update: function () { var e = this; if (this.$ul.find("a").unbind(), this.$ul.empty(), this.$select.find("optgroup").length > 0) { var i = 0; t.each(this.$select.find("optgroup"), function (s, n) { e.$ul.append('<li class="optgroup"><span>' + t(n).attr("label") + "</span></li>"), t.each(t(this).find("option"), function (s, n) { e.$ul.append('<li class="option"><a href="#" data-value="' + t(n).val() + '" data-index="' + i + '">' + t(n).text() + "</a></li>"), i++ }) }) } else t.each(this.$select.find("option"), function (i, s) { e.$ul.append('<li class="option"><a href="#" data-value="' + t(s).val() + '" data-index="' + i + '">' + t(s).text() + "</a></li>") }); 0 === this.$select.find("option[selected]").length && this.$select.find("option").eq(0).attr("selected", "selected"), c.apply(e), this.$select.trigger("update"), this.$ul.find("a").unbind().on("click", function (i) { i.preventDefault(), i.stopPropagation(), a.apply(e, [parseInt(t(this).attr("data-index"))]) }) }, close: function (e, i) { var n = this; e instanceof t ? e.siblings(".select_title").hasClass("open") && (e.siblings(".select_title").removeClass("open"), e.siblings("ul").stop(!0).slideUp(this.settings.transitionSpeed)) : t.each(d, function () { i !== s && this.attr("name") === i.attr("name") || n.close(this) }) } }), t.fn[p] = function (e) { return this.each(function () { if (t.data(this, "plugin_" + p)) switch (e) { case "update": t(this).data("plugin_" + p).update(); break; case "close": t(this).data("plugin_" + p).close(t(this)) } else t.data(this, "plugin_" + p, new n(this, e)) }) } }(jQuery, window, document);


(function ($) {
	$(document).ready(function () {

		// 초기 로드 시 select_box 플러그인 적용
		$('.select').select_box({ allowMultiple: false });

		// 행 추가 버튼 클릭 시
		$('.row_add').on('click', function () {

			// 새로운 행에 대해 select_box 플러그인 다시 적용
			$('.select').select_box({ allowMultiple: false });
		});
	});
})(jQuery);

