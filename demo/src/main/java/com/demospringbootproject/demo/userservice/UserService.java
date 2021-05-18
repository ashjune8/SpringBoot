package com.demospringbootproject.demo.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private ArrayList<UserBean> userList = new ArrayList<>();
    private int userCount = 2;


    public UserService() {
        this.userList.add(new UserBean(1, "Sam"));
        this.userList.add(new UserBean(2, "Bam"));
    }

    public UserBean getUser(Integer id){

        for(int i =0; i < this.userList.size(); i++){
            if(id == this.userList.get(i).getId()){
                return this.userList.get(i);
            }
        }

        return null;
        

    }

    public ArrayList<UserBean> getAllUsers(){

        return this.userList;
    }



    public void createUser(UserBean user){

        if(user.getId() == null){
            user.setId(userCount += 1);

        }
        this.userList.add(user);

        

    }
    
}
