package samsung.java.week3.train;

public class RailCar {
	private float weight;
	private String ID;
	/** constructor method */
	public RailCar(float initWeight,String initID){
		this.weight = initWeight;
		this.ID = initID;
	}
	/** get Weight */
	public float getWeight() {
		return weight;
	}
	/** set Weight */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/** get ID */
	public String getID() {
		return ID;
	}
	/** set ID */
	public void setID(String iD) {
		ID = iD;
	}
	/** calculate Total Weight */
	public float calculateTotalWeight(int noPassenger, float goodsWeight){
		float totalWeight = weight + noPassenger*0.1f + goodsWeight;
		return totalWeight;
	}
	/** display Informations */
	public void displayInformations(){
		System.out.println("	ID : "+ ID);
		System.out.println("	Weight : "+ weight);
	}
}
