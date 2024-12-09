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
@Table(name = "concerts", schema = "cold_play_db")
public class Concert {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @Column(name = "duration", nullable = false)
    private Double duration;

    @Column(name = "venue_id", nullable = false)
    private Integer venueId;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "sale_time", nullable = false)
    private Instant saleTime;

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