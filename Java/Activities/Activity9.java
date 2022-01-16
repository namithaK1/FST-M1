package Activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Namitha");
		myList.add("Divya");
		myList.add("Kavya");
		myList.add("Suman");
		myList.add("Nithin");

		System.out.println("List of names using for each loop");
		for (String names : myList) {

			System.out.println(names);
		}

		System.out.println("List of names using for loop");
		for (int i = 0; i < myList.size(); i++) {

			System.out.println(myList.get(i));
		}

		System.out.println("3rd name = " + myList.get(2));

		System.out.println("Suman is present in the list = " + myList.contains("Suman"));
		System.out.println("Abcd is present in the list = " + myList.contains("Abcd"));

		System.out.println("Total number of names in the list = " + myList.size());

		myList.remove("Namitha");
		System.out.println("Total number of names in the list after removing Namitha = " + myList.size());

	}

}
