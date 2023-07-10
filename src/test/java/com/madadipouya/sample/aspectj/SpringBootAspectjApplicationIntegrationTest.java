package com.madadipouya.sample.aspectj;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.madadipouya.sample.aspectj.dto.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootAspectjApplicationIntegrationTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnCachedUsers() {
        URI uri = URI.create(String.format("http://localhost:%s/v1/users", port));

        ResponseEntity<List<User>> result = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });

        assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(result.hasBody()).isTrue();
        assertThat(result.getBody()).hasSize(1000);

        ResponseEntity<List<User>> cachedResult = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });

        assertThat(cachedResult.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(cachedResult.hasBody()).isTrue();
        assertThat(cachedResult.getBody()).hasSize(1000);
        assertThat(result.getBody()).hasSameElementsAs(cachedResult.getBody());
    }
}
