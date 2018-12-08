package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import spring.coupon.system.project.couponsystemspring.entinies.Coupon;
import spring.coupon.system.project.couponsystemspring.entinies.CouponType;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

public interface CustomerService {
	void purchaseCoupon(Coupon coupon) throws CouponSystemException;

	Collection<Coupon> getAllPurchasedCoupons() throws CouponSystemException;

	Collection<Coupon> getAllPurchasedCouponsByPrice(float price);

	Collection<Coupon> getAllPurchasedCouponsByType(CouponType type);

}
