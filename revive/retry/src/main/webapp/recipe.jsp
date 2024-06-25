<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "header.jsp" %>


        <!-- container -->
        <main id="sub">
            <section id="container">

                <!-- Sub Visual -->
                <section id="sub_vis" class="sv03">
                    <div id="sub_tit" class="w1280">
                        <h2><strong class="font">추천 레시피</strong></h2>
                        <p>유통기한이 임박한 식재료를 활용한 레시피를 추천해드립니다.</p>
                    </div>
                </section>

                <!-- Sub Content -->
                <section id="content" class="my120">

                    <section class="w1280">
                        <div class="big_tit">
                            <h3><strong>추천 레시피</strong></h3>
                        </div>

                        <section class="sub_cont" id="recipe">
                            <div class="swp_wrap" style="display: none;">
                                <div class="swiper-button-prev swp_btn"><i class="fa-solid fa-chevron-left fa-2xl"
                                        style="color: #666;"></i></div>
                                <div class="swiper-button-next swp_btn"><i class="fa-solid fa-chevron-right fa-2xl"
                                        style="color: #666;"></i></div>
                                <div class="swiper-container swp_basic">
                                    <div class="swiper-wrapper">
                                        <div class="swiper-slide">
                                            <div class="img"><img
                                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCwg4AVVn2YT1ZrAQ21cjD3oO1P6n8ySiomQ&s"
                                                    alt=""></div>
                                            <a href="#;" class="btn_view"><span>요리이름</span></a>
                                            <ul class="keywords pa50">
                                                <li>감자</li>
                                                <li>감자</li>
                                                <li>감자</li>
                                            </ul>
                                        </div>
                                        <div class="swiper-slide">
                                            <div class="img"><img src="" alt=""></div>
                                            <a href="#;" class="btn_view"><span>요리이름</span></a>
                                            <ul class="keywords pa50">
                                                <li>감자</li>
                                                <li>감자</li>
                                                <li>감자</li>
                                            </ul>
                                        </div>
                                        <div class="swiper-slide">
                                            <div class="img"><img src="" alt=""></div>
                                            <a href="#;" class="btn_view"><span>요리이름</span></a>
                                            <ul class="keywords pa50">
                                                <li>감자</li>
                                                <li>감자</li>
                                                <li>감자</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- 추천 레시피 없는 경우 -->
                            <div class="bdr_wrap recipe_null">
                                <div class="info_box null_box">
                                    <p class="ico_info">유통기한이 임박한 재료가 없습니다.</p>
                                </div>
                                <p>아직 등록하지 않은 재료가 있다면 추가해보세요!</p>
                                <div class="btn_wrap my30 center">
                                    <button class="btn grn btn_modal" type="button">추가하기</button>
                                </div>
                            </div>

                        </section>

                    </section>

                    <!-- 품목추가 팝업창 -->
                    <div class="modal_box w1280 pa50">

                        <div class="imgBlock btn_modal_close"><a href="#;"><img src="./images/sub/modal_close.png"
                                    alt="팝업창 닫기"></a></div>

                        <div class="mid_tit">
                            <h4><strong>품목 추가</strong></h4>
                        </div>

                        <form action="">
                            <div class="bdr_wrap">
                                <table class="add_list">
                                    <caption>품목 추가</caption>
                                    <colgroup>
                                        <col width="60px">
                                        <col>
                                        <col width="18%">
                                        <col width="10%">
                                        <col>
                                        <col>
                                        <col>
                                        <col width="50px">
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>품목명</th>
                                            <th>단위</th>
                                            <th>수량</th>
                                            <th>구매날짜</th>
                                            <th>유통기한</th>
                                            <th>위치</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td><input type="text" placeholder="품목명 입력"></td>
                                            <td class="unit">
                                                <div class="select_wrap">
                                                    <select name="unit" class="select" title="품목 단위">
                                                        <option selected>개</option>
                                                        <option id="slt_ml">ml</option>
                                                    </select>
                                                </div>
                                                <input type="text" class="unit_input" disabled>
                                            </td>
                                            <td class="qtt_num">
                                                <input type="number" value="1">
                                            </td>
                                            <td class="date_picker">
                                                <input type="date" id="date_buy" class="date_format">
                                            </td>
                                            <td class="date_picker">
                                                <input type="date" id="date_exp" class="date_format">
                                            </td>
                                            <td>
                                                <div class="select_wrap loca">
                                                    <select name="location" class="select" title="보관위치">
                                                        <option selected>냉장칸</option>
                                                        <option>야채칸</option>
                                                        <option>날개칸</option>
                                                    </select>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="row_del"><a href="#;"><img src="./images/sub/delete.png"
                                                            alt="행 삭제 버튼"></a></div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p class="ico_info">상품의 유통기한이 촬영된 사진을 업로드하시면 유통기한이 자동으로 입력됩니다.</p>
                            <div class="btn_wrap my30">

                                <div class="lb">
                                    <label for="file1" class="btn grn file_upload">사진 업로드</label>
                                    <input type="file" id="file1" class="inpFile" style="display: none;">

                                </div>
                                <div class="rb">
                                    <button class="btn bg row_add" type="button">행 추가</button>
                                    <button class="btn grn" type="submit">완료</button>
                                </div>
                            </div>

                        </form>
                        <script>
                            // 구매일 설정
                            var today = new Date().toISOString().split('T')[0];
                            var dateInput = document.getElementById('date_buy');
                            dateInput.value = today;
                        </script>
                    </div>
                    <!-- // 품목추가 팝업창 -->

                    <!-- 팝업창 백그라운드 -->
                    <div class="modal_back"></div>

                </section>
                <!-- //Sub Content -->

            </section>

        </main>
        <!-- //container -->


        <!-- Footer -->
        <footer id="footer" class="pdH">
            <div class="ftr_inner">
                <address>
                    <span>대표자 : 홍길동</span>
                    <span>사업자등록번호 : 000-00-0000</span>
                    <span>주소 : 광주광역시 동구 예술길</span>
                    <span>대표전화 : 00-000-0000</span>
                    <span>팩스 : 00-000-0000</span>
                </address>
                <p class="copyright">Copyright @ 2024 by Connected Inc. All Rights Reserved.</p>
            </div>
        </footer>
        <!-- //Footer -->

    </div>



</body>

</html>