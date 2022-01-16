package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13_RandomScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random indexGen = new Random();

		System.out.println("Enter list of number");

		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}

		System.out.println(list);

		int randomNumber = indexGen.nextInt(list.size());
		System.out.println("Random number = " + randomNumber);
		System.out.println("Value = " + list.get(randomNumber));

		// OR
		Integer[] listCovertedToArray = list.toArray(new Integer[0]);
		randomNumber = indexGen.nextInt(listCovertedToArray.length);
		System.out.println("Random number = " + randomNumber);
		System.out.println("Value = " + listCovertedToArray[randomNumber]);
	}

}
