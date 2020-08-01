package com.powerschool.converter.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Parser {
    public static JsonElement parse(String data){
        JsonParser parser = new JsonParser();
        return parser.parse(data);
    }
}
