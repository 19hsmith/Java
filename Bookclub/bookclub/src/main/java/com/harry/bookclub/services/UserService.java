package com.harry.bookclub.services;

import java.util.Optional;
    
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.harry.bookclub.models.LoginUser;
import com.harry.bookclub.models.User;
import com.harry.bookclub.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> user = userRepo.findByEmail(newUser.getEmail());
        if(user.isPresent()){
            result.rejectValue("email", "Email","Email already registered.");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm" ,"Confirm" ,"Passwords must match");
        }
        if(result.hasErrors()){
            return null;
        }
        // TO-DO: Additional validations!

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);       
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        Optional<User> loginUser = userRepo.findByEmail(newLoginObject.getEmail());
        User user;
        if(!loginUser.isPresent()){
            result.rejectValue("email", "Email" , "No matching email was found please register");
            return null;
        }else{
            user = loginUser.get();
        }
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid credentials");
            return null;
        }
        return user;
    }

}