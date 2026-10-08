package com.netaji.CrudOperation.contollers;


import com.netaji.CrudOperation.mapper.ApiResponse;
import com.netaji.CrudOperation.mapper.UserRequest;
import com.netaji.CrudOperation.mapper.UserResponse;
import com.netaji.CrudOperation.model.UserRegs;
import com.netaji.CrudOperation.service.UserOperationService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Crud")
public class CrudOperationContoller {

    @Autowired
    UserOperationService userOperationService;

    // http://localhost:8088/Crud/post
    @PostMapping("/post")
    public ResponseEntity<?> postUser(@RequestBody UserRequest userReq) {

        UserResponse userResponse = userOperationService.postUser(userReq);
        // System.out.println(userResponse);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(201);
        apiResponse.setMassage("Register Successfully");
        apiResponse.setError(null);
        apiResponse.setResponse(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        // return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }

    //    // http://localhost:8088/Crud/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {
        List<UserRegs> userResponse = userOperationService.getAllUser();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMassage("User get Successfully");
        apiResponse.setError(null);
        apiResponse.setResponse(userResponse);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // http://localhost:8088/Crud/1791220827482
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
        UserRegs userResponse = userOperationService.getUserById(id);
        if (userResponse != null) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(201);
            apiResponse.setMassage("user get successfully");
            apiResponse.setError(null);
            apiResponse.setResponse(userResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(204);
            apiResponse.setMassage("user get successfully");
            apiResponse.setError(null);
            apiResponse.setResponse(userResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
        }


    }
}