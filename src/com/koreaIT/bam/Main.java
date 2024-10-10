package com.koreaIT.bam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<>();
		
		while(true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}
			
			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				lastArticleId++;
				
				Article article = new Article(lastArticleId, title, body);
				
				articles.add(article);
				
				System.out.printf("%d번 게시물이 생성되었습니다\n", lastArticleId);
				
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");
					continue;
				}
				
				System.out.println("번호	|	제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s\n", article.id, article.title);
				}
			
			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (Exception e) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				
			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
				
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (Exception e) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine();
				
				foundArticle.title = title;
				foundArticle.body = body;
				
				System.out.printf("%d번 게시물이 수정되었습니다\n", id);
				
			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (Exception e) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				articles.remove(foundArticle);
				
				System.out.printf("%d번 게시물이 삭제되었습니다\n", id);
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {
	int id;
	String title;
	String body;
	

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}

//생성자는 public  만들어 줘야한다