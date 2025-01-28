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
public class Person {

  private String id;

  private String names;

  private String firstSurname;

  private String secondSurname;

  private String gender;

  private String birthday;

  private String curp;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
