package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse extends Lesson {
    private String completed;

    public LessonResponse(Lesson lesson, String completed) {
        super(lesson.getLessonId(), lesson.getLessonName(), lesson.getTopicId(), lesson.getContent(), lesson.getLessonExperience(), lesson.getLevelId());
        this.completed = completed;
    }
}
