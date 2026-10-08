package com.Smart_Home.user_service.service;

import com.Smart_Home.user_service.dto.UserDto;
import com.Smart_Home.user_service.entity.User;
import com.Smart_Home.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserDto createUser(UserDto userDto){
               final User createUser=User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .altering(userDto.isAlerting())
                .energyAlertingThreshold(userDto.getEnergyAlertingThreshold())
                .build();

       final User saved=userRepository.save(createUser);
        return toDto(saved);
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .address(user.getAddress())
                .alerting(user.isAltering())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();
    }

    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public void updateUser(Long id, UserDto userDto) {

        User user=userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("User not found"));

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setAltering(userDto.isAlerting());
        user.setEnergyAlertingThreshold(userDto.getEnergyAlertingThreshold());

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("User not found"));
            userRepository.delete(user);
    }
}
