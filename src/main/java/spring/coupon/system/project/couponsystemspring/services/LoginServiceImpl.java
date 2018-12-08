package spring.coupon.system.project.couponsystemspring.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.coupon.system.project.couponsystemspring.constants.PageNames;
import spring.coupon.system.project.couponsystemspring.entinies.Client;
import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.entinies.Customer;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;
import spring.coupon.system.project.couponsystemspring.repositories.CompanyRepository;
import spring.coupon.system.project.couponsystemspring.repositories.CustomerRepository;

@CrossOrigin
@RestController
@RequestMapping(PageNames.NOSEC_AREA + "/loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(@RequestBody Client client, HttpServletRequest request) throws CouponSystemException {
		ClientType type = client.getType();
		String username = client.getName();
		String password = client.getPassword();
		boolean ret = false;
		switch (type) {
		case ADMIN:
			if (username.equals("admin") && password.equals("12345")) {
				request.getSession(true).setAttribute("client", client);
				System.out.println("admin login succeced");
				ret = true;
			}
			break;
		case CUSTOMER:

			Customer customer = customerRepository.findByName(username);
			if (customer != null && username.equals(customer.getName()) && password.equals(customer.getPassword())) {
				request.getSession(true).setAttribute("client", client);
				request.getSession().setAttribute("entity", customer);
				ret = true;
			}

			break;
		case COMPANY:
			Company company = companyRepository.findByName(username);
			if (company != null && username.equals(company.getName()) && password.equals(company.getPassword())) {
				request.getSession(true).setAttribute("client", client);
				request.getSession().setAttribute("entity", company);
				ret = true;
			}
			break;
		default:
			break;
		}
		return ret;
	}

	@Override
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
