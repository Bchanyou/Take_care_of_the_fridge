package com.smhrd.member.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.member.database.MemberMapper;
import com.smhrd.member.database.SqlSessionManager;

public class MemberDAO {

	// 0. Factory 가지고 오기
	// DB연결, 쿼리문 수행, DB종료를 작업할 수 있는 객체 생성
	SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();

	// 회원 가입 기능
	public int join(MemberDTO member) {
		SqlSession sqlSession = factory.openSession(true);// true 반드시 넣기

		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.member.database.MemberMapper.memberInsert", member);// mapper안에 작성한 매개변수
																									// 찾기

			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println("회원가입 실패!");
			e.printStackTrace();
		} finally {
			// 3. session 자원 반납
			sqlSession.close();
		}

		return cnt;
	}// 회원가입 끝

	// 중복 체크
	public int check(String mem_id) {
		try (SqlSession sqlSession = factory.openSession()) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			return mapper.checkMemberId(mem_id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 로그인 기능
	public MemberDTO login(MemberDTO member) {
		SqlSession sqlSession = factory.openSession(true);// true 반드시 넣기

		MemberDTO mem = null;

		try {
			mem = sqlSession.selectOne("com.smhrd.member.database.MemberMapper.selectMember", member);

			if (mem != null) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return mem;
	}// 로그인 끝

	public boolean autologin(HttpServletRequest request, HttpServletResponse response) {
		// 사용자의 브라우저에서 쿠키를 받아옵니다.
		Cookie[] cookies = request.getCookies();

		// 쿠키가 존재하는지 확인합니다.
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 쿠키의 이름이 "autologin"인지 확인합니다.
				if (cookie.getName().equals("autologin")) {
					String[] values = cookie.getValue().split(":");
					String mem_id = values[0]; // 쿠키에서 저장된 회원 아이디를 가져옵니다.
					String mem_pw = values[1]; // 쿠키에서 저장된 회원 비밀번호를 가져옵니다.

					// DB에서 mem_id와 mem_pw를 이용하여 회원 정보를 조회합니다.
					MemberDTO member = new MemberDTO();
					member.setMem_id(mem_id);
					member.setMem_pw(mem_pw);

					// 실제로 로그인 기능을 수행하여 회원 정보를 가져옵니다.
					MemberDTO loggedMember = login(member);

					// 회원 정보가 존재한다면 로그인 성공 처리를 합니다.
					if (loggedMember != null) {
						return true;
					}
				}
			}
		}

		return false; // 자동 로그인 실패
	}

	// 회원탈퇴 기능
	public int withdrawal(String deleteEmail) {
		SqlSession sqlSession = factory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.smhrd.model.database.MemberMapper.deletMember", deleteEmail);
			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;

	}// 회원탈퇴끝

	// 회원정보 수정
	public int update(MemberDTO updateMember) {
		SqlSession sqlSession = factory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.smhrd.member.database.MemberMapper.updateMember", updateMember);

			if (cnt > 0) {
				System.out.println("완료");
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}// 회원정보 수정 끝

	public MemberDTO selectMember(MemberDTO memberDTO) {
		return null;
	}
}
