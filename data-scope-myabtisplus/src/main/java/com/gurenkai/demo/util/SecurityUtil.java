package com.gurenkai.demo.util;

import com.gurenkai.demo.entity.User;

public class SecurityUtil {

    private static final ThreadLocal<User> LOCAL_LOGIN_USER = new ThreadLocal<>();

    public static void setLoginUser(User user) {
        LOCAL_LOGIN_USER.set(user);
    }

    public static User getLoginUser() {
        return LOCAL_LOGIN_USER.get();
    }

}
