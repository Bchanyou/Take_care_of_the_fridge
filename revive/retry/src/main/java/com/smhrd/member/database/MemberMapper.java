package com.smhrd.member.database;

import com.smhrd.member.model.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    int checkMemberId(@Param("mem_id") String mem_id);

    MemberDTO selectMember(@Param("mem_id") String mem_id, @Param("mem_pw") String mem_pw);

    int memberInsert(MemberDTO member);

    int deletMember(@Param("mem_email") String mem_email);

    int updateMember(MemberDTO member);

    // 다른 메서드들...
}