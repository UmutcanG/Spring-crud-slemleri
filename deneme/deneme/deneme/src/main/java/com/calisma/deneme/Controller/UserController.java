package com.calisma.deneme.Controller;

import com.calisma.deneme.Service.UserService;
import com.calisma.deneme.dto.UserCreateDTO;
import com.calisma.deneme.dto.UserUpdateDTO;
import com.calisma.deneme.dto.UserViewDTO;
import com.calisma.deneme.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("user/{id}")
    public ResponseEntity<UserViewDTO> getUserbyId(@PathVariable long id) {
        final UserViewDTO user = userService.getUserbyId(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("user")
    public ResponseEntity<List<UserViewDTO>> getUsers() {
        final List<UserViewDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }
    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id")Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted."));
    }
}
