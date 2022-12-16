package com.enigmacamp.employee.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

public class EmployeeRequest {
    @Email(message = "Please insert valid email")
    @Getter@Setter
    private String email;

    @Size(min = 6, message = "Password minimum 6 characters")
    @Getter@Setter
    private String password;

    @Size(min = 2, message = "Name minimum 2 characters")
    @Getter@Setter
    private String name;

    @Getter@Setter
    private String position;

    @Getter@Setter
    private Date joinDate;

    @Getter@Setter
    private String education;

    @Getter@Setter
    private LearningPathIdRequest learningPathIdRequest = null;

}
