package com.UserDetailsPOC.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.UserDetailsPOC.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query("select e from UserEntity e where e.firstName = ?1 OR e.lastName =?2")
	public List<UserEntity> findByFirstNameOrLastNameAndEmail(String fname, String lname);

	@Modifying
	@Transactional
	@Query("update UserEntity e set e.isActive=false where e.userid =?1")
	public void softDelete(Integer id);

}
