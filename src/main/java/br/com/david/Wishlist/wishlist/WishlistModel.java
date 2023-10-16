package br.com.david.Wishlist.wishlist;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="tb_wishlist")
@Data
public class WishlistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 80)
    private String name;
    private String description;
    private Double price;

}
