package com.example.demo.BankUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



//The following annotation marks the following class as the bean which is an object used by the spring boot
//to inject during dependency injection.

//All the classes that are marked as the @Component goes into the Spring Bean Container. Spring creates the object
//of such classes and provide to the classes who need them when necessary.

//So in short, Spring scans all the classes with @Component and makes them as beans, creates the objects of all and provide to the
//classes on demand, hence insuring IOC
//@Component

//instead of this annotation, we use a specific annotation for the Service class, which is only for Service class to
//indicate that following class is meant for providing business logic only
//It is same as @Component, but it is used for semantics

@Service
public class BankUserService {

    private final BankUserRepository bankUserRepository;

    @Autowired
    public BankUserService(BankUserRepository bankUserRepository){
        this.bankUserRepository = bankUserRepository;
    }
    public List<BankUser> getAllUsers() {
//        return List.of(new BankUser(
//                1,
//                "Atif Iqbal Butt",
//                399493,
//                "current",
//                "admin",
//                LocalDate.now()
//            )
//        );

        return bankUserRepository.findAll();
    }

    public void createUser(BankUser bankUser) {
        bankUserRepository.save(bankUser);
    }
}
