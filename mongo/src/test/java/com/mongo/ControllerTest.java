/*
 * package com.mongo;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import com.mongo.controller.UserServiceController; import
 * com.mongo.dto.SearchDTO; import com.mongo.model.Address; import
 * com.mongo.model.Education; import com.mongo.model.User; import
 * com.mongo.model.UserDetails; import com.mongo.service.UserService;
 * 
 * @ExtendWith(MockitoExtension.class) public class ControllerTest {
 * 
 * @Mock private static UserService userService;
 * 
 * @InjectMocks private static UserServiceController controller = new
 * UserServiceController();
 * 
 * ResponseEntity<List<User>> response = null;
 * 
 * private SearchDTO searchDTO;
 * 
 * User user = null; Address address = null; Address address1 = null;
 * List<Address> listofaddress = null; List<User> userslist = null; Education
 * education = null; UserDetails userdetails = null;
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
 * searchDTO.setLastName("raj"); userslist = new ArrayList<>();
 * userslist.add(user); response = new ResponseEntity<List<User>>(userslist,
 * HttpStatus.OK); } catch (Exception e) { e.printStackTrace(); } }
 * 
 * @Test public void getAllUsers() {
 * Mockito.when(userService.getAllUsers()).thenReturn(userslist);
 * assertEquals(userslist, controller.getAllusers()); }
 * 
 * @Test public void saveuser() {
 * Mockito.when(userService.saveUser(user)).thenReturn(true); assertEquals(true,
 * controller.saveUser(user)); }
 * 
 * @Test public void updateuser() { Mockito.when(userService.updateUser(user,
 * "2")).thenReturn(true); assertEquals(true, controller.updateUserByID(user,
 * "2")); }
 * 
 * @Test public void DeleteUserById() {
 * Mockito.when(userService.deleteuserById("2")).thenReturn(true);
 * assertEquals(true, controller.deleteById("2")); }
 * 
 * @Test public void searchByName() {
 * Mockito.when(userService.searchByProperty(searchDTO)).thenReturn(userslist);
 * assertEquals(userslist, controller.serachByproeprty(searchDTO)); }
 * 
 * }
 */