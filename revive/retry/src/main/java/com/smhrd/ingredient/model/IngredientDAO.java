package com.smhrd.ingredient.model;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.ingredient.database.IngredientMapper;
import com.smhrd.ingredient.database.SqlSessionManager;

public class IngredientDAO {

	// 0. Factory 가지고 오기
	// DB연결, 쿼리문 수행, DB종료를 작업할 수 있는 객체 생성
	SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();

	// 품목 추가 기능
	public int add(IngredientDTO ingredient) {
		SqlSession sqlSession = factory.openSession(true);// true 반드시 넣기

		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.ingredient.database.IngredientMapper.insertIngredient", ingredient);// mapper안에 작성한 매개변수
																									// 찾기

			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println("품목추가 실패!");
			e.printStackTrace();
		} finally {
			// 3. session 자원 반납
			sqlSession.close();
		}

		return cnt;
	}// 품목 추가 끝
	
	 // 모든 품목 조회
    public List<IngredientDTO> search(String mem_id) {
        SqlSession sqlSession = factory.openSession(true); // true 반드시 넣기
        List<IngredientDTO> list = null;

        try {
            IngredientMapper mapper = sqlSession.getMapper(IngredientMapper.class);
            list = mapper.listIngredient(mem_id); // mem_id를 이용해 해당 회원의 품목 조회
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }// 품목 조회 끝

}