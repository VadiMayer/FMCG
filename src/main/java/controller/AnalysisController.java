package controller;

import model.Actual;
import model.Price;
import model.Product;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    private ActualRepository actualRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    @GetMapping("/sales")
    public List<Actual> getSales(@RequestParam(required = false) List<String> chains,
                                 @RequestParam(required = false) List<String> products) {

        // Get actuals and enrich with product info
        return actualRepository.findAll().stream()
                .map(actual -> {
                    Product product = productRepository.findById(actual.getMaterialNo()).orElse(null);
                    if (product != null) {
                        actual.setProductCategoryCode(product.getProductCategoryCode());
                        actual.setProductCategoryName(product.getProductCategoryName());
                    }
                    return actual;
                })
                .filter(actual -> {
                    if (chains != null && !chains.contains(actual.getChain())) {
                        return false;
                    }
                    if (products != null && !products.contains(actual.getMaterialNo())) {
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void calculatePromoFlags() {

        List<Actual> actuals = actualRepository.findAll();

        for (Actual actual : actuals) {
            Price price = priceRepository.findById(actual.getMaterialNo()).orElse(null);
            if (price != null && actual.getActualSalesValue() < price.getRegularPrice() * actual.getVolume()) {
                actual.setPromoFlag("Promo");
            } else {
                actual.setPromoFlag("Regular");
            }
        }

        actualRepository.saveAll(actuals);
    }
}
