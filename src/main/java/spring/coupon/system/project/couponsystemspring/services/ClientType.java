package spring.coupon.system.project.couponsystemspring.services;

public enum ClientType {
	ADMIN("Admin"), CUSTOMER("Customer"), COMPANY("Company");
	private String type;

	private ClientType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
