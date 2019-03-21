import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practic_problem02 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$"); 

		Matcher m = p.matcher("snopy8674"); 

		boolean b = m.matches();
		
		System.out.println(b);
		

	}

}
