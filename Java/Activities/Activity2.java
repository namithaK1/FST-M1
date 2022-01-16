package Activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = new int[] { 10, 77, 10, 54, -11, 10 };

		boolean sum = sumOfNum(ar);
		System.out.println("Result=" + sum);
	}

	public static boolean sumOfNum(int[] ar) {

		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 10) {
				sum += ar[i];
			}
		}
		System.out.println(sum);
		if (sum == 30)
			return true;
		else
			return false;

	}

}
