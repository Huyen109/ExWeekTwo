package samsung.java.week3.train;

public class PassengerCarriage extends RailCar {
	private int noPassenger;
	/** constructor method */
	public PassengerCarriage(int initNoPasser, float initWeight,String initID){
		super( initWeight, initID);
		this.noPassenger = initNoPasser;
	}
	/** calculate Total Weight */
	public float calculateTotalWeight(){
		float totalWeight = super.calculateTotalWeight(noPassenger, 0);
		return totalWeight;
	}
	/** passenger get off the train */
	public void passengerGetOff(int noPassengerGetOff){
		noPassenger -= noPassengerGetOff;
		super.calculateTotalWeight(noPassenger, 0);
		System.out.println("successful!");
	}
	/** passenger take the train */
	public void passengerTake(int noPassengerTake){
		noPassenger += noPassengerTake;
		super.calculateTotalWeight(noPassenger, 0);
		System.out.println("successful!");
	}
	/** display informations */
	public void displayInformations(){
		super.displayInformations();
		System.out.println("	Number of passenger: "+noPassenger);
		System.out.println("	TotalWeight: "+calculateTotalWeight());
	}
}
