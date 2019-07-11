package com.nayanzin.jpadocumentnumbergenerator;

import com.nayanzin.jpadocumentnumbergenerator.model.Entity;
import com.nayanzin.jpadocumentnumbergenerator.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;
import java.util.stream.IntStream;

@SpringBootApplication
public class JpaDocumentNumberGeneratorApplication {

    @Autowired
    public JpaDocumentNumberGeneratorApplication(EntityService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDocumentNumberGeneratorApplication.class, args);
    }

    private EntityService service;

    private int threadsCount = 10;
    private int insertsCount = 500;

    private Function<String, Thread> tread =
            prefix -> new Thread(() -> IntStream.range(0, insertsCount)
                    .forEach(i -> service.save(new Entity(prefix))));

    @Bean
    public CommandLineRunner clr1() {
        return args -> IntStream.range(0, threadsCount)
                .forEach(i -> tread.apply("0_prefix").start());
    }
}
