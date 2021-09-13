package br.com.fernando.vendaapi.repositories;

import br.com.fernando.vendaapi.dtos.SaleSucessDTO;
import br.com.fernando.vendaapi.dtos.SaleSumDTO;
import br.com.fernando.vendaapi.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new br.com.fernando.vendaapi.dtos.SaleSumDTO(sale.seller, SUM(sale.amount)) " +
            " FROM Sale AS sale GROUP BY sale.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new br.com.fernando.vendaapi.dtos.SaleSucessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals)) " +
            " FROM Sale AS sale GROUP BY sale.seller")
    List<SaleSucessDTO> sucessGroupedBySeller();
}
