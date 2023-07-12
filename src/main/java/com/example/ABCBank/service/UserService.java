package com.example.ABCBank.service;

import com.example.ABCBank.Repositories.UserRepository;
import com.example.ABCBank.model.User;
import com.example.ABCBank.model.dto.UserCreationDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createFromDto(UserCreationDto userCreationDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.map(userCreationDto, user);
        user.setPassword(passwordEncoder.encode(userCreationDto.getPassword()));

        return userRepository.save(user);

    }

    public User findUserByEmail(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new EntityNotFoundException("User not exist"));
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByID(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public String deleteUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));

        userRepository.delete(user);

        return "User with ID : " + id + " deleted";
    }

    public User updateUser(Long id, User user){
        User user1 = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setEmail(user.getEmail());


        return userRepository.save(user1);
    }

}
