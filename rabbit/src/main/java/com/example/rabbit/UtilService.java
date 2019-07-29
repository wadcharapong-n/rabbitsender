package com.example.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilService {

    public static String convertJson(Object userProfile){
        CustomObjectMapper mapper = new CustomObjectMapper();
        String result = null;
        try{
            result = mapper.writeValueAsString(userProfile);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
