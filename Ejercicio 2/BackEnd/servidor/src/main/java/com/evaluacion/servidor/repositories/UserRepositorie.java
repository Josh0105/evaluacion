package com.evaluacion.servidor.repositories;

//import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends CrudRepository<UserModel,Long>{
    abstract UserModel findByUsername(String username);
}
