package com.Nahudev.user_service_apiRest.service;

import com.Nahudev.user_service_apiRest.dto.UserDTO;

public interface IUserService {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO editUser(Long id, UserDTO userDTO);

    public void deleteUser(Long id);

    public UserDTO getUser(Long id);

}
