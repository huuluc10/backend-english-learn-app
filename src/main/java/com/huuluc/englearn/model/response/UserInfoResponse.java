package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoResponse {
    private String username;
    private String fullName;
    private boolean gender;
    private Date dateOfBirth;
    private String email;
    private String urlAvatar;
    private int streak;
    private int experience;
    private String level;

    public UserInfoResponse(User user) {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.gender = user.isGender();
        this.dateOfBirth = user.getDateOfBirth();
        this.email = user.getEmail();
        this.streak = user.getStreak();
        this.experience = user.getExperience();
    }
}
