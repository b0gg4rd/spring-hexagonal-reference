package net.coatli.springhexagonalreference.application.model;

import com.jsoniter.output.JsonStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain = true,
  fluent = false)
@NoArgsConstructor
public class CreateOnePersonCommandInput {

  private Person person;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
