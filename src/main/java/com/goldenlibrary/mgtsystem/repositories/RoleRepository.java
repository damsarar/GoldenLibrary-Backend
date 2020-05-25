package com.goldenlibrary.mgtsystem.repositories;

import java.util.Optional;

import com.goldenlibrary.mgtsystem.models.Erole;
import com.goldenlibrary.mgtsystem.models.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(Erole name);

}