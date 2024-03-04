package com.huuluc.englearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.huuluc.englearn.constants.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private short questionId;
    private String questionContent;
    private short questionTypeId;
    private BelongTo belongTo;
    private short lessonId;
    private short examId;
    private int answer;
}
