package com.ironhack.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {

  @Autowired
  private ListGenerator listGenerator;

  @GetMapping("/{size}")
  public List<String> getList(@PathVariable("size") int size) {
    return listGenerator.generateList(size);
  }

}
