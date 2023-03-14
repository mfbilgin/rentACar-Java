package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest brand);
    void update(UpdateBrandRequest brand);
    void delete(int id);
    GetByIdBrandResponse getById(int id);
}
