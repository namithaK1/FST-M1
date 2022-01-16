package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {

	private int maxPassenger;
	private Date lastTimeTakeOff;
	private Date lastTimeLanded;
	private List<String> passengers;

	public Plane(int maxPassengers) {

		this.maxPassenger = maxPassengers;
		this.passengers = new ArrayList<String>();
	}

	public void onboard(String passenger) {

		passengers.add(passenger);
	}

	public Date takeOff() {

		lastTimeTakeOff = new Date();
		return lastTimeTakeOff;
	}

	public void land() {

		lastTimeLanded = new Date();
		passengers.clear();
	}

	public Date getLastTimeLanded() {

		return lastTimeLanded;
	}

	public List<String> getPassesngers() {

		return passengers;
	}

}
