package com.huuluc.englearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionDaily {
    private short missionId;
    private String missionName;
    private String missionContent;
    private int missionExpereince;
}
