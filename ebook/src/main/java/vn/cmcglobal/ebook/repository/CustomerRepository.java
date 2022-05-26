package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmcglobal.ebook.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
