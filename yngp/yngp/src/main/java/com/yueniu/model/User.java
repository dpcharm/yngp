package com.yueniu.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String userName;
    private String passwd;
    private String centralToken;
}
