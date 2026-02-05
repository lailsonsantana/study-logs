package com.example.study_logs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Table(name = "db_study_logs")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private String title;

    private String description;

    @ElementCollection
    @Column(name = "tag")
    @CollectionTable(name="db_tags")
    private List<String> tags;
}
