package com.flight.admin.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.admin.entity.UserLoginEntity;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity,Long>{

	/*@Query(value="Select u.user_Name,u.password from user_details u where u.userId = :userId",nativeQuery=true)
	List<UserLoginEntity> findByUserID(@Param("userId") long userId);*/

	@Query
	Optional<UserLoginEntity> findByUserName(String userName);
}
