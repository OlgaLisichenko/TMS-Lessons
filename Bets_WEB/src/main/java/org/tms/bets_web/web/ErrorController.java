package org.tms.bets_web.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView processError(RuntimeException exception) {
        Map<String, String> model = new HashMap<>();
        model.put("message", exception.getMessage());
        return new ModelAndView("error", model);
    }
}