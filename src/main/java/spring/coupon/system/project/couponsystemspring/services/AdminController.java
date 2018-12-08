package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.coupon.system.project.couponsystemspring.constants.PageNames;
import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.entinies.Customer;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

@RestController
@RequestMapping(PageNames.SEC_AREA + "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/createCompany", method = RequestMethod.POST)
	public void createCompany(@RequestBody Company company) throws CouponSystemException {
		adminService.createCompany(company);
	}

	@RequestMapping(value = "/removeCompany", method = RequestMethod.POST)
	public void removeCompany(@RequestBody Company company) throws CouponSystemException {
		adminService.removeCompany(company);
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public void updateCompany(@RequestBody Company company) throws CouponSystemException {
		adminService.updateCompany(company);
	}

	@RequestMapping(value = "/getCompany", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Company getCompany(@RequestBody long id) throws CouponSystemException {
		return adminService.getCompanyById(id);
	}

	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Company> getAllCompanies() throws CouponSystemException {
		return adminService.getAllCompanies();
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer) throws CouponSystemException {
		adminService.createCustomer(customer);
	}

	@RequestMapping(value = "/removeCustomer", method = RequestMethod.POST)
	public void removeCustomer(@RequestBody Customer customer) throws CouponSystemException {
		adminService.removeCustomer(customer);
	}

	@RequestMapping(value = "/getCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@RequestBody long id) throws CouponSystemException {
		return adminService.getCustomerById(id);
	}

	@RequestMapping(value = "/getAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Customer> getAllCustomers() throws CouponSystemException {
		return adminService.getAllCustomers();
	}

}
