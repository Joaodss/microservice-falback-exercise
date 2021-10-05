package com.ironhack.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("target-service")
public interface TargetProxy {

  @GetMapping("/list/{size}")
  public List<String> getList(@PathVariable("size") int size);


}
