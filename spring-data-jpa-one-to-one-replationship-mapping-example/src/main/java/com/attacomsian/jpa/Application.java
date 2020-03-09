package com.attacomsian.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.attacomsian.jpa.one2one.respositories.AddressRepository;
import com.attacomsian.jpa.one2one.respositories.UserRepository;
import com.attacomsian.jpa.one2one.domains.Address;
import com.attacomsian.jpa.one2one.domains.User;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(UserRepository userRepository,
                                         AddressRepository addressRepository) {
        return args -> {
        	
            // create a user instance
            User user = new User("John Doe", "john.doe@example.com", "1234abcd");

            // create an address instance
            Address address = new Address("Lake View 321", "Berlin", "Berlin",
                    "95781", "DE");

            // set child reference
            address.setUser(user);

            // set parent reference
            user.setAddress(address);

            // save the parent
            // which will save the child (address) as well
            userRepository.save(user);
     
        	
        	System.out.println(userRepository.count());
        	
        };
    }
}
