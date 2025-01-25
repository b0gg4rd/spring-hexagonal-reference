package net.coatli.springhexagonalreference.adapter.secondary.database.springjpa;

import lombok.RequiredArgsConstructor;
import net.coatli.springhexagonalreference.adapter.secondary.database.PersonsDatabaseSecondaryAdapter;
import net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model.mapper.PersonsDatabaseSpringJpaMapper;
import net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.repository.PersonsSpringJpaRepository;
import net.coatli.springhexagonalreference.application.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PersonsDatabaseSpringJpa implements PersonsDatabaseSecondaryAdapter {

  private final PersonsSpringJpaRepository personsSpringJpaRepository;

  private final PersonsDatabaseSpringJpaMapper personsDatabaseSpringJpaMapper;

  @Override
  public Person createOne(final Person person) {

    return
      personsDatabaseSpringJpaMapper.personEntity2Person(
        personsSpringJpaRepository.save(
          personsDatabaseSpringJpaMapper.person2PersonEntity(person)));

  }

  @Override
  public List<Person> retrieveAll() {

    return personsDatabaseSpringJpaMapper.listOfPersonEntity2ListOfPerson(personsSpringJpaRepository.findAll());

  }
}
