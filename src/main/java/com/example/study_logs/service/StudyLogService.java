package com.example.study_logs.service;

import com.example.study_logs.dto.request.StudyLogRequest;
import com.example.study_logs.dto.response.StudyLogResponse;
import com.example.study_logs.entity.StudyLog;
import com.example.study_logs.mapper.StudyLogMapper;
import com.example.study_logs.repository.StudyLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudyLogService {

    private final StudyLogRepository studyLogRepository;
    private final StudyLogMapper studyLogMapper;

    public StudyLogResponse saveStudyLog(StudyLogRequest studyLogRequest){

        StudyLog studyLog = studyLogMapper.toStudyLog(studyLogRequest);
        return studyLogMapper.toStudyLogResponse(studyLogRepository.save(studyLog));
    }

    public List<StudyLogResponse> getAllStudyLogs(){
        return studyLogMapper.toStudyLogResponses(studyLogRepository.findAll());
    }
}
