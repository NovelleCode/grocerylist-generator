package se.iths.grocerylistgenerator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.grocerylistgenerator.entity.*;
import se.iths.grocerylistgenerator.repository.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GrocerylistGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrocerylistGeneratorApplication.class, args);
    }
}
