package com.example.demo.BankUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The JpaRepository contains the functions that help us to perform the database operations
//We have to mention the model on which we want to perform the operation and the unique identifier

//The following annotation tells that the following class is used only for data access operations or the operations
//used for interacting with the database
@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Integer> {

}
