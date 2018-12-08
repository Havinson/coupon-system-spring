package spring.coupon.system.project.couponsystemspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.coupon.system.project.couponsystemspring.entinies.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByName(String username);

}
