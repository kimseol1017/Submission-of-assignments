package com.my.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieMenu {
	
	public MovieMenu() {}
	
	void movieMenu() {
		Scanner se = new Scanner(System.in);
		MovieMgr mm = new MovieMgr();
		
		int sel;
			
		out:do {
				System.out.println("================");
				System.out.println("1. 영화 정보 입력");
				System.out.println("2. 영화 정보 전체 검색");
				System.out.println("3. 영화명 검색");
				System.out.println("4. 영화 감독별 검색");
				System.out.println("5. 영화 장르별 검색");
				System.out.println("6. 영화 정보 삭제");
				System.out.println("7. 프로그램 종료");
				System.out.println("================");
				System.out.println("메뉴를 정수값으로 선택해주세요>>>");
				
				sel = se.nextInt();
				se.nextLine();
				
				switch (sel) {
				case 1:
					System.out.println("1. 영화 정보 입력");
					Movie mv = new Movie();
					System.out.println("영화 제목을 입력해주세요");
					mv.setTitle(se.next());
					System.out.println("영화 감독을 입력해주세요");
					mv.setDirector(se.next());
					System.out.println("영화 등급을 입력해주세요");
					mv.setGrade(se.nextInt());
					System.out.println("영화 장르을 입력해주세요");
					mv.setGenre(se.next());
					
					mm.add(mv);
					break;

				case 2:
					System.out.println("2. 영화 정보 전체 검색");
					mm.search();
					break;
					
				case 3:
					System.out.println("3. 영화명 검색");
					
					mm.searchTitle(se.next());
					
					break;
					
				case 4:
					System.out.println("4. 영화 감독별 검색");

					mm.searchDirector(se.next());
					break;
					
				case 5:
					System.out.println("5. 영화 장르별 검색");
					List<Movie> li = new ArrayList<>();
					String ge = se.next();
					li = mm.searchGenre(ge);
					
					if (li.size() > 0) {
						int idx = 1;
						System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
						System.out.println("======================================================");
						for (Movie k : li) {
							if (k.getGenre().equals(ge) || k.getGenre().contains(ge)) {
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
					
					break;
					
				case 6:
					System.out.println("6. 영화 정보 삭제");
					mm.delete(se.nextLine());
					break;
					
				case 7:

					break out;
				}
				
			}while(true);
			System.out.println("프로그램 종료");
			se.close();
	}
	
		
		} 

 
		
	

