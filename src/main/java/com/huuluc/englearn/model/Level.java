package com.huuluc.englearn.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @NotEmpty
    @NotNull
    @NotBlank
    private String levelId;
    @Size(min = 1, max = 30)
    @NotEmpty
    @NotNull
    @NotBlank
    private String levelName;
    @NotEmpty
    @NotNull
    @NotBlank
    private int experienceThreshold;
}
