package entity;

public class CommentInfo {
	private int com_id;
	private int foodID;
	private int orderID;
	private String userName;
	private String com_context;
	private String com_data;
	private String foodQuality;
	private String com_delivery;
	private String com_serve;
	private String admin_name;
    private String admin_Reply;
    
    //评论ID
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	//商品ID
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	//订单ID
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	//用户名
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//评价内容
	public String getCom_context() {
		return com_context;
	}
	public void setCom_context(String com_context) {
		this.com_context = com_context;
	}
	//评价日期
	public String getCom_data() {
		return com_data;
	}
	public void setCom_data(String com_data) {
		this.com_data = com_data;
	}
	//商品质量
	public String getFoodQuality() {
		return foodQuality;
	}
	public void setFoodQuality(String foodQuality) {
		this.foodQuality = foodQuality;
	}
	//配送服务
	public String getCom_delivery() {
		return com_delivery;
	}
	public void setCom_delivery(String com_delivery) {
		this.com_delivery = com_delivery;
	}
	//服务质量
	public String getCom_serve() {
		return com_serve;
	}
	public void setCom_serve(String com_serve) {
		this.com_serve = com_serve;
	}
	//管理员姓名
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	//管理员回复内容
	public String getAdmin_Reply() {
		return admin_Reply;
	}
	public void setAdmin_Reply(String admin_Reply) {
		this.admin_Reply = admin_Reply;
	}
    
}
