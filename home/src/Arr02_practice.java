
public class Arr02_practice {

	public static void main(String[] args) {
		int number = 0;
		
		String[] names = {"Elena","Suzie","John","Emily","Neda"
				,"Kate","Alex","Daniel","Hamilton"};
		
		int[] scores = {65,74,23,75,68,96,88,98,54};
		
		for(int i = 0; i < scores.length; i++) {
			if (scores[number] < scores[i]) {
				number = i;
			}
		}
		
        System.out.println("1µî : " + names[number] + "(" + scores[number] + ")"); 
	}

}
