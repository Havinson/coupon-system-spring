package spring.coupon.system.project.couponsystemspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import spring.coupon.system.project.couponsystemspring.entinies.Company;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;
import spring.coupon.system.project.couponsystemspring.services.AdminService;

@SpringBootApplication
@ServletComponentScan
public class CouponSystemSpringApplication {

	public static void main(String[] args) throws CouponSystemException {
		ConfigurableApplicationContext contex = SpringApplication.run(CouponSystemSpringApplication.class, args);
		AdminService admin = (AdminService) contex.getBean("adminService");
		Company company = new Company();
		company.setEmail("test@testtest.com");
		company.setPassword("12345678907654321");
		admin.createCompany(company);
//		CompanyService companyServ = (CompanyService) contex.getBean("companyService");
//		CustomerService customerServ = (CustomerService) contex.getBean("customerService");
//		IncomeService incomeService = (IncomeService) contex.getBean("incomeService");
//		companyServ.createCoupon(new Coupon());
//		companyServ.removeCoupon(companyServ.getCouponById(1));
	}
}
