package samsung.java.week3.train;

public class GoodsCar extends RailCar {
	private float goodsWeight;
	/** constructor method */
	public GoodsCar(float initGoodsWeight, float initWeight,String initID){
		super( initWeight, initID);
		this.goodsWeight = initGoodsWeight;
	}
	/** calculate Total Weight */
	public float calculateTotalWeight(){
		float totalWeight = super.calculateTotalWeight(0,goodsWeight);
		return totalWeight;
	}
	/** display informations */
	public void displayInformations(){
		super.displayInformations();
		System.out.println("	Weight of goods: "+goodsWeight);
		System.out.println("	TotalWeight:"+ calculateTotalWeight());
	}
}
