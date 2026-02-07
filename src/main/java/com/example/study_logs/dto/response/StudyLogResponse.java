package com.example.study_logs.dto.response;

import java.util.List;

public record StudyLogResponse(String title, String description,String createdAt, List<String> tags) {
}
