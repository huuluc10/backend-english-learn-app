package com.huuluc.englearn.model;

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
@AllArgsConstructor
@NoArgsConstructor
public class UserLesson {
    @Size(min = 1, max = 30)
    @NotEmpty
    @NotNull
    @NotBlank
    private String username;
    @NotEmpty
    @NotNull
    @NotBlank
    private short lessonId;
    @NotEmpty
    @NotNull
    @NotBlank
    private Date dateLearned;
}
