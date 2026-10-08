package com.netaji.CrudOperation.contollers;


import com.netaji.CrudOperation.mapper.ApiResponse;
import com.netaji.CrudOperation.mapper.LoginRequest;
import com.netaji.CrudOperation.model.UserRegs;
import com.netaji.CrudOperation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CrudOperationLoginController {

    @Autowired
    LoginService loginService;

    //http:/localhost:8088/user/login
    //CREATE PROFILE
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean loginResult = loginService.LoginMethodService(loginRequest);
        if (loginResult == true) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(200);
            apiResponse.setMassage("Login successfully");
            apiResponse.setError(null);
            apiResponse.setResponse("login");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(401);
            apiResponse.setMassage("Invalid Credential");
            apiResponse.setError(null);
            apiResponse.setResponse("Invalid login");
            return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
        }
    }

    //DELETE PROFILE
    //http:/localhost:8088/user/delete/
    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable long id) {
        boolean deleteResult = loginService.DeleteMethodService(id);
        if (deleteResult == true) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(200);
            apiResponse.setMassage("Delete successfully");
            apiResponse.setError(null);
            apiResponse.setResponse("delete");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
else{
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(204);
            apiResponse.setMassage("Data not found");
            apiResponse.setError(null);
            apiResponse.setResponse("NULL");
            return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
        }

    }

}
//