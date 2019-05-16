package com.commerce.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UploadFileDTO {

    private String base64;
    private String name;

    public String getBase64() {
        return base64.split(",")[1];
    }
}