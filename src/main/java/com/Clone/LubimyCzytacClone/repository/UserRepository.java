package com.Clone.LubimyCzytacClone.repository;

import com.Clone.LubimyCzytacClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(@Param("id") Long id);

    @Query("SELECT u FROM User u WHERE u.login = :login OR u.email = :email")
    User getUserByLoginAndEmail(@Param("login") String login, @Param("email") String email);
}
