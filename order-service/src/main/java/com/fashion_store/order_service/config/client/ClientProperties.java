package com.fashion_store.order_service.config.client;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Getter
@ConfigurationProperties(prefix = "other_service")
public class ClientProperties {

    private URI productServiceURI;

}
