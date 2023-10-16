package br.com.david.Wishlist.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistModel, Long> {


}
