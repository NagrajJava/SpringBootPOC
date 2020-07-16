package com.UserDetailsPOC.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserDetailsPOC.dao.UserMasterRepository;
import com.UserDetailsPOC.dao.UserRepository;
import com.UserDetailsPOC.dto.DynamicSeachDTO;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private UserMasterRepository usermasterRepo;

	private UserMasterEntity userMaster = new UserMasterEntity();
	/**
	 * Fetching All Users
	 *
	 * @return message
	 */
	public List<UserEntity> fetchAllUsers() {
		logger.info("inside FetchAllUsers method");
		List<UserEntity> usersList = (List<UserEntity>) userrepo.findAll();
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
			usermasterRepo.save(usermasterEntity);
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
	@Transactional
	public Boolean saveUser(UserEntity entity) {
		logger.info("inside saveUser method");
		if (entity.getFirstName() != null) {
			//entity.setUserMasterEntity(userMaster);
			userrepo.save(entity);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Updating Particular User by UserId
	 * 
	 * @return Boolean
	 */
	public Boolean UpdateUserDetails(UserEntity entity, Integer userId) {
		
		if (userId != null) {
			//Optional<UserEntity> updateEntity = userrepo.findById(userId);
			//updateEntity.get().setUserid(1);
			//userrepo.save(entity);
			UserEntity updateEntity = new UserEntity();
			Optional<UserEntity> updateEntity2 =null;
			updateEntity2=userrepo.findById(userId);
			updateEntity=updateEntity2.get();
			System.out.println(" jj ----"+updateEntity);
			userMaster=updateEntity.getUserMasterEntity();
			if(userId!=null) {
			entity.setUserid(userId);
			entity.setUserMasterEntity(userMaster);//entity set
			updateEntity = userrepo.save(entity);
			return Boolean.TRUE;
			}
			
		}

		return Boolean.FALSE;
	}

	/**
	 * deleting the user by id
	 * 
	 * @return Boolean
	 */
	public Boolean deleteUserById(Integer userId) {
		if (userId != null) {
			userrepo.deleteById(userId);
			userrepo.softDelete(userId);
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}



	/**
	 * fetch the user by First name or LastName
	 * 
	 * @return List<UserEntity>
	 */
	
	  public List<UserEntity> fetchUserByDySearch(DynamicSeachDTO searchEntity) {
	  
	  List<UserEntity> usersList =
	  userrepo.findByFirstNameOrLastNameAndEmail(searchEntity.getFirstName(), searchEntity.getLastName()); 
	  return usersList;
	  
	  }
	 

}
