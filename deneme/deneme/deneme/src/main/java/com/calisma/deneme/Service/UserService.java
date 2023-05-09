package com.calisma.deneme.Service;

import com.calisma.deneme.dto.UserCreateDTO;
import com.calisma.deneme.dto.UserUpdateDTO;
import com.calisma.deneme.dto.UserViewDTO;
import com.calisma.deneme.model.User;

import java.util.List;

public interface UserService {
    UserViewDTO getUserbyId(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getUsers();

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);
}
