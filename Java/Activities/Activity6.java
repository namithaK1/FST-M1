package Activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Plane plane = new Plane(10);

		plane.onboard("Namitha");
		plane.onboard("Nithin");
		plane.onboard("Shridhar");
		plane.onboard("Susheela");
		plane.onboard("Suman");

		System.out.println("Take off time is " + plane.takeOff());

		System.out.println("People on plane " + plane.getPassesngers());

		Thread.sleep(5000);

		plane.land();

		System.out.println("Landing time is " + plane.getLastTimeLanded());

		System.out.println("People on plane after landing" + plane.getPassesngers());

	}

}
