package net.kuleasycode.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.kuleasycode.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String>{
	
	@Query(value = "SELECT * from role_entity "
			+ "inner join user_role ON role_entity.role_id = user_role.role_id "
			+ "inner join user_entity on user_role.user_name = :userName", nativeQuery = true)
	Set<RoleEntity> findByUserName(@Param("userName") String userName);
}
