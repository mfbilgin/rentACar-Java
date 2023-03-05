package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandResponse;
import kodlama.io.rentACar.entities.Brand;

import java.util.List;


public interface BrandService {
    List<GetAllBrandResponse> getAll();
    void add(CreateBrandRequest brand);

}
