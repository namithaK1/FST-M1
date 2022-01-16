package Activities;

import java.util.HashSet;
import java.util.Iterator;

public class Activity10 {

	public static void main(String[] args) {

		HashSet hs = new HashSet();
		hs.add("Namitha");
		hs.add(909999);
		hs.add('A');
		hs.add(null);
		hs.add(789.243);
		hs.add("Mangalore");
		hs.add(null); // Does not allow more than 1 null

		System.out.println("Total objects in hashset = " + hs.size());

		hs.remove(789.243);

		hs.remove("test");
		System.out.println("____________________________________________");
		System.out.println("Namitha is present in the hashset = " + hs.contains("Namitha"));
		System.out.println("Abcd is present in the hashset = " + hs.contains("Abcd"));

		System.out.println("____________________________________________");
		System.out.println("Entire hashset");
		System.out.println(hs);
		System.out.println("____________________________________________");
		Iterator it = hs.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());
		}

	}

}
