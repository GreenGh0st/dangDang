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
    
    //����ID
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	//��ƷID
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	//����ID
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	//�û���
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//��������
	public String getCom_context() {
		return com_context;
	}
	public void setCom_context(String com_context) {
		this.com_context = com_context;
	}
	//��������
	public String getCom_data() {
		return com_data;
	}
	public void setCom_data(String com_data) {
		this.com_data = com_data;
	}
	//��Ʒ����
	public String getFoodQuality() {
		return foodQuality;
	}
	public void setFoodQuality(String foodQuality) {
		this.foodQuality = foodQuality;
	}
	//���ͷ���
	public String getCom_delivery() {
		return com_delivery;
	}
	public void setCom_delivery(String com_delivery) {
		this.com_delivery = com_delivery;
	}
	//��������
	public String getCom_serve() {
		return com_serve;
	}
	public void setCom_serve(String com_serve) {
		this.com_serve = com_serve;
	}
	//����Ա����
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	//����Ա�ظ�����
	public String getAdmin_Reply() {
		return admin_Reply;
	}
	public void setAdmin_Reply(String admin_Reply) {
		this.admin_Reply = admin_Reply;
	}
    
}
