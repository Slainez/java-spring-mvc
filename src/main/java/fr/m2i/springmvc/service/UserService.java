
package fr.m2i.springmvc.service;

import fr.m2i.springmvc.exception.NotFoundException;
import fr.m2i.springmvc.model.User;
import fr.m2i.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Double getBalance() throws NotFoundException {
        User user = repo.findById(1L).orElseThrow(() -> {
            throw new NotFoundException("User with with id: 1 was not found");
        });
        return user.getBalance();
    }

    public void addBalance(Double balance) throws NotFoundException {
        User user = repo.findById(1L).orElseThrow(() -> {
            throw new NotFoundException("User with with id: 1 was not found");
        });
        user.setBalance(user.getBalance() + balance);

        repo.save(user);
    }

    public void decreaseBalance(Double balance) throws NotFoundException {
        User user = repo.findById(1L).orElseThrow(() -> {
            throw new NotFoundException("User with with id: 1 was not found");
        });
        user.setBalance(user.getBalance() - balance);

        repo.save(user);
    }
}