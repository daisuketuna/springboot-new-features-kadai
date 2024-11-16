package com.example.samuraitravel.form;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewForm {
	private Integer id;
	private Integer userId;
	private Integer houseId;
	
	private Integer starNum;
	
	@NotBlank
	private String postedComment;
	

}