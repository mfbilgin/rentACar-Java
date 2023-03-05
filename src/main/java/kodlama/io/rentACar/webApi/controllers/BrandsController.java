package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandResponse;
import kodlama.io.rentACar.entities.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping("/getAll")
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateBrandRequest brand) {
        brandService.add(brand);
    }
}
