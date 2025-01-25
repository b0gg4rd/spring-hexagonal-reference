package net.coatli.springhexagonalreference.adapter.primary.model.mapper;

import net.coatli.springhexagonalreference.adapter.primary.model.CreateOnePersonRequest;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonsHttpApiAdapterMapper {

  CreateOnePersonCommandInput toCreateOnePersonCommandInput(CreateOnePersonRequest createOnePersonRequest);

}
