package com.smhrd.ingredient.model;

import java.time.LocalDateTime;

public class IngredientDTO {

    private String mem_id;
    private String mem_pw;
    private String mem_type;
    
    private int ingre_idx;
    private String ingre_name;
    private String purchased_at;
    private String expired_at;
    private String ingre_unit;
    private String ingre_stock;
    private String ingre_bundle;
    
    
    
    

	public String getIngre_bundle() {
		return ingre_bundle;
	}

	public void setIngre_bundle(String ingre_bundle) {
		this.ingre_bundle = ingre_bundle;
	}

	private String ingre_loc; 

    // 생성자, 게터, 세터 생략

    public int getIngre_idx() {
		return ingre_idx;
	}

	public void setIngre_idx(int ingre_idx) {
		this.ingre_idx = ingre_idx;
	}

	public String getIngre_name() {
		return ingre_name;
	}

	public void setIngre_name(String ingre_name) {
		this.ingre_name = ingre_name;
	}

	public String getPurchased_at() {
		return purchased_at;
	}

	public void setPurchased_at(String purchased_at) {
		this.purchased_at = purchased_at;
	}

	public String getExpired_at() {
		return expired_at;
	}

	public void setExpired_at(String expired_at) {
		this.expired_at = expired_at;
	}

	public String getIngre_unit() {
		return ingre_unit;
	}

	public void setIngre_unit(String ingre_unit) {
		this.ingre_unit = ingre_unit;
	}

	public String getIngre_stock() {
		return ingre_stock;
	}

	public void setIngre_stock(String ingre_stock) {
		this.ingre_stock = ingre_stock;
	}

	public String getIngre_loc() {
		return ingre_loc;
	}

	public void setIngre_loc(String ingre_loc) {
		this.ingre_loc = ingre_loc;
	}

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


    public String getMem_type() {
        return mem_type;
    }

    public void setMem_type(String mem_type) {
        this.mem_type = mem_type;
    }

    // 생성자 추가
    public IngredientDTO(String mem_id, String ingre_name, String purchased_at, String expired_at,
    		String ingre_unit, String ingre_stock, String ingre_bundle, String ingre_loc) {
    	super();
    	this.mem_id = mem_id;
    	this.ingre_name = ingre_name;
    	this.purchased_at = purchased_at;
    	this.expired_at = expired_at;
    	this.ingre_unit = ingre_unit;
    	this.ingre_stock = ingre_stock;
    	this.ingre_bundle = ingre_bundle;
    	this.ingre_loc = ingre_loc;
    }
    
    //    public IngredientDTO(String mem_id, String ingre_name, String purchased_at, String expired_at,
//    		String ingre_unit, String ingre_stock2, String ingre_bundle2, String ingre_loc) {
//    	this.mem_id = mem_id;
//    	this.ingre_name = ingre_name;
//    	this.purchased_at = purchased_at;
//    	this.expired_at = expired_at;
//    	this.ingre_unit = ingre_unit;
//    	this.ingre_stock = ingre_stock2;
//    	this.ingre_bundle = ingre_bundle2;
//    	this.ingre_loc = ingre_loc;
//    }

    // 기본 생성자
    public IngredientDTO() {
        super();
    }

}