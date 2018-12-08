package spring.coupon.system.project.couponsystemspring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.coupon.system.project.couponsystemspring.entinies.Coupon;
import spring.coupon.system.project.couponsystemspring.entinies.CouponType;
import spring.coupon.system.project.couponsystemspring.entinies.Customer;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;
import spring.coupon.system.project.couponsystemspring.repositories.CouponRepository;
import spring.coupon.system.project.couponsystemspring.repositories.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CouponRepository couponRepository;
	@Autowired
	CustomerRepository customerRepository;
	Customer customer;

	@Override
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		if (customer.getCoupons().contains(coupon)) {
			throw new CouponSystemException("The coupon already purchased!");
		} else {
			couponRepository.findById(coupon.getId()).get().setAmount(coupon.getAmount() - 1);
			customer.getCoupons().add(coupon);
		}
	}

	@Override
	public Collection<Coupon> getAllPurchasedCoupons() throws CouponSystemException {
		if (customer.getCoupons().isEmpty()) {
			throw new CouponSystemException("You don`t have any coupon!");
		} else {
			return customer.getCoupons();
		}
	}

	@Override
	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType type) {
		List<Coupon> couponsByType = new ArrayList<>();
		for (Coupon curr : customer.getCoupons()) {
			if (curr.getType().equals(type)) {
				couponsByType.add(curr);
			}
		}
		return couponsByType;
	}

	@Override
	public Collection<Coupon> getAllPurchasedCouponsByPrice(float price) {

		List<Coupon> couponsByPrice = new ArrayList<>();
		for (Coupon curr : customer.getCoupons()) {
			if (curr.getPrice() == price) {
				couponsByPrice.add(curr);
			}
		}
		return couponsByPrice;
	}

}
