package spring.coupon.system.project.couponsystemspring.exception;

public class CouponSystemException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CouponSystemException(String message) {
		super(message);

	}

	public CouponSystemException() {
		super();
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

}
