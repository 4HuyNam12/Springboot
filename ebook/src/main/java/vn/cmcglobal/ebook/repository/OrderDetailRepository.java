package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.cmcglobal.ebook.entity.OrderDetails;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
}
