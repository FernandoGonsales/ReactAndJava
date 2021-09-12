package br.com.fernando.vendaapi.repositories;

import br.com.fernando.vendaapi.entities.Sale;
import br.com.fernando.vendaapi.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
