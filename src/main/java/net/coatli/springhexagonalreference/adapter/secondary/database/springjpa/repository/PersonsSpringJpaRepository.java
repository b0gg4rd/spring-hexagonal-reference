package net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.repository;

import net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsSpringJpaRepository extends JpaRepository<PersonEntity, String> {
}
