package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    @Query("SELECT e FROM Institution e")
    List<Institution> findAll();

    Optional<Institution> findById(Long organization);
}
