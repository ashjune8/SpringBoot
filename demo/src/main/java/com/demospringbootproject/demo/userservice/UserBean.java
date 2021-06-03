package com.demospringbootproject.demo.userservice;

import javax.validation.constraints.Size;

public class UserBean {

    private Integer id;

    @Size(min=2)
    private String name;


    public UserBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    

    

    
}
