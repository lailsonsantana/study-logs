package com.example.study_logs.repository;

import com.example.study_logs.dto.response.CounterTagsResponse;
import com.example.study_logs.entity.StudyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyLogRepository extends JpaRepository<StudyLog, Long> {

    @Query(value = "SELECT t.tag, COUNT(*) FROM db_study_logs sl, db_tags t " +
            "WHERE t.study_log_id = sl.id GROUP BY tag ORDER BY count DESC", nativeQuery = true)
    List<CounterTagsResponse> countTags();

}
