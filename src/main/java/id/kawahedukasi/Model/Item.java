package id.kawahedukasi.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name="itemSequence", sequenceName = "item_sequence", allocationSize = 1)
    @GeneratedValue(generator = "itemSequence", strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    public Long id;

    @Column(name="name")
    public String name;

    @Column(name="email")
    public String email;

    @Column(name="count")
    public Integer count;

    @Column(name="price")
    public Long price;

    @Column(name="type")
    public String type;

    @Column(name="description")
    @Type(type="text")
    public String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
