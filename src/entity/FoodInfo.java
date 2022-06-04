package entity;
/**
 * 商品实体类
 * 
 * @author Administrator
 * 
 */
public class FoodInfo{

	private int foodID;
	private String foodName;
	private String remark;
	private String foodAddr;
	private double foodPrice;
	private String description;
	private String foodImage;
	private int foodCount;
	private int sortID;
	private String name;
	private String jj;
	private String type;
	private int price;
	private int sy;

	public int getSy(){return sy;}
	public void setSy(int sy){this.sy=sy;}
	public String getName(){
		return name;
	}
	public void setName(String name){this.name=name;}
	public String getJj(){
		return jj;
	}
	public void setJj(String jj){this.jj=jj;}
	public String getType(){
		return type;
	}
	public void setType(String type){this.type=type;}
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){this.price=price;}

	/**
	 *商品ID
	 * 
	 * @return
	 */
	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	/**
	 * 商品名称
	 * 
	 * @return
	 */
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	/**
	 * 商品简介
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 商品产地
	 * 
	 * @return
	 */
	public String getFoodAddr() {
		return foodAddr;
	}

	public void setFoodAddr(String foodAddr) {
		this.foodAddr = foodAddr;
	}
	/**
	 * 商品价钱
	 * 
	 * @return
	 */
	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	/**
	 * 商品介绍
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 商品图片
	 * 
	 * @return
	 */
	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	/**
	 * 商品库存
	 * 
	 * @return
	 */
	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	/**
	 * 商品种类
	 * 
	 * @return
	 */
	public int getSortID() {
		return sortID;
	}
	
	public void setSortID(int sortID) {
		this.sortID = sortID;
	}
}
