package com.kakaopay.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "coupon",
       uniqueConstraints = {
       @UniqueConstraint(columnNames = {"email"}),
       @UniqueConstraint(columnNames = {"coupon"})})
public class Coupon {

    @Id
    @GeneratedValue
    @Column(name = "ID")

    private Long id;
    private String email;
    private String coupon;

    @CreationTimestamp
    private Timestamp regDate;
    @UpdateTimestamp
    private Timestamp updateDate;

}