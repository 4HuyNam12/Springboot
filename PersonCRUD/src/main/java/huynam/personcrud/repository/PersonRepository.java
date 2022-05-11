package huynam.personcrud.repository;

import huynam.personcrud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * From person p Where p.name like %:name%", nativeQuery = true)
    List<Person> searchByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE person SET name = ?1, job = ?2, gender = ?3, birth_day = ?4 WHERE id = ?5", nativeQuery = true)
    void updatePerson(@Param("name") String name, String job, boolean gender, String birthday, int id);
}
