package com.UserDetailsPOC.service;

import java.util.List;

import com.UserDetailsPOC.comons.CustomException;
import com.UserDetailsPOC.dto.DynamicSeachDTO;
import com.UserDetailsPOC.entity.UserEntity;
import com.UserDetailsPOC.entity.UserMasterEntity;


public interface UserService {

	public List<UserEntity> fetchAllUsers();
	public Boolean	 saveUser(UserEntity entity);
	public Boolean modifyUserDetails(UserEntity entity, Integer userId)throws Exception ;
    public Boolean deleteUserById(Integer userId);
    public Boolean saveUserMaster(UserMasterEntity usermasterEntity);
    public List<UserEntity> fetchUserByDySearch(DynamicSeachDTO dySEntity)throws CustomException;
}
