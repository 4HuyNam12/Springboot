package vn.cmcglobal.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.cmcglobal.ebook.entity.Ebook;

import java.util.Optional;

@Repository
public interface EbookRepository extends JpaRepository<Ebook,Long> {
    Optional<Ebook> findByIsbn(String Isbn);
}
