package com.netaji.CrudOperation.service;
import com.netaji.CrudOperation.mapper.UserRequest;
import com.netaji.CrudOperation.mapper.UserResponse;
import com.netaji.CrudOperation.model.UserRegs;
import com.netaji.CrudOperation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserOperationService {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = currentDateTime.format(formatter);

    @Autowired
    UserRepository userRepository;
    public UserResponse postUser(UserRequest userRequest){
// UserRequest userRequest = userOperationService.postUser(userReq);
        UserResponse user = new UserResponse();
        user.setEmail(userRequest.getEmail());
        user.setId(System.currentTimeMillis());
        user.setName(userRequest.getName());
        user.setMobileNo(userRequest.getMobileNo());
        user.setPassword(userRequest.getPassword());
        //
        UserRegs user1 = new UserRegs();
        user1.setId(System.currentTimeMillis());
        user1.setName(userRequest.getName());
        user1.setEmail(userRequest.getEmail());
        user1.setMobileNo(userRequest.getMobileNo());
        user1.setPassword(userRequest.getPassword());
        user1.setCreatedDate(dateString);
        user1.setModifiedDate(dateString);
        user1.setDeleteDate(null);
        user1.setStatus(true);

        userRepository.save(user1);

        //
        return user;
    }

    public List<UserRegs>  getAllUser() {
        List<UserRegs> getAllUsers = userRepository.findAll();
        return getAllUsers;
    }

    public  Optional<UserRegs> getUserById(long id) {
        Optional<UserRegs> getUserById =userRepository.findById(id);
        return getUserById;
    }
}
