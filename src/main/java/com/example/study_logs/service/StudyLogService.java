package com.example.study_logs.service;

import com.example.study_logs.dto.request.StudyLogRequest;
import com.example.study_logs.dto.response.CounterTagsResponse;
import com.example.study_logs.dto.response.StudyLogResponse;
import com.example.study_logs.dto.response.StudyLogsAndCounterTagsResponse;
import com.example.study_logs.entity.StudyLog;
import com.example.study_logs.mapper.StudyLogMapper;
import com.example.study_logs.repository.StudyLogRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudyLogService {

    private final StudyLogRepository studyLogRepository;
    private final StudyLogMapper studyLogMapper;

    @Transactional
    public StudyLogResponse saveStudyLog(StudyLogRequest studyLogRequest){

        StudyLog studyLog = studyLogMapper.toStudyLog(studyLogRequest);
        return studyLogMapper.toStudyLogResponse(studyLogRepository.save(studyLog));
    }

    public List<StudyLogResponse> getAllStudyLogs(){
        return studyLogMapper.toStudyLogResponses(studyLogRepository.findAllByOrderByCreatedAtDesc());
    }

    public StudyLogsAndCounterTagsResponse getAllStudyLogsWithCountTags(){
        List<StudyLogResponse> studyLogResponses = studyLogMapper.
                toStudyLogResponses(studyLogRepository.findAllByOrderByCreatedAtDesc());
        List<CounterTagsResponse> counterTagsResponses = studyLogRepository.countTags();
        return new StudyLogsAndCounterTagsResponse(studyLogResponses, counterTagsResponses);
    }

}
