/*package com.genspark.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Component
    public class Runner implements CommandLineRunner {

        private final TreadmillRepository repository;

        public Runner(TreadmillRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) {
            // work with the repository here
*//*            System.out.println("Before save:");
            doWeHaveSomethingInDb();

            System.out.println("Saving...");
            repository.save(new Treadmill("aaa", "Yamaguchi runway"));

            System.out.println("After save:");
            doWeHaveSomethingInDb();*//*
        }

*//*        private void doWeHaveSomethingInDb() {
            long count = repository.count();
            if (count > 0) {
                System.out.printf("Db has %d treadmills", count);
            } else {
                System.out.println("Db is empty");
            }
        }*//*

    }

}*/
