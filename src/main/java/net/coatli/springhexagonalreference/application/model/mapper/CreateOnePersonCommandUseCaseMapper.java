package net.coatli.springhexagonalreference.application.model.mapper;

import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandOutput;
import net.coatli.springhexagonalreference.application.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateOnePersonCommandUseCaseMapper {

  Person createOnePersonCommandInput2Person(CreateOnePersonCommandInput createOnePersonCommandInput);

  @Mapping(target = "id", source = "id")
  CreateOnePersonCommandOutput person2CreateOnePersonCommandOutput(Person person);

}
