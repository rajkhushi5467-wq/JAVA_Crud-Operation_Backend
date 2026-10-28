package com.netaji.CrudOperation.service;

import com.netaji.CrudOperation.mapper.LoginRequest;
import com.netaji.CrudOperation.mapper.UserRequest;
import com.netaji.CrudOperation.mapper.UserResponse;
import com.netaji.CrudOperation.model.UserRegs;
import com.netaji.CrudOperation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class LoginService {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = currentDateTime.format(formatter);

    @Autowired
    UserOperationService userOperationService;
    @Autowired
    UserRepository userRepository;


    public boolean LoginMethodService (LoginRequest loginRequest){
        // Login request form data
        long id = loginRequest.getId();
        String pwd = loginRequest.getPassword();

        //Database store login data
        UserRegs userResponse = userOperationService.getUserById(id);
        if(userResponse != null){
            if (id == userResponse.getId() && pwd.equals(userResponse.getPassword())) {
                return true;
            }else{
                return false;
            }
        }else {
        return false;

        }
    }

    //Delete profilr service method
    public boolean DeleteMethodService(long id){
        UserRegs userResponse = userOperationService.getUserById(id);

        if(userResponse != null){
            UserRegs userRegs = userResponse;
            if(userRegs.isStatus() == true){
                userRegs.setStatus(false);
                userRegs.setDeleteDate(dateString);
                //System.out.println(userRegs);
                userRepository.save(userRegs);
                return true;
            }
            else{
                return false;
            }

        }else{
            return false;
        }
    }
    //Update profile
    // Update profile
    public UserResponse updateUserService(UserRequest userRequest, long id) {
        UserRegs idUser = userOperationService.getUserById(id);
        UserResponse user = new UserResponse();
        if(idUser != null){
            user.setEmail(userRequest.getEmail());
            user.setId(idUser.getId());
            user.setName(userRequest.getName());
            user.setPassword(userRequest.getPassword());
            user.setMobileNo(userRequest.getMobileNo());
            //
            UserRegs user1= new UserRegs();
            user1.setId(idUser.getId());
            user1.setName(userRequest.getName());
            user1.setEmail(userRequest.getEmail());
            user1.setMobileNo(userRequest.getMobileNo());
            user1.setPassword(userRequest.getPassword());
            user1.setCreatedDate(idUser.getCreatedDate());
            user1.setModifiedDate(dateString);
            user1.setDeleteDate(null);
            user1.setStatus(true);

            userRepository.save(user1);
            //
        }
        else{
            return null;
        }


        return user;
    }

}
//  "id": 1791394167804,,khuc
//  "id": 1791394701073,,rakhi