package br.com.david.Wishlist.wishlist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WishlistService {

    @Autowired
    WishlistRepository wishRepository;

    //Função de pesquisar um wish
    public WishlistModel findById(UUID id){
        Optional<WishlistModel> wish = this.wishRepository.findById(id);
        return wish.orElseThrow(() -> new RuntimeException("Wish not found"));
    }

    //Usar com método POST
    @Transactional
    public WishlistModel createWish(WishlistModel model){
        model.setId(null);
        model = this.wishRepository.save(model);
        return model;
    }

    //Usar com o método GET
    public List<WishlistModel> findAllWish(){
        List<WishlistModel> allWish = this.wishRepository.findAll();
        return allWish;
    }



    //Usar com o PUT
    @Transactional
    public WishlistModel updateWish(WishlistModel model){
        var wishUpdated = findById(model.getId());
        wishUpdated.setDescription(model.getDescription());
        return this.wishRepository.save(model);
    }

    //Usar com delete
    public void deleteWish(UUID id){
        findById(id);
        try {
            this.wishRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Dont has wish with this ID");
        }
    }
}
