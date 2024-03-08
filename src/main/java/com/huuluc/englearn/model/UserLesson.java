package com.huuluc.englearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLesson {
    private String username;
    private short lessonId;
    private Date dateLearned;
}
