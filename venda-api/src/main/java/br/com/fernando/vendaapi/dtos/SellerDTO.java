package br.com.fernando.vendaapi.dtos;

import br.com.fernando.vendaapi.entities.Seller;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerDTO implements Serializable {

    private Long id;
    private String name;

    public SellerDTO(Seller seller) {
        this.id = seller.getId();
        this.name = seller.getName();
    }
}
