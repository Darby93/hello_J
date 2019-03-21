import java.util.HashMap;
import java.util.Set;


public class Ex15_HashMap_Quiz_Object {
	public static void main(String[] args) {
		HashMap<String, String> quiz = new HashMap<>();
        quiz.put("1+1", "2");
        quiz.put("1+2", "3");
        quiz.put("1+3", "4");
        
        for(int i = 0 ; i < quiz.size() ; i++) {
            Set set =quiz.keySet();
            Object[] obj= set.toArray(); //배열로 바까줌
            System.out.println(obj[i]);
            //System.out.println(quiz.keySet().toArray()[i]);
            
            System.out.println(quiz.get(quiz.keySet().toArray()[i]));
        }

	}

}