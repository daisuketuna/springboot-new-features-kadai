package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Favorite;
import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.repository.FavoriteRepository;

@Service
public class FavoriteService {

	private final FavoriteRepository favoriteRepository;
	
	public FavoriteService(FavoriteRepository favoriteRepository) {
	this.favoriteRepository=favoriteRepository;
	}
	
	
	//お気に入りレコードの作成
	
	public void createFavorite(Integer userId,House house)
	{
		Favorite favorite=new Favorite();
		favorite.setUserId(userId);
		favorite.setHouse(house);
		
		favoriteRepository.save(favorite);
		
	}
	
}