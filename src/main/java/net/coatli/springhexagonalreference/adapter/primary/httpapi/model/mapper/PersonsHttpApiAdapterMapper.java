package net.coatli.springhexagonalreference.adapter.primary.httpapi.model.mapper;

import net.coatli.springhexagonalreference.adapter.primary.httpapi.model.CreateOnePersonRequest;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonsHttpApiAdapterMapper {

  @Mapping(target = "person.names",         source = "a1")
  @Mapping(target = "person.firstSurname",  source = "a2")
  @Mapping(target = "person.secondSurname", source = "a3")
  @Mapping(target = "person.gender",        source = "a4")
  @Mapping(target = "person.birthday",      source = "a5")
  CreateOnePersonCommandInput toCreateOnePersonCommandInput(CreateOnePersonRequest createOnePersonRequest);

}
