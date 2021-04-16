package net.kuleasycode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.kuleasycode.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	@Query(value = "SELECT us FROM UserEntity us WHERE us.userName = :userName AND us.enabled = true")
	public UserEntity findByUserNameAndEnabled(@Param("userName") String userName);
}
