package com.UserDetailsPOC.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.UserDetailsPOC.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Serializable>
{
	
	@Query("select e from UserEntity e where e.firstName = ?1 OR e.lastName =?2  AND e.email=?3" )
	public List<UserEntity> findByFnameOrLastNameAndEmail(String fname, String lname,String email);

	/*
	 * @Query("select e from UserEntity e where e.firstName like :fname% OR e.lastName like :lname%"
	 * ) public List<UserEntity> findByFnameOrLastName(String fname, String lname);
	 */

	@Modifying
	@Transactional
	@Query("update UserEntity e set e.isActive=false where e.userid =?1")
	public void softDelete(Integer id);

}
