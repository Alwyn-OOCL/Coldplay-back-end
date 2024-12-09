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
@Table(name = "ticket", schema = "cold_play_db")
public class Ticket {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "audience_name", nullable = false)
    private String audienceName;

    @Column(name = "audience_id_card", nullable = false)
    private String audienceIdCard;

    @Column(name = "seat_id", nullable = false)
    private Integer seatId;

    @Column(name = "is_refunded", nullable = false)
    private Boolean isRefunded = false;

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