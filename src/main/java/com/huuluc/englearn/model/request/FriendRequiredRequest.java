package com.huuluc.englearn.model.request;

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
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequiredRequest {
    @Size(min = 1, max = 30)
    @NotEmpty
    @NotNull
    @NotBlank
    private String sender;
    @Size(min = 1, max = 30)
    @NotEmpty
    @NotNull
    @NotBlank
    private String receiver;
}
