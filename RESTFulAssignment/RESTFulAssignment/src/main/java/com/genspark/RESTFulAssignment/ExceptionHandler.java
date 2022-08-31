package com.genspark.RESTFulAssignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> showIsBookedMessage(Exception e) {

        Map<String, String> response = new HashMap<>();
        response.put("error", "The ticket has been already purchased!");

        return response;

    }

}
