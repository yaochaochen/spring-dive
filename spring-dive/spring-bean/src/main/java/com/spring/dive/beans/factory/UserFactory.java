package com.spring.dive.beans.factory;

import com.spring.dive.dependency.domain.User;

public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
