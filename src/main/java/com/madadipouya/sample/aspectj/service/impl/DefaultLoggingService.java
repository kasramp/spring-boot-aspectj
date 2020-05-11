package com.madadipouya.sample.aspectj.service.impl;

import com.madadipouya.sample.aspectj.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A dummy implementation of logging service,
 * just to inject it in {@link com.madadipouya.sample.aspectj.interceptor.LoggingInterceptor}
 * that's managed by AspectJ
 */
@Service
public class DefaultLoggingService implements LoggingService {

    private static final Logger logger = LoggerFactory.getLogger("sample-spring-aspectj");

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
