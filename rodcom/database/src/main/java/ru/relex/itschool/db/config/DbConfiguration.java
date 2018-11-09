package ru.relex.itschool.db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : sasha
 */
@Configuration
@EntityScan("ru.relex.itschool.db.entity")
@EnableJpaRepositories("ru.relex.itschool.db.repository")
@PropertySource("classpath:hibernate.properties")
public class DbConfiguration {
}
