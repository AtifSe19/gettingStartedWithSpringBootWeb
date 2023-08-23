package com.example.demo.BankUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


//Controller annotation makes the following class behaves as controller. Controller takes the request from the client
//and return the view as a response
//The response must be a view. If you want to return other type of object, you have to mention the annotation
//@ResponseBody over the method.

//RestController is a special and new type of controller which does not require you to mention the annotation
//@ResponseBody if you want to return other than view, It is the combination of Controller and ResponseBody annotation
//It is used to create the Rest API

@RestController

//The following annotation is used to map the web request to the following controller
//The path specified in the controller works as the home path of the controller

//All other methods will be accessed by prefixing the path mentioned in the RequestMapping annotation
@RequestMapping(path = "/api/v1/bankUsers")
public class BankUserController {

//    The following method will be accessed by the path /api/v1/bankUsers

    private final BankUserService bankUserService;


//    The following annotation tells that the following methods needs the object, spring boot scans all the beans
//    checks if the required bean exists in the Spring Container, if it exists, it is injected into the following
//    method
    @Autowired
    public BankUserController(BankUserService bankUserService){
        this.bankUserService = bankUserService;
    }

    @GetMapping // if nothing mentions it means same as home or root path
    public List<BankUser> getAllUsers(){
//        return List.of(new BankUser(
//                1,
//                "Atif Iqbal Butt",
//                399493,
//                "current",
//                "admin",
//                LocalDate.now()
//            )

        return bankUserService.getAllUsers();
    }


//    The responsibility of the controller should only be taking response from the client and return the response,
//    it should not do any other thing. If we want to perform any business logic, we need to define the another class
//    for it which we refer as Service class

//    Controller takes request from client, sends it to the Service class, the service class performs some action and
//    returns the result to the Controller and Controller returns the response to the client

//    So for this purpose, we need to transfer the above logic into BankUserService class for the time being (temporarily)
//    We will transfer the above code into data specific layer file later because it is not business logic code

    @PostMapping
    public void createUser(@PathVariable BankUser bankUser){
        bankUserService.createUser(bankUser);
    }

}
