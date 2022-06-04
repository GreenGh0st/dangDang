package entity;

public class MyAddress {
	private int user_id;
	private int address_id;
	private String name;
	private String address;
	private String postalcode;
	private String phone;
	private String email;
	private String addralias;
	private int status;
	
	//��ַid
	public int getAddressId() {
		return address_id;
	}
	public void setAddressId(int address_id) {
		this.address_id = address_id;
	}
	//�û�id
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	//�û���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//�ʱ�
	public String getZipCode() {
		return postalcode;
	}
	public void setZipCode(String postalcode) {
		this.postalcode = postalcode;
	}
	//�ֻ���
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//����
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//��ַ���
	public String getAddralias() {
		return addralias;
	}
	public void setAddralias(String addralias) {
		this.addralias = addralias;
	}
	//��ϸ��ַ
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

    public void setStatus(int status) {
		this.status = status;
	}
}
