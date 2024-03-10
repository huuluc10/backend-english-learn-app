package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.Exam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResponse {
    private short examId;
    private String examName;
    private int examExperience;
    private String examLevel;
    private float examResult;

    public ExamResponse(Exam exam) {
        this.examId = exam.getExamId();
        this.examName = exam.getExamName();
        this.examExperience = exam.getExamExperience();
    }
}
