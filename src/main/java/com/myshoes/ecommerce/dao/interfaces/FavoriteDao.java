package com.myshoes.ecommerce.dao.interfaces;

import java.util.List;

import com.myshoes.ecommerce.model.Favorite;

public interface FavoriteDao {
	void saveFavorite(Favorite favorite);
	
	void deleteFavorite(Long idFavorite);
	
	void UpdateFavorite(Favorite favorite);
	
	List<Favorite> findAllFavorites();
	
	Favorite findFavoriteById(Long idFavorite);
}
