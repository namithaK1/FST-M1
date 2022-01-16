package Activities;

public class Activity7_MountainBike extends Activity7_Bicycle {
	int seatHeight;

	public Activity7_MountainBike(int gear, int currentSpeed, int seatHeight) {

		super(gear, currentSpeed);
		this.seatHeight = seatHeight;
	}

	public void seatHeight(int seatHeight) {

		this.seatHeight = seatHeight;
		System.out.println("Seat height = " + seatHeight);
	}

	public void bicycleDesc() {
		System.out.println("Gear = " + gear);
		System.out.println("Current speed = " + currentSpeed);
		System.out.println("Seat height = " + seatHeight);
	}
}
