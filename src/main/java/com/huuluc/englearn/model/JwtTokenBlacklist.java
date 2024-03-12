package com.huuluc.englearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenBlacklist {
    private String token;
    private Date expireAt;
}
