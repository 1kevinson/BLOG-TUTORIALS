package com.example.demo.example.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordManager {

     public static String encrypt(String password){
         // Add some Hashing Logic here
         return password.concat("HASHED");
     }
}
