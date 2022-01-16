package Activities;

public class Activity7_Bicycle implements BicycleParts, BicycleOperations {

	int gear, currentSpeed;

	public Activity7_Bicycle(int gear, int currentSpeed) {

		this.gear = gear;
		this.currentSpeed = currentSpeed;
	}

	public void applyBrake(int decrement) {

		currentSpeed -= decrement;
		System.out.println("Speed decreased to = " + currentSpeed);
	}

	public void speedUp(int increment) {

		currentSpeed += increment;
		System.out.println("Speed increased to = " + currentSpeed);
	}

	public void bicycleDesc() {
		System.out.println("Gear = " + gear);
		System.out.println("Current speed = " + currentSpeed);
	}
}
