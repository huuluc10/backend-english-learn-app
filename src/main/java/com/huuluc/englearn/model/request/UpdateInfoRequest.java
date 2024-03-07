package com.huuluc.englearn.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInfoRequest {
    private String username;
    private String fullName;
    private Date dateOfBirth;
    private boolean gender;
    private String email;
}
