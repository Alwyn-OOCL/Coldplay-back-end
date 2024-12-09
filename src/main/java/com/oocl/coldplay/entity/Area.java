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
@Table(name = "area", schema = "cold_play_db")
public class Area {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "concert_id", nullable = false)
    private Integer concertId;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "available", nullable = false)
    private Integer available;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "area_type", nullable = false)
    private String areaType;

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