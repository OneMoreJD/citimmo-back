package com.wcs.citimmo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReadUserDto {
    private String firstName;
    private String lastName;
    private String email;
}
