package pl.britenet.campusspringjune.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campusspringjune.model.AuthenticationResponse;
import pl.britenet.campusspringjune.model.Credentials;
import pl.britenet.consoleapp.obj.model.User;
import pl.britenet.consoleapp.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final Map<String, User> authenticatedUsersMap;
    private final UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
        this.authenticatedUsersMap = new HashMap<>();
    }

    public AuthenticationResponse authenticate(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        User user = this.userService.getUserByCredentials(username, password).orElseThrow();

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        this.authenticatedUsersMap.put(token, user);

        return new AuthenticationResponse(token, user.getId());
    }

}
