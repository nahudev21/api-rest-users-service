package com.Nahudev.user_service_apiRest.controller;

import com.Nahudev.user_service_apiRest.dto.UserDTO;
import com.Nahudev.user_service_apiRest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        if (userDTO != null) {
            return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDTO> editUser(@PathVariable(name = "id") Long id,
                                            @RequestBody UserDTO userDTO) {
        if (userDTO != null) {
            return new ResponseEntity<>(userService.editUser(id, userDTO), HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado exitosamente!", HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

}
