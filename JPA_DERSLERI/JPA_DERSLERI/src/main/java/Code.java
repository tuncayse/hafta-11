import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "codes")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id",columnDefinition = "serial")
    private int id;

    @Column(name = "code_group", nullable = false)
    private String group;

    @Column(name = "code_serial", nullable = false)
    private String serial;

    @OneToOne(mappedBy = "code" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;

    public enum GENDER {
        MALE,
        FEMALE
    }
    public Code(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
