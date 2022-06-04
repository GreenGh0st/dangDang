package entity;
/**
 * 订单信息类
 * @author Administrator
 *
 */
public class OrderInfo {
      private int orderID;
      private String orderNumber;
      private int userID;
      private int shipStatus;
      private String orderDate;
      private int addressId;
      private int foodID;
      private String foodImage;
      private String foodName;
      private Double foodPrice;
      private int foodCount;
      private String consignee;
      private String orderStatus;
      private int comment;
    
    //发货状态
	public int getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(int shipStatus) {
		this.shipStatus = shipStatus;
	}
	//订单ID
	public int getOrderId() {
		return orderID;
	}
	public void setOrderId(int orderID) {
		this.orderID = orderID;
	}
	//订单号
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	//用户名
    public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	//地址ID
	public int getAddrID() {
		return addressId;
	}
	public void setAddrID(int addressId) {
		this.addressId = addressId;
	}
	//订单日期
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	//商品ID
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	//商品图片
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	//商品名
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	//商品价格
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	//商品数量
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	//收货人
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	//订单状态
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

    public void setComment(int comment) {
		this.comment = comment;
	}
}
