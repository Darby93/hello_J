import java.util.ArrayList;

/*
 * 치킨 가게가 있다
 * 10일 간의 판매량을 예측해서 ArrayList에 담으려고 한다
 * 
 * 1. 기본 판매량은 하루 30개이다.
 * 2. 스포츠 경기가 있는 날이 있다. 야구 경기가 있으면 치킨이 20개 더 많이, 농구 경기가 있는 날이면 5개 더 많이 팔린다.
 * 2-1. 스포츠 경기는 10일간 다음과 같이 있다 ["야구", "야구", "야구", "없음", "없음", "없음", "농구", "없음", "야구", "야구"]
 * 2-2. 위의 목록은 sportsList로 이미 구현되어있다
 * 3. 비가 오는 날이 있다. 비가 오면 치킨이 10개 덜 팔린다.
 * 3-1. 비는 다음과 같이 온다 [X X X X O X O X X X] (O가 오는 날, X가 오지 않는 날)
 * 3-2. 위의 목록은 rainList로 이미 구현되어있다
 * 
 * 10일 간의 치킨 판매 예측량을 chickenList에 담아 출력하자
 * (generic은 사용하지 않는다.)
 */

public class ArrayListChicken { 
    public static void main(String[] args) {
    	ArrayList chickenList = new ArrayList();
    	ArrayList sportsList = new ArrayList();
    	ArrayList rainList = new ArrayList();

    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	chickenList.add(30);
    	

    	
    
   

    	
    	sportsList.add("야구");
    	sportsList.add("야구");
    	sportsList.add("야구");
    	sportsList.add("없음");
    	sportsList.add("없음");
    	sportsList.add("없음");
    	sportsList.add("농구");
    	sportsList.add("없음");
    	sportsList.add("야구");
    	sportsList.add("야구");
    	
    	rainList.add(false);
    	rainList.add(false);
    	rainList.add(false);
    	rainList.add(false);
    	rainList.add(true);
    	rainList.add(false);
    	rainList.add(true);
    	rainList.add(false);
    	rainList.add(false);
    	rainList.add(false);
   
    	for(int i = 0; i < sportsList.size(); i++) {
    		int ch = 30;
    		
    		
    		if(((String)sportsList.get(i)).equals("야구") ) {
    			ch += 20;
    		}else if(sportsList.get(i).equals("농구")) {
    			ch += 5;
    		}
    		
    		if((boolean)rainList.get(i)) {
    			ch -= 10;
    		}
    		
    		chickenList.set(i, ch);
    	}
    	
        System.out.println(rainList.get(2));
        System.out.println(chickenList); // [50, 50, 50, 30, 20, 30, 25, 30, 50, 50]
    } 
}