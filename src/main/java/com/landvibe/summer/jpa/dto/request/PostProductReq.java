package com.landvibe.summer.jpa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostProductReq {
    private Long categoryId;
    private String name;
    private String description;
}