package Activities;

import java.util.Random;

public class Activity12 {

	public static void main(String[] args) {

		Addable ad1 = (a, b) -> a + b;
		System.out.println("Without body lambda=" + ad1.add(10, 20));

		Addable ad2 = (a, b) -> {
			System.out.println("This is the implementation part with body");
			return a + b;
		};

		System.out.println("With body lambda=" + ad2.add(100, 200));

		Random random = new Random();
		random.setSeed(3343543);
		System.out.println(random.nextInt());

	}

}
