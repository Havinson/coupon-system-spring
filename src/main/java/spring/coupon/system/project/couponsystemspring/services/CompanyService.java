package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import spring.coupon.system.project.couponsystemspring.entinies.Coupon;
import spring.coupon.system.project.couponsystemspring.entinies.CouponType;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

public interface CompanyService {
	void createCoupon(Coupon coupon) throws CouponSystemException;

	void removeCoupon(Coupon coupon);

	void updateCoupon(Coupon coupon);

	Coupon getCouponById(long id) throws CouponSystemException;

	Collection<Coupon> getAllCoupons();

	Collection<Coupon> getCouponsByType(CouponType type);

}
