package kodlama.io.rentACar.dataAccess;

import kodlama.io.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name); //spring jpa keywords
}
