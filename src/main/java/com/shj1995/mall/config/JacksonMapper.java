package com.shj1995.mall.config;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JacksonMapper extends ObjectMapper {

    private static final LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));
    private static final LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));

    public JacksonMapper() {
        super();
        this.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        this.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(LocalDateTime.class, localDateTimeSerializer);
        simpleModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        registerModule(simpleModule);
    }
}
