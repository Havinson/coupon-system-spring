package spring.coupon.system.project.couponsystemspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.coupon.system.project.couponsystemspring.entinies.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
