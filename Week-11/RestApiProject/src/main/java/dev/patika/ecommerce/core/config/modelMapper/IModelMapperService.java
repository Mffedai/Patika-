package dev.patika.ecommerce.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
