package kr.or.bit;

// ��ȭ�� ���� �� �ݵ�� ��ȭ, ���� �帣, ����̸�, �����̸�, �����⵵, ��ȭ������ ���� ��.
// �帣, ����̸�, �����̸�, �����⵵, ��ȭ������ ������ �� ����.
// ��ȭ�� �� ������ �ѹ��� ����� �� �ִ� ����� �־�� �Ѵ�.
// ��ȭ ������ ���� ������ ����� �� �ִ�.

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
