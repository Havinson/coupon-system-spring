package spring.coupon.system.project.couponsystemspring.entinies;

public enum IncomeType {

	CUSTOMER_PURCHASE("Customer purchase"), COMPANY_NEW_COUPON("Company new coupon"),
	COMPANY_UPDATE_COUPON("Company update coupon");

	private String description;

	private IncomeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}
