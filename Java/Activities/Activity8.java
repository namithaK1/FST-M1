package Activities;

public class Activity8 {

	public static void main(String[] args) {

		try {

			exceptionTest("Java is the best");
			exceptionTest("");
		} catch (CustomException e) {

			System.out.println(e.getMessage());
		}

	}

	public static void exceptionTest(String message) throws CustomException {

		if (message.isEmpty())
			throw new CustomException("No message passed");

		else
			System.out.println("Message is = " + message);
	}
}
