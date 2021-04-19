package com.lambdaschool.schools.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDetail
{
    private String title;
    private int status;
    private String detail;
    private Date timestamp;
    private String developerMessage;
    private List<ValidationError> error = new ArrayList<>();


}
