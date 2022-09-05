package com.example.myWebApp.Service;

import com.example.myWebApp.Exception.UserNotFoundException;
import com.example.myWebApp.Model.User;
import com.example.myWebApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent())
            return result.get();
        throw new UserNotFoundException("Could not found any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if(count == null || count == 0)
            throw new UserNotFoundException("Could not found any users with ID " + id);
        userRepository.deleteById(id);
    }
}
