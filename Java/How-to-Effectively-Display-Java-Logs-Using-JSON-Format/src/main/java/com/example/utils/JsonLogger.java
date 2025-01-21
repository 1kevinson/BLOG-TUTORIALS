package com.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JsonLogger {

        private JsonLogger() {
            throw new IllegalStateException("Utility class");
        }

        public static void info(String message, Object pojo) {
            log.info("\n\n--- {} ---\n{} \n", message, pojoToJson(pojo));
        }

        private static String pojoToJson(Object pojo) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
            } catch (JsonProcessingException exception) {
                throw new RuntimeException(exception);
            }
        }
}