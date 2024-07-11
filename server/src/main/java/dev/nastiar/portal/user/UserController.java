package dev.nastiar.portal.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nastiar.portal.jwt.JwtService;
import dev.nastiar.portal.user.dto.UserDto;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin("http://localhost:3030")
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers(@RequestHeader("Authorization") String token) {
        return userService.getUsers(token);
    }

    @PostMapping("/id")
    public ResponseEntity<String> getMethodName(@RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.substring(7));
        System.out.println(username);
        return ResponseEntity.ok().body(username);
    }

}
