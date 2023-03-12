package org.tms.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class SpringBootTmsApplication implements CommandLineRunner {

    @Value("${file_path}")
    private String filePath;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            int counter = Integer.parseInt(Files.readString(path)) + 1;
            Files.writeString(path, String.valueOf(counter));
        } else {
            Files.writeString(path, "1");
        }
    }
}