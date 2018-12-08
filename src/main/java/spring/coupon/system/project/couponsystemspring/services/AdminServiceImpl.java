package spring.coupon.system.project.couponsystemspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.entinies.Customer;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;
import spring.coupon.system.project.couponsystemspring.repositories.CompanyRepository;
import spring.coupon.system.project.couponsystemspring.repositories.CouponRepository;
import spring.coupon.system.project.couponsystemspring.repositories.CustomerRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CouponRepository couponRepository;

	@Override
	public void createCompany(Company company) throws CouponSystemException {
		if (companyRepository.existsById(company.getId())) {
			if (company.getName().equals(companyRepository.findById(company.getId()).get().getName()))
				throw new CouponSystemException("The company " + company.toString() + ", already exists!");
		} else {
			companyRepository.save(company);
		}

	}

	@Override
	public void removeCompany(Company company) {
		companyRepository.delete(company);
	}

	@Override
	public void updateCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Company getCompanyById(long id) throws CouponSystemException {
		if (companyRepository.findById(id).isPresent()) {
			return companyRepository.findById(id).get();
		} else {
			throw new CouponSystemException("The company does not exists!");
		}
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public void createCustomer(Customer customer) throws CouponSystemException {
		if (customerRepository.existsById(customer.getId())) {
			throw new CouponSystemException("The customer already exists!");
		} else {
			customerRepository.save(customer);
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) throws CouponSystemException {
		if (customerRepository.existsById(id)) {
			return customerRepository.findById(id).get();
		} else {
			throw new CouponSystemException("The customer does not exists!");
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}// AdminServiceImpl
