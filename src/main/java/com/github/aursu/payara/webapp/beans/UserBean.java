package com.github.aursu.payara.webapp.beans;

import com.github.aursu.payara.webapp.data.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named
public class UserBean implements Serializable {
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String sayHello() {
        return "hello";
    }

    public String getAdvice() {
        if (user.getAge() < 17) return "Go to school.";
        if (user.getAge() < 23) return "Go to university.";
        if (user.getAge() < 60) return "Work hard!";
        return "Have fun!";
    }
}
