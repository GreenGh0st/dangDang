package entity;

/**
 * ���ﳵʵ����
 * 
 * @author Administrator
 * 
 */
public class FoodInfoCar{
	
	private int foodID;
	private String foodImage;
	private String description;
	private double foodPrice;
	private int foodNumber;
	private int foodCount;


    public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

    public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

    public void setFoodDesc(String description) {
		this.description = description;
	}

    public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	/**
	 * ��������
	 * 
	 * @return
	 */
	public int getFoodNumber() {
		return foodNumber;
	}

	public void setFoodNumber(int foodNumber) {
		this.foodNumber = foodNumber;
	}

    public void setCount(int foodCount) {
		this.foodCount = foodCount;
	}

}
