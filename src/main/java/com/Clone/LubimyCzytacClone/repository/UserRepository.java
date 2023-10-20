package com.Clone.LubimyCzytacClone.repository;

import com.Clone.LubimyCzytacClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
