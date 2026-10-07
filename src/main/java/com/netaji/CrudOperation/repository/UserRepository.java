package com.netaji.CrudOperation.repository;

import com.netaji.CrudOperation.model.UserRegs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegs, Long> {

}
