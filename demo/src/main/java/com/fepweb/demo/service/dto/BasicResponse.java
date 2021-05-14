package com.fepweb.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicResponse {
    private String key;
    private String value;
}
