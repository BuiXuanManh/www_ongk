package fit.se.gk.backend.models;

import fit.se.gk.backend.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "experence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Experience.findByRole",query = "select e from Experience e where e.role=?1"),
        @NamedQuery(name = "Experience.getAll",query = "select e from Experience e"),
        @NamedQuery(name = "Experience.findByCanId", query = "select e from Experience e where e.candidate.id=:id" )
})
public class Experience {
    @Id
    @Column(name = "expr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "work_desc",columnDefinition = "varchar(400)")
    private String workDescription;
    @Column(columnDefinition = "tinyint(4)")
    @Enumerated(EnumType.ORDINAL)
    private Roles role;
    @Column(name = "from_date",columnDefinition = "date")
    private LocalDate fromDate;
    @Column(name = "to_date",columnDefinition = "date")
    private LocalDate toDate;
    @Column(name = "company",columnDefinition = "varchar(120)")
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(String workDescription, Roles role, LocalDate fromDate, LocalDate toDate, String companyName, Candidate candidate) {
        this.workDescription = workDescription;
        this.role = role;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.companyName = companyName;
        this.candidate = candidate;
    }
}
