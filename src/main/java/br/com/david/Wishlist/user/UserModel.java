package br.com.david.Wishlist.user;

import br.com.david.Wishlist.wishlist.WishlistModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30, unique = true)
    private String username;
    private String password;
    @Column(length = 120,unique = true)
    private String email;


    @OneToMany(mappedBy = "user")
    private List<WishlistModel> wish = new ArrayList<WishlistModel>();
}
