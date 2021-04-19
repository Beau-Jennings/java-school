package com.lambdaschool.schools.exceptions;

import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomErrorDetails extends DefaultErrorAttributes
{
    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace)
    {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        Map<String, Object> rtnAttributes = new LinkedHashMap<>();

        errorAttributes.put("title", errorAttributes.get("error"));
        errorAttributes.put("status", errorAttributes.get("status"));
        errorAttributes.put("detail", errorAttributes.get("message"));
        errorAttributes.put("timestamp", new Date());
        errorAttributes.put("developerMessage", "path: " + errorAttributes.get("path"));
        errorAttributes.put("errors", helperFunctions.getConstraintViolations(this.getError(webRequest)));

        return rtnAttributes;
    }
}
