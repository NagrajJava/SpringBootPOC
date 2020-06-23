package com.UserDetailsPOC.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserDetailsPOC.comons.CustomException;
import com.UserDetailsPOC.constants.Constants;
import com.UserDetailsPOC.dao.UserMasterRepository;
import com.UserDetailsPOC.dao.UserRepository;
import com.UserDetailsPOC.dto.DynamicSeachDTO;
import com.UserDetailsPOC.dto.ResponseDTO;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserMasterRepository userasterRepo;

	private UserMasterEntity urMasterEntity;

	/**
	 * Fetching All Users
	 *
	 * @return message
	 */
	public List<UserEntity> fetchAllUsers() {
		logger.info("inside FetchAllUsers method");
		List<UserEntity> usersList = (List<UserEntity>) repo.findAll();
		return usersList;
	}

	/**
	 * save UserMaster
	 * 
	 * @return message
	 */
	public Boolean saveUserMaster(UserMasterEntity usermasterEntity) {
		logger.info("inside saveUserMaster method");
		if (usermasterEntity.getUserName() != null) {
			urMasterEntity = userasterRepo.save(usermasterEntity);
			return Boolean.TRUE;

		}
		return Boolean.FALSE;
	}

	/**
	 * saving UserInfo
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public Boolean saveUser(UserEntity entity) {
		logger.info("inside saveUser method");
		if (entity.getFirstName() != null) {
			entity.setUserMasterEntity(urMasterEntity);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Updating Particular User by UserId
	 * 
	 * @return message
	 */
	public Boolean modifyUserDetails(UserEntity entity, Integer userId) {
		if (userId != null) {
			Optional<UserEntity> updateEntity = repo.findById(userId);
			entity.setUserid(userId);
			entity.setUserMasterEntity(updateEntity.get().getUserMasterEntity());
			repo.save(entity);

			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	/**
	 * deleting the user by id
	 * 
	 * @param Integer Representative Id
	 * @return message
	 */
	public Boolean deleteUserById(Integer userId) {
		if (userId != null) {
			repo.deleteById(userId);
			repo.softDelete(userId);
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public List<UserEntity> fetchUserByDySearch(DynamicSeachDTO searchEntity) throws CustomException {

		List<UserEntity> usersList = repo.findByFnameOrLastNameAndEmail(searchEntity.getFirstName(),
				searchEntity.getLastName(), searchEntity.getEmail());
		return usersList;

	}

}
