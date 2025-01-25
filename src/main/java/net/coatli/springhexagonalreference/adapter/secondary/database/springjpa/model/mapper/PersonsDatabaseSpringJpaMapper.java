package net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model.mapper;

import net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model.PersonEntity;
import net.coatli.springhexagonalreference.application.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonsDatabaseSpringJpaMapper {

  PersonEntity person2PersonEntity(Person person);

  List<Person> listOfPersonEntity2ListOfPerson(List<PersonEntity> personEntities);

  Person personEntity2Person(PersonEntity personEntity);

}
