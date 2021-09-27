package br.com.fernando.vendaapi.services;

import br.com.fernando.vendaapi.dtos.SaleDTO;
import br.com.fernando.vendaapi.dtos.SaleSucessDTO;
import br.com.fernando.vendaapi.dtos.SaleSumDTO;
import br.com.fernando.vendaapi.entities.Sale;
import br.com.fernando.vendaapi.repositories.SaleRepository;
import br.com.fernando.vendaapi.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository SellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        SellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSucessDTO> successGroupedBySeller() {
        return saleRepository.successGroupedBySeller();
    }

}
