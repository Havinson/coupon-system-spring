package spring.coupon.system.project.couponsystemspring.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spring.coupon.system.project.couponsystemspring.entinies.Client;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

public interface LoginService {

	void logout(HttpSession session);

	boolean login(Client client, HttpServletRequest request) throws CouponSystemException;
}
