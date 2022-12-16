package com.enigmacamp.employee.model.response;

import lombok.Getter;
import lombok.Setter;

public abstract class CommonResponse {
    @Getter@Setter
    private String code;
    @Getter@Setter
    private String status;
    @Getter@Setter
    private String message;
}
