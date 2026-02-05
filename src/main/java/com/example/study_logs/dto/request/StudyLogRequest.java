package com.example.study_logs.dto.request;

import java.util.List;

public record StudyLogRequest(String title, String description, List<String> tags) {
}
