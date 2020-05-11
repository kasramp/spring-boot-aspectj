package com.madadipouya.sample.aspectj.interceptor;

import com.madadipouya.sample.aspectj.service.LoggingService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Aspect
public class LoggingInterceptor {

    @Autowired
    private LoggingService loggingService;

    @Before(value = "execution(* com.madadipouya.sample.aspectj.controller.UserController.getUsersInternal(..))")
    public void addCommandDetailsToMessage() throws Throwable {
        loggingService.log(String.format("User controller getUsers method called at %s", ZonedDateTime.now((ZoneOffset.UTC))));
    }
}
