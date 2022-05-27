package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmcglobal.ebook.entity.Ebook;

@Repository
public interface StatisticalRepository extends JpaRepository<Ebook,Long> {
}
