package com.huuluc.englearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    private String levelId;
    private String levelName;
    private int experienceThreshold;
}
