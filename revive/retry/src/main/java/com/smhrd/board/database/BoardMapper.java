package com.smhrd.board.database;

import java.util.List;

import com.smhrd.ingredient.model.IngredientDTO;

public interface BoardMapper {

    // 품목 추가를 위한 메서드
    int insertIngredient(IngredientDTO ingredient);

	List<IngredientDTO> listIngredient(String mem_id);

	List<IngredientDTO> findId(String mem_name, String mem_email);
    
    // 다른 필요한 메서드들을 추가할 수 있음
}