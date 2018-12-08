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
@RequestMapping(PageNames.SEC_AREA + "/company")
public class CompanyControler {
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/createCoupon", method = RequestMethod.POST)
	public void createCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		companyService.createCoupon(coupon);
	}

	@RequestMapping(value = "/removeCoupon", method = RequestMethod.POST)
	public void removeCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		companyService.removeCoupon(coupon);
	}

	@RequestMapping(value = "/updateCoupon", method = RequestMethod.POST)
	public void updateCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		companyService.updateCoupon(coupon);
	}

	@RequestMapping(value = "/getCoupon", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Coupon getCoupon(@RequestBody long id) throws CouponSystemException {
		return companyService.getCouponById(id);
	}

	@RequestMapping(value = "/getAllCoupons", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getAllCoupons() throws CouponSystemException {
		return companyService.getAllCoupons();
	}

	@RequestMapping(value = "/getAllCouponsByType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getAllCouponsByType(@RequestBody CouponType type) throws CouponSystemException {
		return companyService.getCouponsByType(type);
	}
}
