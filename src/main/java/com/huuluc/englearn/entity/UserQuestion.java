package com.huuluc.englearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserQuestion {
    private String username;
    private int questionId;
    private int isCorrect;
}
