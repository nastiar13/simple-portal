package dev.nastiar.portal.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.nastiar.portal.jwt.JwtService;
import dev.nastiar.portal.user.dto.UserDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @ExceptionHandler
    public List<UserDto> getUsers(String token) {
        String email = jwtService.extractUsername(token.substring(7));
        User user = userRepository.findByEmail(email).orElse(null);

        if (user != null && user.getRole() == Role.ADMIN) {
            Iterable<User> users = userRepository.findAll();

            return StreamSupport.stream(users.spliterator(), false)
                    .map(this::convertUserDto)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    public UserDto convertUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFullname(user.getFullName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());

        return userDto;
    }

}
