package com.goldenlibrary.mgtsystem.repositories;

import com.goldenlibrary.mgtsystem.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
    @Override
    void delete(User deleted);    
}