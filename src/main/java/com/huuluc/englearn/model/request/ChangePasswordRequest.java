package com.huuluc.englearn.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 30)
    private String username;
    @NotBlank
    @NotEmpty
    private String oldPassword;
    @NotBlank
    @NotEmpty
    private String newPassword;
}
