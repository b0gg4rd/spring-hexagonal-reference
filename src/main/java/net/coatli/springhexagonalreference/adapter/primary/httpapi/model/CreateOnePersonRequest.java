package net.coatli.springhexagonalreference.adapter.primary.httpapi.model;

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

  private String a0;

  private String a1;

  private String a2;

  private String a3;

  private String a4;

  private String a5;

  private String a6;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
