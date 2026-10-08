package com.netaji.CrudOperation.service;

import com.netaji.CrudOperation.mapper.LoginRequest;
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
        /*if(userResponse.isPresent()) {
            UserRegs userRegs = userResponse.get();
            if(userRegs.isStatus()==false){
                return false;
            }
            else{
                if (id == userResponse.get().getId() && pwd.equals(userResponse.get().getPassword())) {
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }*/

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


}
//  "id": 1791394167804,,khuc
//  "id": 1791394701073,,rakhi