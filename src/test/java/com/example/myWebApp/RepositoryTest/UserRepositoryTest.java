package com.example.myWebApp.RepositoryTest;

import com.example.myWebApp.Model.User;
import com.example.myWebApp.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("chottu.pandey@gmail.com");
        user.setPassword("chottu@1234");
        user.setFirstName("Chottu");
        user.setLastName("Pandey");
        user.setEnabled(true);

        userRepository.save(user);
    }

    @Test
    public void testListAll() {
        Iterable<User> iterable = userRepository.findAll();

        for(User user : iterable) {
            System.out.println(user);
        }
    }

    @Test
    public void testById() {
        Integer userid = 1;
        System.out.println(userRepository.findById(userid));
    }
}
