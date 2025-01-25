package net.coatli.springhexagonalreference.adapter.primary.model;

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
public class CreateOnePersonRequest {

  private String name;

  private Integer age;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
