package com.example.study_logs.mapper;

import com.example.study_logs.dto.request.StudyLogRequest;
import com.example.study_logs.dto.response.StudyLogResponse;
import com.example.study_logs.entity.StudyLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudyLogMapper {

    StudyLog toStudyLog(StudyLogRequest studyLogsRequest);

    StudyLogResponse toStudyLogResponse(StudyLog studyLog);

    List<StudyLogResponse> toStudyLogResponses(List<StudyLog> studyLogs);


}
