/*
 * package com.mongo;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertFalse; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import org.junit.jupiter.api.BeforeEach; import
 * org.junit.jupiter.api.DisplayName; import org.junit.jupiter.api.Nested;
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.mongo.dto.SearchDTO; import com.mongo.model.Address; import
 * com.mongo.model.Education; import com.mongo.model.User; import
 * com.mongo.model.UserDetails; import com.mongo.service.UserService;
 * 
 * @SpringBootTest class MongoApplicationTests {
 * 
 * @Autowired private UserService userservice;
 * 
 * private SearchDTO searchDTO;
 * 
 * User user = null; Address address = null; Address address1 = null;
 * List<Address> listofaddress = null; Education education = null; UserDetails
 * userdetails = null;
 * 
 * @Nested
 * 
 * @DisplayName("Proper UserDetails") class UserInfoforTesting {
 * 
 * @BeforeEach void init() { try { searchDTO = new SearchDTO(); listofaddress =
 * new ArrayList<Address>(); education = new Education(); address = new
 * Address(); address1 = new Address(); education.setBranch("MEC");
 * education.setCollege("KMIT"); education.setEid("6");
 * education.setSchool("Kendriya"); address.setAid("6");
 * address.setCityName("Hyderabad"); address.setHouseNo("4-5");
 * address.setStreetName("chandanagar"); address.setPinCode(5076165);
 * address1.setAid("6"); address1.setCityName("Hyderabad");
 * address1.setHouseNo("4-5"); address1.setStreetName("chandanagar");
 * address1.setPinCode(5076165);
 * 
 * 
 * listofaddress.add( , new Address("7", "6-5", "kammuru1", "malad2", 507166) );
 * 
 * userdetails = new UserDetails(); userdetails.setMasterId("6");
 * userdetails.setUserName("Nagraj"); userdetails.setIsActive(true);
 * userdetails.setPassword("Nag123"); userdetails.setAddress(listofaddress);
 * userdetails.setEducation(education);
 * 
 * user = new User(); user.setUserid("7"); user.setFirstName("Nagraj");
 * user.setLastName("Raj"); user.setIsActive(true); user.setCreateddate(new
 * Date()); user.setUpdateddate(new Date());
 * user.setEmailId("nagraj@gmail.com"); user.setMobileNo("9000765561");
 * user.setUserDetails(userdetails);
 * 
 * searchDTO.setEmailId("nagraj@gmail.com"); searchDTO.setFirstName("Kiran");
 * searchDTO.setLastName("raj");
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Checkfor saving Users") class ChekingsavingUsers {
 * 
 * @Test
 * 
 * @DisplayName("when users data   Present") void saveUsers() {
 * assertTrue(userservice.saveUser(user));
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName(" fetching users or not found") void CheckFetchUsersNotFound() {
 * 
 * assertFalse(userservice.saveUser(user)); }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Checkfor saving Usersaddres") class ChekingsavingUsersaddress {
 * 
 * @Test
 * 
 * @DisplayName("when users data   Present") void saveUsersaddress() { Boolean
 * actual = userservice.saveUseraddress(address); Boolean expected = true;
 * assertEquals(expected, actual);
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName(" fetching users or not found") void CheckaddressNotproepr() {
 * Boolean actual = userservice.saveUseraddress(address); Boolean expected =
 * false; assertEquals(expected, actual); }
 * 
 * @Nested
 * 
 * @DisplayName("Checkfor saving UsersEducation") class
 * ChekingsavingUserseduaction {
 * 
 * @Test
 * 
 * @DisplayName("when users education data  Present") void saveUsersaddress() {
 * Boolean actual = userservice.saveUsereducation(education); Boolean expected =
 * true; assertEquals(expected, actual);
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName(" fetching users education data  not found") void
 * CheckeducationdataNotproepr() { Boolean actual =
 * userservice.saveUsereducation(education); Boolean expected = false;
 * assertEquals(expected, actual); }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName(" Saving Userdetails ") class SavingUserDetails {
 * 
 * @Test
 * 
 * @DisplayName("when Userdetails is present") void userdataisproper() {
 * assertTrue(userservice.saveUserMaster(userdetails)); }
 * 
 * @Test
 * 
 * @DisplayName(" then data UserDetails is  null") void dataisNotproper() {
 * userdetails.setUserName("");
 * assertFalse(userservice.saveUserMaster(userdetails));
 * 
 * }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Saving Userdata ") class savingUserData {
 * 
 * @Test
 * 
 * @DisplayName("when Userdetails is present") void Whenuserdataproper() {
 * assertTrue(userservice.saveUser(user)); }
 * 
 * @Test
 * 
 * @DisplayName(" then data UserDetails is  null") void whenuserdataNotproper()
 * { userdetails.setUserName(""); assertFalse(userservice.saveUser(user)); }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName(" Modefying the userdata ") class Modefyingtheuserdata {
 * 
 * @Test
 * 
 * @DisplayName("when id is present ") void whenuseridpresent() { String userId
 * = "2"; assert (userservice.updateUser(user, userId)); }
 * 
 * @Test
 * 
 * @DisplayName("when User id is not present") void
 * userdataispresentIsNotPresent() { String userId = "0"; assert
 * (userservice.updateUser(user, userId));
 * 
 * }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Deleting the userdata ") class Deletingtheuserdata {
 * 
 * @Test
 * 
 * @DisplayName("when user deleted successfully with proper Id") void
 * whenDeletedWithId() { String userId = "2"; assert
 * (userservice.deleteuserById(userId)); }
 * 
 * @Test
 * 
 * @DisplayName("when user deleted Not successfully") void NotDeletedwithId() {
 * String userId = "0"; assert (userservice.deleteuserById(userId));
 * 
 * }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Fetching the Allusers data ") class fetchingAllUsersdata {
 * 
 * @Test
 * 
 * @DisplayName("when fetching all users data successfully") void
 * whengettingAllUsersData() { int sizeactual =
 * userservice.getAllUsers().size(); int sizeexpected = 6;
 * assertEquals(sizeexpected, sizeactual); }
 * 
 * @Test
 * 
 * @DisplayName("when fetching all users data NOt successfully") void
 * whenNotgettingAllUsersData() { int sizeactual =
 * userservice.getAllUsers().size(); int sizeexpected = 5;
 * assertEquals(sizeexpected, sizeactual); }
 * 
 * }
 * 
 * @Nested
 * 
 * @DisplayName("Seraching the Allusers data By Name") class
 * SearchingUsersdataByProperty {
 * 
 * @Test
 * 
 * @DisplayName("when searching  all users data successfully") void
 * whengettingAllUsersData() { String actualname =
 * userservice.searchByProperty(searchDTO).get(0).getFirstName(); String
 * expetcedname = "Kiran"; assertEquals(expetcedname, actualname); }
 * 
 * @Test
 * 
 * @DisplayName("when searching all users data NOt successfully") void
 * whenNotgettingAllUsersData() { String actualname =
 * userservice.searchByProperty(searchDTO).get(0).getFirstName(); String
 * expetcedname = "nagraj"; assertEquals(expetcedname, actualname); }
 * 
 * } } }
 * 
 * }
 */