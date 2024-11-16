package com.example.samuraitravel.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.form.ReviewForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.repository.UserRepository;


@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;
	   
     private final HouseRepository houseRepository;  
	 private final UserRepository userRepository;  
	 
	     
	     public  ReviewService(ReviewRepository reviewRepository, HouseRepository houseRepository, UserRepository userRepository) 
	     {
	         this.reviewRepository = reviewRepository;  
	         this.houseRepository = houseRepository;  
	         this.userRepository = userRepository;  
	         
	     }    
	
	
	
//投稿するときの情報の登録	     
	@Transactional
	public void createReview(ReviewForm reviewForm)
	{
		Review review=new Review();
		
		
		review.setUser(userRepository.getReferenceById(reviewForm.getUserId()));
		review.setHouse(houseRepository.getReferenceById(reviewForm.getHouseId()));
		review.setStarNum(reviewForm.getStarNum());
		review.setPostedComment(reviewForm.getPostedComment());
		review.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		reviewRepository.save(review);
	}
	
//編集するときの登録
	@Transactional
	public void updateReview(ReviewForm reviewForm)
	{
		Review review=reviewRepository.getReferenceById(reviewForm.getId());
		
		
		review.setStarNum(reviewForm.getStarNum());
		review.setPostedComment(reviewForm.getPostedComment());
		review.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		reviewRepository.save(review);
	}	
	
}