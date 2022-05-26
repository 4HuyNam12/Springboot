package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmcglobal.ebook.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
