package com.memely.memely.unit.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.memely.memely.MemelyApplication;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.UserRepository;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = MemelyApplication.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void findAll_success() {
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isGreaterThanOrEqualTo(1);
		Assertions.assertEquals(users.size(), 7, "Expected 7 users in the database");

//        Page<User> filterUsersAnd = 
// userRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled("ROLE_ADMIN".name(), null, null, null);
//        Assertions.assertEquals(filterUsersAnd.getSize(), 2, "Expected 2 Admins in the database");

//    	Page<User> findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(Role role, Boolean isMale, Boolean enabled, Pageable pageable);

	}

	@Test
	void findAllByRole_success() {
		List<User> admins = userRepository.findAllByRole("ROLE_ADMIN", null);
		Assertions.assertEquals(admins.size(), 2, "Expected 2 admins in the database");
		List<User> clients = userRepository.findAllByRole("ROLE_USER", null);
		Assertions.assertEquals(clients.size(), 5, "Expected 5 clients in the database");
	}

	@Test
	void findByUserNameOrEmail_success() {

		Optional<User> userByUserName = userRepository.findByUsernameOrEmail("najib-rachid", "najib-rachid");
		Assertions.assertTrue(userByUserName.isPresent(), "We should find a user with UserName");

		Optional<User> userByUserName404 = userRepository.findByUsernameOrEmail("joey", "joey");
		Assertions.assertFalse(userByUserName404.isPresent(), "A User with UserName should not be found");

		Optional<User> userByEmail = userRepository.findByUsernameOrEmail("najib@anmoon.ma", "najib@anmoon.ma");
		Assertions.assertTrue(userByEmail.isPresent(), "We should find a user with Email");

		Optional<User> userByEmail404 = userRepository.findByUsernameOrEmail("joey@anmoon.ma", "joey@anmoon.ma");
		Assertions.assertFalse(userByEmail404.isPresent(), "A User with Email should not be found");
	}

	@Test
	void existsByUserNameOrEmail_success() {
		Boolean userNameExist = userRepository.existsByUsername("najib-rachid");
		Assertions.assertTrue(userNameExist, "UserName Exist");
		Boolean userNameExistNot = userRepository.existsByUsername("joey");
		Assertions.assertFalse(userNameExistNot, "UserName Doesnt Exist");
		Boolean emailExist = userRepository.existsByEmail("latifa@anmoon.ma");
		Assertions.assertTrue(userNameExist, "Email Exist");
		Boolean emailExistNot = userRepository.existsByEmail("joey@anmoon.ma");
		Assertions.assertFalse(emailExistNot, "Email Doesnt Exist");
	}

	@Test
	void testFindById_success() {
		Optional<User> userAdmin = userRepository.findById(1L);
		Assertions.assertTrue(userAdmin.isPresent(), "We should find a user with ID 1");

		User ua = userAdmin.get();
		Assertions.assertEquals(1, ua.getId(), "The user ID should be 1");
		Assertions.assertEquals("najib-rachid", ua.getUsername(), "Incorrect admin user username");
		Assertions.assertEquals("najib@anmoon.ma", ua.getEmail(), "Incorrect admin user email");
		Assertions.assertEquals("ROLE_ADMIN", ua.getRole(), "Incorrect admin user role");

		Optional<User> userClient = userRepository.findById(5L);
		User uc = userClient.get();
		Assertions.assertEquals(5, uc.getId(), "The user ID should be 1");
		Assertions.assertEquals("latifa", uc.getUsername(), "Incorrect client user username");
		Assertions.assertEquals("latifa@anmoon.ma", uc.getEmail(), "Incorrect client user email");
		Assertions.assertEquals("ROLE_USER", uc.getRole(), "Incorrect client user role");

		Optional<User> user404 = userRepository.findById(8L);
		Assertions.assertFalse(user404.isPresent(), "A User with ID 8 should not be found");
	}

	@Test
	void savedUserHasId_success() {
		User user = new User();
//      user.setUserName("testUser");
//      user.setFullName("test user");
//      user.setEmail("testUser@anmoon.ma");
//      user.setPassword("password");

		User savedUser = userRepository.save(user);
		assertThat(savedUser.getId()).isNotNull();
		// Check Role

//      var entity = new UserEntity(id, "me@example.org", "Martine Olamilekan", "hash");
//      when(repository.save(any())).thenReturn(entity);
//      when(passwordEncoder.encode(any())).thenReturn("hash");
//
//      service.createUser("me@example.org", "Martine Olamilekan", "password");
//      verify(repository).save(anyUserEntity.capture()); // Use capture()
//      assertThat(anyUserEntity.getValue().getEmail()).isEqualTo("me@example.org");
//      assertThat(anyUserEntity.getValue().getName()).isEqualTo("Martine Olamilekan");
//      assertThat(anyUserEntity.getValue().getPassword()).isEqualTo("hash");
	}

	private void updateUser_success() {
		// Arrange
//        User user = userRepository.FindByID(id);
//        user.UserKey = "SWQ";
//        user.SetUserState(new ClosedState());
//        user.CreatedBy = new User() { ID = CREATED_BY_ID };

		// Act
//        userRepository.Update(user);
//
//        User updatedUser = userRepository.FindByID(id);

		// Assert
//        Assert.AreEqual("SWQ", updatedUser.UserKey, "Record is not updated.");
//        Assert.AreEqual(CLOSED_STATE, updatedUser.State.Status, "User status is not updated.");
	}

	private void deleteUser_success() {
		User user = userRepository.findById(7L).orElseThrow(() -> new ResourceNotFoundException("User", "id", 7));

		userRepository.delete(user);
		Optional<User> deletedUser = userRepository.findById(7L);

		Assertions.assertNull(deletedUser, "Record is not deleted.");

	}
}
