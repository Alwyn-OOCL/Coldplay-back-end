package com.oocl.coldplay.common.model.user;

public class UserHolder {
    private static final ThreadLocal<UserDTO> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        USER_THREAD_LOCAL.set(user);
    }

    public static UserDTO getUser(){
        return USER_THREAD_LOCAL.get();
    }

    public static void removeUser(){
        USER_THREAD_LOCAL.remove();
    }
}
