package com.myshoes.ecommerce.dao;

import java.util.List;

import com.myshoes.ecommerce.dao.interfaces.FavoriteDao;
import com.myshoes.ecommerce.model.Favorite;

public class FavoriteDaoImpl extends AbstractSession implements FavoriteDao {

	@Override
	public void saveFavorite(Favorite favorite) {
		getSession().persist(favorite);
	}

	@Override
	public void deleteFavorite(Long idFavorite) {
		Favorite favorite = this.findFavoriteById(idFavorite);
		
		if (favorite != null) {
			getSession().delete(favorite);
		}
	}

	@Override
	public void UpdateFavorite(Favorite favorite) {
		getSession().update(favorite);
	}

	@Override
	public List<Favorite> findAllFavorites() {
		return getSession().createQuery("from Favorite").list();
	}

	@Override
	public Favorite findFavoriteById(Long idFavorite) {
		return (Favorite) getSession().get(Favorite.class, idFavorite);
	}

}
