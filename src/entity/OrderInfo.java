package entity;
/**
 * ������Ϣ��
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
    
    //����״̬
	public int getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(int shipStatus) {
		this.shipStatus = shipStatus;
	}
	//����ID
	public int getOrderId() {
		return orderID;
	}
	public void setOrderId(int orderID) {
		this.orderID = orderID;
	}
	//������
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	//�û���
    public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	//��ַID
	public int getAddrID() {
		return addressId;
	}
	public void setAddrID(int addressId) {
		this.addressId = addressId;
	}
	//��������
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	//��ƷID
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	//��ƷͼƬ
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	//��Ʒ��
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	//��Ʒ�۸�
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	//��Ʒ����
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	//�ջ���
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	//����״̬
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
