package com.jsp.qeats.commonModule.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseStructure {

    private Integer statuscode;
    private String message;
}
