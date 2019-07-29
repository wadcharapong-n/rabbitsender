package com.example.rabbit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class UserProfile implements Serializable {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
}
