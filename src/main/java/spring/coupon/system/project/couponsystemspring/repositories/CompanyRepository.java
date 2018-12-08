package spring.coupon.system.project.couponsystemspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.coupon.system.project.couponsystemspring.entinies.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
//	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END FROM Company c WHERE c.companyName = :name")
//	boolean existsByCompanyName(@Param("name") String name);

	Company findByName(String username);

}
