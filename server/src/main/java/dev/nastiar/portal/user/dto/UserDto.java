package dev.nastiar.portal.user.dto;

import dev.nastiar.portal.user.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String fullname;

    private String email;

    private Role role;
}
