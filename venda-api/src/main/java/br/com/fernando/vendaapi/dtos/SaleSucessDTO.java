package br.com.fernando.vendaapi.dtos;

import br.com.fernando.vendaapi.entities.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class SaleSucessDTO implements Serializable {

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSucessDTO(Seller seller, Long visited, Long deals) {
        this.sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
