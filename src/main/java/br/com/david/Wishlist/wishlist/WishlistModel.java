package br.com.david.Wishlist.wishlist;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name ="tb_wishlist")
@Data
public class WishlistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 80)
    private String name;
    private String description;
    private Double price;

}
