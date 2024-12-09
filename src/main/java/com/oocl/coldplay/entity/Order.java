package com.oocl.coldplay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`order`", schema = "cold_play_db")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "concert_id", nullable = false)
    private Integer concertId;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_by_name", nullable = false)
    private String createdByName;

    @Column(name = "last_modified_by", nullable = false)
    private String lastModifiedBy;

    @Column(name = "last_modified_by_name", nullable = false)
    private String lastModifiedByName;

    @Column(name = "created_time", nullable = false)
    private Instant createdTime;

    @Column(name = "last_modified_time", nullable = false)
    private Instant lastModifiedTime;

}