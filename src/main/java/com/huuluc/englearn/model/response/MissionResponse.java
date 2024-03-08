package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.MissionDaily;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionResponse extends MissionDaily {
    private boolean isDone;

    public MissionResponse(MissionDaily missionDaily) {
        super(missionDaily.getMissionId(), missionDaily.getMissionName(), missionDaily.getMissionContent(), missionDaily.getMissionExperience());
        this.isDone = false;
    }
}
