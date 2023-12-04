package com.my.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieMgr {
		int index = 0;		// 방번호를 출력하는 변수
		List<Movie> movies = new ArrayList<Movie>(); // ArrayList() 객체
		Scanner im = new Scanner(System.in);
		
		MovieMgr(){} // 기본 생성자
		
		public void add(Movie m) {
			movies.add(m);
		}
		
		public void search() {
			if(movies.size() > 0) {
				int idx = 1;
				System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
				System.out.println("======================================================");
				for (Movie k : movies) {
					System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, k.getTitle(), k.getDirector(), k.getGrade(), k.getGenre());
				}
				System.out.println();
			} else {
				System.out.println("등록된 영화정보가 없습니다.");
			}
		}
		
		
		public void searchTitle(String title) {
			if (movies.size() > 0) {
				int idx = 1;
				System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
				System.out.println("======================================================");
				for (Movie k : movies) {
					if (k.getTitle().equals(title) || k.getTitle().contains(title)) {
						System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, k.getTitle(), k.getDirector(), k.getGrade(), k.getGenre());
					}
				}
				if (idx == 1) {
					System.out.println("등록된 영화정보가 없습니다.");
				}
				System.out.println();
			} else {
				System.out.println("등록된 영화정보가 없습니다.");
			}
			
		}
		public void searchDirector(String director) {
			if (movies.size() > 0) {
				int idx = 1;
				System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
				System.out.println("======================================================");
				for (Movie k : movies) {
					if (k.getDirector().equals(director) || k.getDirector().contains(director)) {
						System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, k.getTitle(), k.getDirector(), k.getGrade(), k.getGenre());
					}
				}
				if (idx == 1) {
					System.out.println("등록된 영화정보가 없습니다.");
				}
				System.out.println();
			} else {
				System.out.println("등록된 영화정보가 없습니다.");
			}
		}
		
		List<Movie> searchGenre(String genre) {
			List<Movie> li = new ArrayList<>();

			if (movies.size() > 0) {
				for (Movie k : movies) {
					if (k.getGenre().equals(genre) || k.getGenre().contains(genre)) {
						li.add(k);
					}
				}
			}

			return li;
		}
		
		public void delete(String title) {
			boolean is_del = false;
			List<Movie> removed = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			if (movies.size() > 0) {
				for (Movie k : movies) {
					if (k.getTitle().equals(title)) {
						removed.add(k);
						msg.add(k.getTitle());
						is_del = true;
					}
				}
				if (is_del == false) {
					System.out.println("해당 제목의 영화는 등록되지 않았습니다.");
				} else {
					movies.removeAll(removed);
					System.out.println(msg + " 가 삭제되었습니다.");
				}

			} else {
				System.out.println("아직 등록된 영화가 없습니다.");
			}
		}
		
}
