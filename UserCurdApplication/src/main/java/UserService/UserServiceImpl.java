package UserService;


		// TODO Auto-generated method stub
		import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.User;
import UserRepository.UserRepository;

		@Service
		public class UserServiceImpl implements UserService {

		    @Autowired
		    private UserRepository userRepository;

		    @Override
		    public List<User> getAllUsers() {
		        return userRepository.findAll();
		    }

		    @Override
		    public User getUserById(Long id) {
		        return userRepository.findById(id)
		                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		    }

		    @Override
		    public User saveUser(User user) {
		        return userRepository.save(user);
		    }

		    @Override
		    public User updateUser(Long id, User userDetails) {
		        User user = getUserById(id);
		        user.setName(userDetails.getName());
		        user.setEmail(userDetails.getEmail());
		        return userRepository.save(user);
		    }

		    @Override
		    public void deleteUser(Long id) {
		        userRepository.deleteById(id);
		    }
		
		    @Override
		    public User login(String email, String password) {
		        return userRepository.findByEmailAndPassword(email, password)
		                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
		    }


	}

