package com.worldvistaGestion.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldvistaGestion.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>  {


}

