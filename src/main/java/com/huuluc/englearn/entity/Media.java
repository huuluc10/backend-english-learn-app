package com.huuluc.englearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    private short mediaId;
    private String mediaName;
    private short mediaTypeId;
    private String url;
}
