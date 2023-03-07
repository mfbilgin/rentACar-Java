package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest brand) {
        brandService.add(brand);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest brand) {
        brandService.update(brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
