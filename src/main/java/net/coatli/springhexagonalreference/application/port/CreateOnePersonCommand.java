package net.coatli.springhexagonalreference.application.port;

import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandInput;
import net.coatli.springhexagonalreference.application.model.CreateOnePersonCommandOutput;

public interface CreateOnePersonCommand {

  CreateOnePersonCommandOutput execute(CreateOnePersonCommandInput createOnePersonCommandInput);

}
