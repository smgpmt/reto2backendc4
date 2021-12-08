/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosC4.servicio;

import RetosC4.modelo.User;
import RetosC4.repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class UserService {
     @Autowired
    private UserRepositorio userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User create(User user){
        if(user.getId() == null) {
            return user;
        }else{
            Optional<User> e = userRepository.getUser(user.getId());
            if(e.isEmpty()){
                if(emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User update(User user) {
        if(user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser (String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if(user.isEmpty()){
            return new User();
        } else{
            return user.get();
        }
    }
}
