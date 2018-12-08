package spring.coupon.system.project.couponsystemspring.entinies;

import spring.coupon.system.project.couponsystemspring.services.ClientType;

public class Client {
	private String name;
	private String password;
	private ClientType type;

	public Client() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}
}
