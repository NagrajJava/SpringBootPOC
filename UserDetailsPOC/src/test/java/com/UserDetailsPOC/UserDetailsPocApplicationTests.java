
  package com.UserDetailsPOC;
  
  import static org.junit.jupiter.api.Assertions.assertEquals; import static
  org.junit.jupiter.api.Assertions.assertFalse; import static
  org.junit.jupiter.api.Assertions.assertTrue;
  
  import java.util.ArrayList; import java.util.List;
  
  import org.junit.jupiter.api.BeforeEach; import
  org.junit.jupiter.api.DisplayName; import org.junit.jupiter.api.Nested;
  import org.junit.jupiter.api.Test; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.context.SpringBootTest;
  
  import com.UserDetailsPOC.dto.DynamicSeachDTO; import
  com.UserDetailsPOC.entity.UserEntity; import
  com.UserDetailsPOC.entity.UserMasterEntity; import
  com.UserDetailsPOC.service.UserService;
  
  
  @SpringBootTest
  
  @DisplayName("UserService test") class UserDetailsPocApplicationTests {
  
  @Autowired private UserService userService; UserEntity userEntity = null;
  
  List<UserEntity> list = null;
  
  UserMasterEntity usermasterEntity = null; DynamicSeachDTO searchDto = null;
  
  @Nested
  
  @DisplayName("Proper UserDetails") class UserDetailsInfo {
  
  @BeforeEach void init() { try {
  
  list = new ArrayList<UserEntity>(); list.add(new
  UserEntity(1,"Nag","raj","nagraj@gmail.com",9000767789L)); list.add(new
  UserEntity(2,"Nag","raj","nagraj@gmail.com",9000767789L)); list.add(new
  UserEntity(3,"Nag","raj","nagraj@gmail.com",9000767789L)); list.add(new
  UserEntity(4,"Nag","raj","nagraj@gmail.com",9000767789L));
  
  
  userEntity.setFirstName("Nagraj"); userEntity.setLastName("Raj");
  userEntity.setActive(true);
  
  usermasterEntity.setUserName("Nagraj"); usermasterEntity.setIsActive(true);
  usermasterEntity.setPassword("Nag123");
  
  searchDto.setEmail("nagraj@gmail.com"); searchDto.setFirstName("nagraj");
  searchDto.setLastName("raj"); searchDto.setPincode(400108);
  
  } catch (Exception e) { e.printStackTrace(); }
  
  }
  
  @Nested
  
  @DisplayName("Checkfor Fetching Users") class ChekingfortheVersion {
  
  @Test
  
  @DisplayName("when users are Present") void CheckFetchUsers() {
  List<UserEntity> checklist = userService.fetchAllUsers(); assertEquals(2,
  checklist.size()); }
  
  @Test
  
  @DisplayName(" fetching users or not found") void CheckFetchUsersNotFound() {
  List<UserEntity> list = userService.fetchAllUsers();
  assertFalse(list.isEmpty()); }
  
  }
  
  @Nested
  
  @DisplayName(" Saving User details ") class WhenUserDetailsProper {
  
  @Test
  
  @DisplayName("when User data is present") void dataisproper() {
  assertTrue(userService.saveUser(userEntity)); }
  
  @Test
  
  @DisplayName(" then data UserDetails is  null") void dataisNotproper() {
  userEntity.setFirstName(""); assertFalse(userService.saveUser(userEntity));
  
  }
  
  }
  
  @Nested
  
  @DisplayName(" Modefying the data ") class Modefyingtheuserdata {
  
  @Test
  
  @DisplayName("when data is present") void dataispresent() { int userId = 2;
  assert(userService.UpdateUserDetails(userEntity, userId)); }
  
  @Test
  
  @DisplayName("when User data is not present") void
  dataispresentIsNotPresent() { int userId = 0;
  assert(userService.UpdateUserDetails(userEntity, userId));
  
  }
  
  }
  
  @Nested
  
  @DisplayName(" Deleting the Userdata by Id ") class DeleteByIdcheck {
  
  @Test
  
  @DisplayName("when Id is present") void dataispresent() { int userId = 2;
  assert(userService.deleteUserById(userId)); }
  
  @Test
  
  @DisplayName("when UserId is null") void dataispresentIsNotPresent() { int
  userId = 0; assert(userService.deleteUserById(userId));
  
  }
  
  }
  
  @Nested
  
  @DisplayName(" Saving UserMaster details ") class WhenUserMasterDetailsProper
  {
  
  @Test
  
  @DisplayName("when UserMasterdata is present") void dataisproper() {
  assertTrue(userService.saveUserMaster(usermasterEntity)); }
  
  @Test
  
  @DisplayName("when UserMasterDetails Not Proper") void dataisNotproper() {
  userEntity.setFirstName(null);
  assertTrue(userService.saveUserMaster(usermasterEntity));
  
  }
  
  }
  
  @Nested
  
  @DisplayName(" Search User details By Name ") class SearchByName {
  
  @Test
  
  @DisplayName("when Search  is Success") void whenSearchInfoFind() {
  List<UserEntity> list = userService.fetchUserByDySearch(searchDto);
  assert(!list.isEmpty()); }
  
  @Test
  
  @DisplayName("when Search is Not Success") void whenSearchInfoNotFind() {
  searchDto.setFirstName(null); searchDto.setLastName(null); List<UserEntity>
  list = userService.fetchUserByDySearch(searchDto); assert(list.isEmpty());
  
  }
  
  } }
  
  
  }
 