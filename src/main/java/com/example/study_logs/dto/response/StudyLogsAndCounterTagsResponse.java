package com.example.study_logs.dto.response;

import java.util.List;

public record StudyLogsAndCounterTagsResponse(
        List<StudyLogResponse> studyLogResponses,
        List<CounterTagsResponse> counterTagsResponses
) {
}
