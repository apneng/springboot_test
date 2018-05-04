package com.ggy.springboot;

import java.util.UUID;

public class CreateUUID {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        }
    }
}
