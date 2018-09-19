package pl.coderslab.sport_book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.repository.UserRepository;


public interface UserService {

    User getByUsername(String username);

    void saveUser(User user);

    User findByMail(String email);
}
