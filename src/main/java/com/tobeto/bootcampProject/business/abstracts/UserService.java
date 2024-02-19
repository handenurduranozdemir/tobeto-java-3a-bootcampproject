package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.entities.User;
import com.tobeto.bootcampProject.business.responses.get.GetAllUsersResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    List<GetAllUsersResponse> getAllUsersResponse();
}

