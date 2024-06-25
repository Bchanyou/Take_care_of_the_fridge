package com.smhrd.board.model;

import java.time.LocalDateTime;

public class BoardDTO {

    

	private String bo_idx;
    private String bo_title;
    private String bo_content;
    private String created_at;
    private String bo_views;
    private String bo_likes;
    private String mem_id;
    
    
    
	public String getBo_idx() {
		return bo_idx;
	}
	public void setBo_idx(String bo_idx) {
		this.bo_idx = bo_idx;
	}
	public String getBo_title() {
		return bo_title;
	}
	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getBo_views() {
		return bo_views;
	}
	public void setBo_views(String bo_views) {
		this.bo_views = bo_views;
	}
	public String getBo_likes() {
		return bo_likes;
	}
	public void setBo_likes(String bo_likes) {
		this.bo_likes = bo_likes;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public BoardDTO(String bo_idx, String bo_title, String bo_content, String created_at, String bo_views,
			String bo_likes, String mem_id) {
		super();
		this.bo_idx = bo_idx;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
		this.created_at = created_at;
		this.bo_views = bo_views;
		this.bo_likes = bo_likes;
		this.mem_id = mem_id;
	}
    

	

}