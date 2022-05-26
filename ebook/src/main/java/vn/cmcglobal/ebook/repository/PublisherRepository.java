package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmcglobal.ebook.entity.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
