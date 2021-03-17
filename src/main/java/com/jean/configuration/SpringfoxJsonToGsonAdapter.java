package com.jean.configuration;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

public class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json src, Type typeOfSrc, JsonSerializationContext context) {
        return JsonParser.parseString(src.value());
    }
}