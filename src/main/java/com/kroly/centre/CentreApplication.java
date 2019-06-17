package com.kroly.centre;

import com.kroly.centre.Data.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class CentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentreApplication.class, args);
    }

    @Async("AsyncConfig")
    public void test(){

        Person.PersonBuilder builder = Person.builder();
        System.out.println("Async");
    }
}
