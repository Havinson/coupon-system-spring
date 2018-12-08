package spring.coupon.system.project.couponsystemspring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.entinies.Coupon;
import spring.coupon.system.project.couponsystemspring.entinies.CouponType;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;
import spring.coupon.system.project.couponsystemspring.repositories.CompanyRepository;
import spring.coupon.system.project.couponsystemspring.repositories.CouponRepository;

@Service("companyService")

public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CouponRepository couponRepository;
	Company company;

	@Override
	public void createCoupon(Coupon coupon) throws CouponSystemException {
		if (couponRepository.existsById(coupon.getId())) {
			throw new CouponSystemException("The coupon already exists!");
		} else {
			coupon.setCompany(company);
			couponRepository.save(coupon);
		}
	}

	@Override
	public void removeCoupon(Coupon coupon) {
		couponRepository.delete(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponRepository.save(coupon);
	}

	@Override
	public Coupon getCouponById(long id) throws CouponSystemException {
		if (couponRepository.existsById(id)) {
			return couponRepository.findById(id).get();
		} else {
			throw new CouponSystemException("The coupon is not exists!");
		}
	}

	@Override
	public Collection<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}

	@Override
	public Collection<Coupon> getCouponsByType(CouponType type) {
		List<Coupon> couponsByType = new ArrayList<>();
		for (Coupon curr : company.getCoupons()) {
			if (curr.getType().equals(type)) {
				couponsByType.add(curr);
			}
		}
		return couponsByType;
	}

}
