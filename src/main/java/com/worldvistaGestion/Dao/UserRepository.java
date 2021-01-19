package com.worldvistaGestion.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.worldvista.Gestion.Pojo.fullUser;
import com.worldvistaGestion.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>  {

	@Query("select NEW com.worldvista.Gestion.Pojo.fullUser(c.idUser , u.nomUser , u.prenomUser , u.emailUser , c.password , c.statutCompte , c.situationCompte) from Compte c , User u where c.idUser =: x and u.idUser =:x")
	Iterable<fullUser> fullUserInfos(@Param("x") Long idUser);


}

