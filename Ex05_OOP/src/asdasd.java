class Movie {
    
    int movieNum;
    String movieName;
    Member[] me;
    
    public Movie() {
        this(new Member[] {new Member(1,"ȫ�浿")}); //this�� ������ ȣ��� �� ���� ��õǾ�� �Ѵ�
        System.out.println(this.movieNum + "/" +this.movieName);
        this.movieNum = 1;
        this.movieName = "������";
        System.out.println(me);
        System.out.println(this.movieNum + "/" +this.movieName);
    }
    public Movie(Member[] me) {
        this.me = me;
        System.out.println(this.movieNum + "/" +this.movieName);
      
    }
}
class Member {
    int memberNum;
    String memberName;
    
    
    Member(int memberNum, String memberName){
        this.memberNum = memberNum;
        this.memberName = memberName;
        System.out.println(this.memberNum + "/" + this.memberName);
    }
}
public class asdasd {
    public static void main(String[] args) {
        
        Movie m = new Movie();
        System.out.println(m.me);
    }
}