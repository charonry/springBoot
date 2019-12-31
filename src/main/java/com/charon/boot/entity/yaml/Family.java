package com.charon.boot.entity.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-30 22:32
 **/
@Data
@Component
@ConfigurationProperties(prefix = "family")
@Validated
public class Family {

    //@Value("${family.family-name}")
    @NotEmpty
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
