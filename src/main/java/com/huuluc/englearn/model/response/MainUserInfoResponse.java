package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MainUserInfoResponse {
    private String username;
    private boolean gender;
    private String urlAvatar;
    private int streak;
    private int experience;

    public MainUserInfoResponse(User user) {
        this.username = user.getUsername();
        this.streak = user.getStreak();
        this.experience = user.getExperience();
    }
}
