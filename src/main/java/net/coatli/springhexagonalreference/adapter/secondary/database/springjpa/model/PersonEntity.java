package net.coatli.springhexagonalreference.adapter.secondary.database.springjpa.model;

import com.jsoniter.output.JsonStream;
import jakarta.persistence.Column;
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

  @Column(name = "names")
  private String names;

  @Column(name = "first_surname")
  private String firstSurname;

  @Column(name = "second_surname")
  private String secondSurname;

  @Column(name = "gender")
  private String gender;

  @Column(name = "birthday")
  private String birthday;

  @Column(name = "curp")
  private String curp;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
