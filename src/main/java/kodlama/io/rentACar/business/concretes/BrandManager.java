package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.BrandRepository;
import kodlama.io.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Spring tarafından anlaşılması için
@AllArgsConstructor // Tüm final alanları parametre olarak alan constructor oluşturur.
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> modelMapperService
                .forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(CreateBrandRequest brand) {
        Brand brandForCreate = modelMapperService.forRequest().map(brand, Brand.class);
        brandRepository.save(brandForCreate);
    }

    @Override
    public void update(UpdateBrandRequest brand) {
        Brand brandForUpdate = modelMapperService.forRequest().map(brand, Brand.class);
        brandRepository.save(brandForUpdate);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }
}
