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
@ToString(exclude = "lectors")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int departmentId;
    String departmentName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Lector headOfDepartment;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Lector> lectors = new ArrayList<Lector>();

}
