package com.example.study_logs.controller;

import com.example.study_logs.dto.request.StudyLogRequest;
import com.example.study_logs.dto.response.CounterTagsResponse;
import com.example.study_logs.dto.response.StudyLogResponse;
import com.example.study_logs.dto.response.StudyLogsAndCounterTagsResponse;
import com.example.study_logs.service.StudyLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/studylogs")
public class StudyLogController {

    private final StudyLogService studyLogService;

    @PostMapping
    public ResponseEntity<StudyLogResponse> save(@RequestBody StudyLogRequest studyLogRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(studyLogService.saveStudyLog(studyLogRequest));
    }

    @GetMapping
    public ResponseEntity<List<StudyLogResponse>> findAll(){
        return ResponseEntity.ok(studyLogService.getAllStudyLogs());
    }

    @GetMapping("/studylogs-counter")
    public ResponseEntity<StudyLogsAndCounterTagsResponse> countTags(){
        return ResponseEntity.ok(studyLogService.getAllStudyLogsWithCountTags());
    }
}
