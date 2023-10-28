package fit.se.gk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Candidate.getAll",query = "select c from Candidate c"),
        @NamedQuery(name = "Candidate.getByEmail",query = "select c from Candidate c where c.email is not null "),
        @NamedQuery(name = "Candidate.getByRole", query = "select distinct c from Candidate c join Experience e on c.id=e.candidate.id where e.role = :role")
})
public class Candidate {
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<Experience> experiences;
    public Candidate(String phone, String email, String fullname) {
        this.phone = phone;
        this.email = email;
        this.fullName = fullname;
    }
}
