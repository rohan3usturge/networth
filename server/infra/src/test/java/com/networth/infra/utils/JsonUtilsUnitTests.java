package com.networth.infra.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.networth.infra.exception.ErrorItem;

import org.junit.Test;

public class JsonUtilsUnitTests {

    private static class ClassThatJacksonCannotSerialize {
        private final ClassThatJacksonCannotSerialize self = this;

        @Override
        public String toString() {
            return self.getClass().getName();
        }
    }

    @Test
    public void shouldJsonUtilsWorkCorrectly() {

        String code = "Dummy Code";
        String message = "Dummy message";

        ErrorItem dummy = new ErrorItem();
        dummy.setCode(code);
        dummy.setMessage(message);

        String json = JsonUtils.toJson(dummy);
        ErrorItem fromJson = JsonUtils.fromJson(json, ErrorItem.class);

        assertEquals(code, fromJson.getCode());
        assertEquals(message, fromJson.getMessage());

    }

    @Test
    public void shouldReturnNullIfException() throws JsonProcessingException {
        String json = JsonUtils.toJson(new ClassThatJacksonCannotSerialize());
        assertEquals(null, json);
    }

    @Test
    public void shouldReturnNullIfFromJsonException() throws JsonProcessingException {
        Integer json = JsonUtils.fromJson("{", Integer.class);
        assertEquals(null, json);
    }

}
