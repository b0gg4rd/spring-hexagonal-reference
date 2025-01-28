package net.coatli.springhexagonalreference.application.model.mapper;

import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandOutput;
import net.coatli.springhexagonalreference.application.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateOnePersonCommandUseCaseMapper {

  @Mapping(target = ".", source = "person")
  Person createOnePersonCommandInput2Person(CreateOnePersonCommandInput createOnePersonCommandInput);

  CreateOnePersonCommandOutput person2CreateOnePersonCommandOutput(Person person);

}
