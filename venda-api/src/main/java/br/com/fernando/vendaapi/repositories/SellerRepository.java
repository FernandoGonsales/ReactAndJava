package br.com.fernando.vendaapi.repositories;

import br.com.fernando.vendaapi.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
