package Activities;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer, String> colours = new LinkedHashMap<>();
		colours.put(1, "Violet");
		colours.put(2, "Indigo");
		colours.put(3, "Blue");
		colours.put(4, "Green");
		colours.put(5, "Yellow");
		colours.put(6, "Orange");
		colours.put(7, "Red");

		System.out.println(colours);
		System.out.println("Keys are = " + colours.keySet());
		System.out.println("Values are = " + colours.values());
		System.out.println("____________________________________________");

		System.out.println("Colors are");
		Set color = colours.entrySet();
		Iterator it = color.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		colours.remove(5);

		System.out.println("____________________________________________");
		System.out.println("Green is present in the map = " + colours.containsValue("Green"));

		System.out.println("____________________________________________");
		System.out.println("Total element in the map = " + colours.size());

	}

}
