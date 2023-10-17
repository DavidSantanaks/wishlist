package br.com.david.Wishlist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findOneUser(@PathVariable Long id){
        var user = this.userService.findUserById(id);
        if(user != null){
            return ResponseEntity.ok().body(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserModel model){
        UserModel user = this.userService.createUser(model);
        return ResponseEntity.ok().body(user);
    }

    //Atualizar senha usuario

    @PutMapping("/{id}")
    public ResponseEntity updateUserPassword(@PathVariable Long id, @RequestBody UserModel user){
        user.setId(id);
        this.userService.updateUserPassword(user);
        return ResponseEntity.ok().build();
    }

    //Deleta um desejo
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        //Arrumar essa classe
        if(this.userService.findUserById(id) != null){
            this.userService.deleteUser(id);
            return ResponseEntity.ok().body("User deleted :/");
        }else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
