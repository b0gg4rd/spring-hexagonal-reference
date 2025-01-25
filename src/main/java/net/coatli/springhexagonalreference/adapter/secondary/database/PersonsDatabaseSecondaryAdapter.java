package net.coatli.springhexagonalreference.adapter.secondary.database;

import net.coatli.springhexagonalreference.application.model.Person;

import java.util.List;

public interface PersonsDatabaseSecondaryAdapter {

  Person createOne(Person person);

  List<Person> retrieveAll();

}
