package com.ironhack.client;

import com.github.javafaker.Faker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

  @Autowired
  private TargetProxy targetProxy;

  @Autowired
  private Faker faker;

  @GetMapping("/list/{size}")
  @Retry(name = "buffy-fallback", fallbackMethod = "buffyFallback")
  public List<String> getList(@PathVariable("size") int size) {
    return targetProxy.getList(size);
  }

  public List<String> buffyFallback(/*int size,*/ Exception e) {
    var list = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
      list.add(faker.rickAndMorty().quote());
    }
    return list;
  }


}
