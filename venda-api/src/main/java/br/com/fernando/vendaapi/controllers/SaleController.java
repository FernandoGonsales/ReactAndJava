package br.com.fernando.vendaapi.controllers;

import br.com.fernando.vendaapi.dtos.SaleDTO;
import br.com.fernando.vendaapi.dtos.SaleSucessDTO;
import br.com.fernando.vendaapi.dtos.SaleSumDTO;
import br.com.fernando.vendaapi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(saleService.findAll(pageable));
    }

    @GetMapping("/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        return ResponseEntity.ok(saleService.amountGroupedBySeller());
    }

    @GetMapping("/success-by-seller")
    public ResponseEntity<List<SaleSucessDTO>> successGroupedBySeller() {
        return ResponseEntity.ok(saleService.successGroupedBySeller());
    }
}
