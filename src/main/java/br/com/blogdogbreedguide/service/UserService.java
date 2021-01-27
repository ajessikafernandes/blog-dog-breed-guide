package br.com.blogdogbreedguide.service;

import br.com.blogdogbreedguide.entity.User;
import br.com.blogdogbreedguide.exceptions.PostCannotBeNullException;
import br.com.blogdogbreedguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public boolean createNewUser(User user) {
        validateNotNull(user);
        repository.save(user);
        return true;
    }

    private Boolean validateNotNull(User user) {
        if (Objects.isNull(user)) {
            throw new PostCannotBeNullException("Post cannot be null");
        }
        return true;
    }
}
