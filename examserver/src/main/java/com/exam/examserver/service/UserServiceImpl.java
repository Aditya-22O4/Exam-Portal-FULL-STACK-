package com.exam.examserver.service;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService

{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = userRepository.findByUserName(user.getUserName());

        if (local != null) {
            System.out.println("User already Exist");
            throw new Exception("User already Present");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRole().addAll(userRoles);
            local = userRepository.save(user);
        }
        return local;
    }
    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }
    @Override
    public void deleteUser(long id) {
        System.out.println("deleted one");
        userRepository.deleteById(id);
    }

}
