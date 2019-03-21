
public class Arr03_practice {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int[][] re = new int[5][5];
	    int num = 1;
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				
				arr[i][j] += num++;
				re[i][j] = arr[i][j];
				
				re[i][re[1].length-1] += re[i][j];
				re[re.length-1][j] += re[i][j];
				
				
				
			}
			System.out.println(re[i][re[1].length - 1]);
	
		}
		
		System.out.println(re.length);
		
		
		for (int i = 0; i < re.length; i++) {
			for (int j = 0; j < re[0].length; j++) {

				System.out.print(re[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
