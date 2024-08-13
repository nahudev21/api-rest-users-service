package com.Nahudev.user_service_apiRest.service;

import com.Nahudev.user_service_apiRest.dto.UserDTO;
import com.Nahudev.user_service_apiRest.exceptions.ResourceNotFoundException;
import com.Nahudev.user_service_apiRest.model.UserEntity;
import com.Nahudev.user_service_apiRest.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = mapOutUserEntity(userDTO);

        UserEntity newUser = userRepository.save(userEntity);

        return mapOutUserDTO(newUser);
    }

    @Override
    public UserDTO editUser(Long id, UserDTO userDTO) {

        UserEntity userFound = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Usuario", "id", id));

        userFound.setName(userDTO.getName());
        userFound.setLastName(userDTO.getLastName());
        userFound.setEmail(userDTO.getEmail());
        userFound.setDni(userDTO.getDni());
        userFound.setBirthdate(userDTO.getBirthdate());

        UserEntity userEdited = userRepository.save(userFound);

        return mapOutUserDTO(userEdited);
    }

    @Override
    public void deleteUser(Long id) {

        UserEntity userFound = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Usuario", "id", id));

        userRepository.delete(userFound);

    }

    @Override
    public UserDTO getUser(Long id) {

        UserEntity userFound = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Usuario", "id", id));

        return mapOutUserDTO(userFound);
    }

    private UserDTO mapOutUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    private UserEntity mapOutUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

}
