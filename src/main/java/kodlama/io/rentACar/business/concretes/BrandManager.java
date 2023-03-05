package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandResponse;
import kodlama.io.rentACar.dataAccess.BrandRepository;
import kodlama.io.rentACar.entities.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Spring tarafından anlaşılması için
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> getAllBrandResponses = new ArrayList<>();
        for (Brand brand : brands) {
            GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();
            getAllBrandResponse.setId(brand.getId());
            getAllBrandResponse.setName(brand.getName());
            getAllBrandResponses.add(getAllBrandResponse);
        }
        return getAllBrandResponses;
    }

    @Override
    public void add(CreateBrandRequest brand) {
        Brand brandForCreate = new Brand();
        brandForCreate.setName(brand.getName());
        brandRepository.save(brandForCreate);
    }
}
