package net.coatli.springhexagonalreference.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.springhexagonalreference.adapter.secondary.database.PersonsDatabaseSecondaryAdapter;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandOutput;
import net.coatli.springhexagonalreference.application.model.mapper.CreateOnePersonCommandUseCaseMapper;
import net.coatli.springhexagonalreference.application.port.CreateOnePersonCommand;
import net.coatli.springhexagonalreference.common.StringLiterals;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateOnePersonCommandUseCase implements CreateOnePersonCommand {

  private final PersonsDatabaseSecondaryAdapter personsDatabaseSecondaryAdapter;

  private final CreateOnePersonCommandUseCaseMapper createOnePersonCommandUseCaseMapper;

  @Override
  public CreateOnePersonCommandOutput execute(final CreateOnePersonCommandInput createOnePersonCommandInput) {

    LOGGER.info(
      StringLiterals.LOG_USE_CASE_CREATE_PERSON,
      createOnePersonCommandInput);

    return
      createOnePersonCommandUseCaseMapper.person2CreateOnePersonCommandOutput(
        personsDatabaseSecondaryAdapter.createOne(
          createOnePersonCommandUseCaseMapper.createOnePersonCommandInput2Person(createOnePersonCommandInput)));

  }

}
