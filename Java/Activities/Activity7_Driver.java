package Activities;

public class Activity7_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity7_MountainBike mountain = new Activity7_MountainBike(4, 6, 3);

		System.out.println("-------Incresing speeding-------");
		mountain.speedUp(12);

		mountain.bicycleDesc();

		System.out.println("-------Applying brake-------");
		mountain.applyBrake(2);

		mountain.bicycleDesc();

		System.out.println("-------Changing seat height-------");
		mountain.seatHeight(6);

		mountain.bicycleDesc();
	}

}
