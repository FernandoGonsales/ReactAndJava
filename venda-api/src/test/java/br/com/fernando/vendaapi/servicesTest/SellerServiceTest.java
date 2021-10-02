package br.com.fernando.vendaapi.servicesTest;

import br.com.fernando.vendaapi.dtos.SellerDTO;
import br.com.fernando.vendaapi.entities.Sale;
import br.com.fernando.vendaapi.entities.Seller;
import br.com.fernando.vendaapi.repositories.SellerRepository;
import br.com.fernando.vendaapi.services.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SellerServiceTest {

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SellerService sellerService;

    List<Sale> sales = new ArrayList<>();

    @Test
    public void MustReturnAllSellersTheirSales() {
        createSale(1L, 10, 5, 50.0, LocalDate.of(2021, 9, 22));
        createSale(2L, 20, 10, 100.0, LocalDate.of(2021, 9, 22));
        List<Seller> sellers = Arrays.asList(
                createSeller(1L, "Fernando Test", sales),
                createSeller(2L, "Fernando Test2", sales)
        );
        Mockito.when(sellerRepository
                .findAll())
                .thenReturn(sellers);
        List<SellerDTO> sellersResult = sellerService.findAll();
        Assert.assertNotNull(sellersResult);
        Assert.assertEquals(sellers.get(0).getId(), sellersResult.get(0).getId());
        Assert.assertEquals(sellers.get(0).getName(), sellersResult.get(0).getName());
        Assert.assertEquals(sellers.get(1).getId(), sellersResult.get(1).getId());
        Assert.assertEquals(sellers.get(1).getName(), sellersResult.get(1).getName());
    }

    private Seller createSeller(Long id, String name, List<Sale> sale) {
        return new Seller(id, name, sale);
    }

    public void createSale(Long id, Integer visited, Integer deals, Double amount, LocalDate date) {
        sales.add(new Sale (id, visited, deals, amount, date));
    }

}
