package com.smhrd.member.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MemberDTO {

    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String mem_phone;
    private String mem_email;
    private LocalDateTime joined_at;
    private String mem_type;

    // 생성자, 게터, 세터 생략

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public String getMem_email() {
        return mem_email;
    }

    public void setMem_email(String mem_email) {
        this.mem_email = mem_email;
    }

    public LocalDateTime getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(LocalDateTime joined_at) {
        this.joined_at = joined_at;
    }

    public String getMem_type() {
        return mem_type;
    }

    public void setMem_type(String mem_type) {
        this.mem_type = mem_type;
    }

    // 생성자 추가
    public MemberDTO(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_email,
            LocalDateTime joined_At2, String mem_type) {
        super();
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
        this.mem_name = mem_name;
        this.mem_phone = mem_phone;
        this.mem_email = mem_email;
        this.joined_at = joined_At2;
        this.mem_type = mem_type;
    }

    // 기본 생성자
    public MemberDTO() {
        super();
    }

}
