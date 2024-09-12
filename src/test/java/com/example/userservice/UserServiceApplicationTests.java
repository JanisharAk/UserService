package com.example.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private RegisteredClientRepository registeredClientRepository;


    @Test
    void contextLoads() {
    }

}
