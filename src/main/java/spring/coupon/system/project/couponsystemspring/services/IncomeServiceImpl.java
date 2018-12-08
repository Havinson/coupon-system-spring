package spring.coupon.system.project.couponsystemspring.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.coupon.system.project.couponsystemspring.entinies.Income;
import spring.coupon.system.project.couponsystemspring.repositories.IncomeRepository;

@Service("incomeService")
public class IncomeServiceImpl implements IncomeService {
	@Autowired
	private IncomeRepository repository;

	@Override
	public void storeIncome(Income income) {
		repository.save(income);
	}

	@Override
	public Collection<Income> viewAllIncome() {
		return repository.findAll();
	}

	@Override
	public Collection<Income> viewIncomeByCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Income> viewIncomeByCompany(long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
