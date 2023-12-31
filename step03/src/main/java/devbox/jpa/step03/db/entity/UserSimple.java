package devbox.jpa.step03.db.entity;

import java.util.Date;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table
@Access(AccessType.PROPERTY)
@SequenceGenerator(
    name= "S_EMP_GENERATOR",
    sequenceName = "S_EMP_SEQUENCE",
    initialValue = 1,
    allocationSize = 1
)
public class UserSimple {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_EMP_GENERATOR")
    private Long id;
    private String name;
    private String email;
    @Column(name = "password", nullable = true, unique = false, length = 30)
    private String pw;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Transient
    private String temp;

    public UserSimple(String name, String email, String pw, Date joinDate, String temp) {
        this.name = name;
        this.email = email;
        this.pw = pw;
        this.joinDate = joinDate;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name.toLowerCase();
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }
    
    public Date getJoinDate() {
        return joinDate;
    }

    public String getTemp() {
        return temp;
    }
}
