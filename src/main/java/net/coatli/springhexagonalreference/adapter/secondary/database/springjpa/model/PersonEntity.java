package net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model;

import com.jsoniter.output.JsonStream;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.coatli.springhexagonalreference.common.StringLiterals;

@Getter
@Setter
@Accessors(
  chain = true,
  fluent = false)
@NoArgsConstructor
@Entity
@Table(name = StringLiterals.TABLE_PERSONS)
public class PersonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String name;

  private Integer age;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
