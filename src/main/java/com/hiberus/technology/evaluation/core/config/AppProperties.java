package com.hiberus.technology.evaluation.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppProperties {
    private String exampleVar;
}
