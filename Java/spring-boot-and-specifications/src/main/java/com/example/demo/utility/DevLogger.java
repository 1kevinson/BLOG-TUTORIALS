package com.example.demo.utility;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DevLogger {

    private DevLogger() {}

    /**
     * This method prints a class log. It first prints a message, followed by the state of an object.
     *
     * @param message A string representing the message to be printed before the object state.
     * @param pojo    An object for which the state has to be printed.
     */
    public static void printClassLog(String info, Object pojo) {
        System.out.printf("%n%s ", info);
        System.out.printf("-------------------------------%n");
        log(pojo);
    }

    private static void log(Object pojo) {
        try {
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pojo));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}