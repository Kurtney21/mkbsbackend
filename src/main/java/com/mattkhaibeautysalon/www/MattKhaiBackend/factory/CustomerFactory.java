package com.mattkhaibeautysalon.www.MattKhaiBackend.factory;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Customer;
import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.User;

public class CustomerFactory {

    public static Customer createCustomer(Long id, User user) {
        return Customer.builder()
                .id(id)
                .user(user)
                .build();
    }

}
