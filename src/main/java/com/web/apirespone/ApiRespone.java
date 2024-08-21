package com.web.apirespone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRespone <T>{
    private int code;
    private String message;
    private T result;
}
