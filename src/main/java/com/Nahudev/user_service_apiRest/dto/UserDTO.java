package com.Nahudev.user_service_apiRest.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String dni;

    private Date birthdate;

}
