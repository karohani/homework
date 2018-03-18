package com.kakaopay.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity

@Table(name = "person", uniqueConstraints={
        @UniqueConstraint(
                columnNames={"email"}),
        @UniqueConstraint(columnNames = {"compressed"})
}
)
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")

    private Long id;


    private String email;
    private String compressed;

    @CreationTimestamp
    private Timestamp regDate;
    @UpdateTimestamp
    private Timestamp updateDate;

}