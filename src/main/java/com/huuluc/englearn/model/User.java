package com.huuluc.englearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String fullName;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String roleId;
    private String avatar;
    private String streak;
    private String experience;
}
