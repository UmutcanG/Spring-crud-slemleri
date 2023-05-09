package com.calisma.deneme.Service;

import com.calisma.deneme.Exception.NotFoundException;
import com.calisma.deneme.Repository.UserRepository;
import com.calisma.deneme.dto.UserCreateDTO;
import com.calisma.deneme.dto.UserUpdateDTO;
import com.calisma.deneme.dto.UserViewDTO;
import com.calisma.deneme.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserViewDTO getUserbyId(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        final User updateUser = userRepository.save(user);
        return UserViewDTO.of(updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        userRepository.deleteById(user.getId());
    }

}
