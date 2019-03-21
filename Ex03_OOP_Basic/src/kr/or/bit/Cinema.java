package kr.or.bit;

// 영화를 찍을 때 반드시 영화, 제목 장르, 배우이름, 감독이름, 개봉년도, 영화제목이 들어가야 함.
// 장르, 배우이름, 감독이름, 개봉년도, 영화제목은 수정할 수 없다.
// 영화에 들어간 정보를 한번에 출력할 수 있는 기능이 있어야 한다.
// 영화 정보는 각각 정보를 출력할 수 있다.

public class Cinema {
	private String actorname;
	private String moviename;
	private String director;
	private int date;
	private String genre;

	public Cinema(String actorname, String moviename, String director, int date, String genre) {
		this.actorname = actorname;
		this.moviename = moviename;
		this.director = director;
		this.date = date;
		this.genre = genre;

	}

	public void Print() {
		System.out.println(actorname);
		System.out.println(moviename);
		System.out.println(director);
		System.out.println(date);
		System.out.println(genre);
	}

	public void getActorname() {
		System.out.println(actorname);
	}

	public void getMoviename() {
		System.out.println(moviename);
	}

	public void getDirector() {
		System.out.println(director);
	}

	public void getDate() {
		System.out.println(date);
	}

	public void getGenre() {
		System.out.println(genre);
	}

}
