package net.coatli.springhexagonalreference.adapter.primary.httpapi.springweb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.springhexagonalreference.adapter.primary.httpapi.model.CreateOnePersonRequest;
import net.coatli.springhexagonalreference.adapter.primary.httpapi.model.mapper.PersonsHttpApiAdapterMapper;
import net.coatli.springhexagonalreference.application.port.CreateOnePersonCommand;
import net.coatli.springhexagonalreference.common.StringLiterals;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(StringLiterals.PERSONS_PATH)
public class PersonsHttpApiAdapterSpringWeb {

  private final CreateOnePersonCommand createOnePersonCommand;

  private final PersonsHttpApiAdapterMapper personsHttpApiAdapterMapper;

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Void> createOnePerson(@RequestBody final CreateOnePersonRequest createOnePersonRequest) {

    LOGGER.info(
      StringLiterals.LOG_CREATE_ONE_PERSON,
      createOnePersonRequest);

    final var createOnePersonCommandOutput = createOnePersonCommand.execute(personsHttpApiAdapterMapper.toCreateOnePersonCommandInput(createOnePersonRequest));

    LOGGER.info(
      StringLiterals.LOG_PERSON_CREATED,
      createOnePersonCommandOutput.getId());

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .header(
        StringLiterals.HEADER_X_PERSON_ID,
        createOnePersonCommandOutput.getId())
      .build();

  }

}
