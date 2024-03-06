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
    private boolean gender;
    private Date dateOfBirth;
    private String email;
    private String password;
    private short roleId;
    private int avatar;
    private int streak;
    private int experience;
}
