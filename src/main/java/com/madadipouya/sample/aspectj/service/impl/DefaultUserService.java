package com.madadipouya.sample.aspectj.service.impl;

import com.madadipouya.sample.aspectj.dto.User;
import com.madadipouya.sample.aspectj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.madadipouya.sample.aspectj.config.CacheManagerConfig.USER_CACHE;

@Service
public class DefaultUserService implements UserService {

    private final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    @Override
    public List<User> getAllUsers() {
        return getMockUsers();
    }

    @Cacheable(USER_CACHE)
    private List<User> getMockUsers() {
        logger.info("Generating all the mock users!");
        return IntStream.range(0, 1000).mapToObj(i -> new User(i, UUID.randomUUID().toString(), UUID.randomUUID().toString()))
                .collect(Collectors.toList());
    }
}