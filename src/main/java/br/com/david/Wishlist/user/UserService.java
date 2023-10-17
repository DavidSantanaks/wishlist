package br.com.david.Wishlist.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Encontrar um usuario
    public UserModel findUserById(long id){
        Optional<UserModel> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado! Id:" + id ));
    }

    //Criar usuario
    @Transactional
    public UserModel createUser(UserModel model){
        model.setId(null);
        UserModel user = this.userRepository.save(model);
        return  user;
    }

    //Atualizar senha usuario
    @Transactional
    public UserModel updateUserPassword(UserModel model){
        UserModel update = findUserById(model.getId());
        update.setPassword(model.getPassword());
        return  this.userRepository.save(update);
    }

    //Deletar usuario
    public void deleteUser(Long id){
        findUserById(id);
        try {
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Dont has user with this ID");
        }
    }
}
