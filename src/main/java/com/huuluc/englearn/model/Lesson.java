package com.huuluc.englearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    private short lessonId;
    private String lessonName;
    private short topicId;
    private int content;
    private int lessonExperience;
    private short levelId;
}
