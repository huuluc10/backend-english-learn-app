package com.huuluc.englearn.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerQuestionRequest {
    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String username;
    @NotBlank
    @NotNull
    @NotEmpty
    private int questionId;
    @NotBlank
    @NotNull
    @NotEmpty
    private boolean isCorrect;
}
