package ru.relex.itschool;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("ru.relex.itschool")
@EnableTransactionManagement
public class Config {
}
