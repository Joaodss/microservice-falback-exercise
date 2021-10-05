package com.ironhack.target.sample_data;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataConfig {

  @Bean
  Faker faker() {
    return new Faker();
  }


}
