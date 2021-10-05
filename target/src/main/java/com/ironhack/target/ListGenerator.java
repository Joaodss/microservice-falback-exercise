package com.ironhack.target;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListGenerator {

  private final Faker faker;

  public ListGenerator(Faker faker) {
    this.faker = faker;
  }

  public List<String> generateList(int size) {
    var list = new ArrayList<String>();
    for (int i = 0; i < size; i++) {
      list.add(faker.buffy().quotes());
    }
    return list;
  }

//  public static void main(String[] args) {
//    System.out.println(generateList(5));
//  }
}
