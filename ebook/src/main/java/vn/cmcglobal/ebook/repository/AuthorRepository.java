package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmcglobal.ebook.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
