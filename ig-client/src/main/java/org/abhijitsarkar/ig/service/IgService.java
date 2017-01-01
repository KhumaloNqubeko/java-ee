package org.abhijitsarkar.ig.service;

import org.abhijitsarkar.ig.domain.AccessToken;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author Abhijit Sarkar
 */
public interface IgService {
    Mono<String> authorizationUrl();

    Mono<Collection> callback(String code);
}
