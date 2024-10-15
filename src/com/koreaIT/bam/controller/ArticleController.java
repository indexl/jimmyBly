package com.koreaIT.bam.controller;

import java.util.Scanner;

import com.koreaIT.bam.service.ArticleService;

public class ArticleController {
	 
	
	private ArticleService articleService;
	
	public ArticleController(Scanner sc) {
	
		
		
		
		articleService = new ArticleService();
		
	}
}
		
	
	