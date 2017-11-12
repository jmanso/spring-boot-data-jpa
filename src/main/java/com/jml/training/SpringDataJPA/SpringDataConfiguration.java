package com.jml.training.SpringDataJPA;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.jml.training")
@EntityScan("com.jml.training.model")
@EnableJpaRepositories("com.jml.training.repository")
@EnableTransactionManagement
public class SpringDataConfiguration {


}
