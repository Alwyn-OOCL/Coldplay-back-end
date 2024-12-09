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
@Table(name = "new_section", schema = "cold_play_db")
public class NewSection {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

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