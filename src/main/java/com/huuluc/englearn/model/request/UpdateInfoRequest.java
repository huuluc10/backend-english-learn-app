package com.huuluc.englearn.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, max = 30)
    @NotEmpty
    @NotNull
    @NotBlank
    private String username;
    @NotEmpty
    @NotNull
    @NotBlank
    private String fullName;
    @NotEmpty
    @NotNull
    @NotBlank
    private Date dateOfBirth;
    @NotEmpty
    @NotNull
    @NotBlank
    private boolean gender;
    @NotEmpty
    @NotNull
    @NotBlank
    private String email;
}
