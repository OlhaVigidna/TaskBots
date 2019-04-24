package models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"departments"})
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lectorId;
    String lectorName;
    String lectorSurname;
    int lectorSalary;
    Degree lectorDegree;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "lectors")
    List<Department> departments = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "headOfDepartment")
    Department headOfDepartment;
}
