package spring.coupon.system.project.couponsystemspring.services;

import java.util.List;

import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.entinies.Customer;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

public interface AdminService {
	void createCompany(Company company) throws CouponSystemException;

	void removeCompany(Company company);

	void updateCompany(Company company);

	Company getCompanyById(long id) throws CouponSystemException;

	List<Company> getAllCompanies();

	void createCustomer(Customer customer) throws CouponSystemException;

	void removeCustomer(Customer customer);

	void updateCustomer(Customer customer);

	Customer getCustomerById(Long id) throws CouponSystemException;

	List<Customer> getAllCustomers();

}
