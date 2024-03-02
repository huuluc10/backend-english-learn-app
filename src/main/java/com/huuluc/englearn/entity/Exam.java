package com.huuluc.englearn.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private short examId;
    private String examName;
    private int examExperience;
    private short examLevel;
}
