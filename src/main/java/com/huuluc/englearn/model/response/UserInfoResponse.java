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
public class UserInfoResponse extends MainUserInfoResponse {
    private String fullName;
    private Date dateOfBirth;
    private String email;
    private String level;

    public UserInfoResponse(User user) {
        super(user);
        this.fullName = user.getFullName();
        this.dateOfBirth = user.getDateOfBirth();
        this.email = user.getEmail();
    }
}
