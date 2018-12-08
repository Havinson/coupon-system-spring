package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.coupon.system.project.couponsystemspring.constants.PageNames;
import spring.coupon.system.project.couponsystemspring.entinies.Coupon;
import spring.coupon.system.project.couponsystemspring.entinies.CouponType;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

@RestController
@RequestMapping(PageNames.SEC_AREA + "/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public void purchaseCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		customerService.purchaseCoupon(coupon);
	}

	@RequestMapping(value = "/getAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getAllCoupons() throws CouponSystemException {
		return customerService.getAllPurchasedCoupons();
	}

	@RequestMapping(value = "/getAllCouponsByType", method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Collection<Coupon> getAllCouponsByType(@RequestBody CouponType type) throws CouponSystemException {
		return customerService.getAllPurchasedCouponsByType(type);
	}

	@RequestMapping(value = "/getAllCouponsByPrice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getAllCouponsByPrice(@RequestBody float price) throws CouponSystemException {
		return customerService.getAllPurchasedCouponsByPrice(price);
	}
}
