package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.ModelRepository;
import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> brands = modelRepository.findAll();
        return brands.stream().map(brand -> modelMapperService
                .forResponse().map(brand, GetAllModelsResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(CreateModelRequest modelRequest) {
        Model modelForCreate = modelMapperService.forRequest().map(modelRequest, Model.class);
        modelRepository.save(modelForCreate);
    }
}
