package com.example.kidzcashfinal;

import java.util.UUID;

public class User {
    public UUID uuid;
    public String name;
    public String email;
    public String password;
    public int balance;

    public User(UUID uuid, String name,String email,String password,int balance)
    {
        this.uuid=uuid; this.name = name; this.email=email; this.password=password;
        this.balance=balance;
    }



}
