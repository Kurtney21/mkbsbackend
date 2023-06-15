package com.mattkhaibeautysalon.www.MattKhaiBackend.factory;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.User;

public class UserFactory {

    public static User createUser(String name, String email, String phone) {
        return User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .build();
    }
}
