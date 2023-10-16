package br.com.david.Wishlist.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/wish")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    //Busca todos os desejos
    @GetMapping("/")
    public ResponseEntity<List<WishlistModel>> findAllWish(){
        List<WishlistModel> allWish = this.wishlistService.findAllWish();
        return ResponseEntity.ok().body(allWish);
    }

    //Busca todos os desejos
    @GetMapping("/{id}")
    public ResponseEntity<WishlistModel> findOneWish(@PathVariable  Long id){
        WishlistModel oneWish = this.wishlistService.findById(id);
        if (oneWish.equals(null)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(oneWish);
    }
    //Cadastra um desejo
    @PostMapping("/")
    public ResponseEntity createWish(@RequestBody WishlistModel wishlistModel){
        WishlistModel newWish = this.wishlistService.createWish(wishlistModel);
        return ResponseEntity.ok().body(wishlistModel);
    }

    //Deleta um desejo
    @DeleteMapping("/{id}")
    public ResponseEntity deleteWish(@PathVariable  Long id){
        //Arrumar essa classe
        if(this.wishlistService.findById(id) != null){
            this.wishlistService.deleteWish(id);
            return ResponseEntity.ok().body("Wish deleted :/");
        }else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
