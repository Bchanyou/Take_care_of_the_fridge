package com.smhrd.ingredient.model;

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
	private String ingre_loc;

	// Getter and Setter methods

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

	public String getIngre_bundle() {
		return ingre_bundle;
	}

	public void setIngre_bundle(String ingre_bundle) {
		this.ingre_bundle = ingre_bundle;
	}

	public String getIngre_loc() {
		return ingre_loc;
	}

	public void setIngre_loc(String ingre_loc) {
		this.ingre_loc = ingre_loc;
	}

	// Constructor with all parameters
	public IngredientDTO(String mem_id, String mem_pw, String mem_type, int ingre_idx, String ingre_name,
			String purchased_at, String expired_at, String ingre_unit, String ingre_stock, String ingre_bundle,
			String ingre_loc) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_type = mem_type;
		this.ingre_idx = ingre_idx;
		this.ingre_name = ingre_name;
		this.purchased_at = purchased_at;
		this.expired_at = expired_at;
		this.ingre_unit = ingre_unit;
		this.ingre_stock = ingre_stock;
		this.ingre_bundle = ingre_bundle;
		this.ingre_loc = ingre_loc;
	}

	// 품목 소모 및 삭제를 위한 생성자
	public IngredientDTO(String mem_id, String ingre_name, String purchased_at) {
		this.mem_id = mem_id;
		this.ingre_name = ingre_name;
		this.purchased_at = purchased_at;
	}

	@Override
	public String toString() {
		return "IngredientDTO{" + "mem_id='" + mem_id + '\'' + ", mem_pw='" + mem_pw + '\'' + ", mem_type='" + mem_type
				+ '\'' + ", ingre_idx=" + ingre_idx + ", ingre_name='" + ingre_name + '\'' + ", purchased_at='"
				+ purchased_at + '\'' + ", expired_at='" + expired_at + '\'' + ", ingre_unit='" + ingre_unit + '\''
				+ ", ingre_stock='" + ingre_stock + '\'' + ", ingre_bundle='" + ingre_bundle + '\'' + ", ingre_loc='"
				+ ingre_loc + '\'' + '}';
	}

	// Default constructor
	public IngredientDTO() {
		super();
	}

	public IngredientDTO(String mem_id2, int ingre_idx) {
	}

	public IngredientDTO(int ingre_idx2) {
		// TODO Auto-generated constructor stub
	}

	// 생성자 추가
	public IngredientDTO(String mem_id, int ingre_idx, String ingre_name, String purchased_at, String expired_at,
			String ingre_unit, String ingre_stock, String ingre_bundle, String ingre_loc) {
		this.mem_id = mem_id;
		this.ingre_idx = ingre_idx;
		this.ingre_name = ingre_name;
		this.purchased_at = purchased_at;
		this.expired_at = expired_at;
		this.ingre_unit = ingre_unit;
		this.ingre_stock = ingre_stock;
		this.ingre_bundle = ingre_bundle;
		this.ingre_loc = ingre_loc;
	}
}
