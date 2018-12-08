package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import spring.coupon.system.project.couponsystemspring.entinies.Income;

@Service
public interface IncomeService {
	void storeIncome(Income income);

	Collection<Income> viewAllIncome();

	Collection<Income> viewIncomeByCustomer(long customerId);

	Collection<Income> viewIncomeByCompany(long companyId);

}
