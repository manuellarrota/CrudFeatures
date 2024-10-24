package com.manuellarrota.crudfeatures.service.impl;

import com.manuellarrota.crudfeatures.repository.CustomCrudRepository;
import com.manuellarrota.crudfeatures.service.CustomCrudService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CustomCrudServiceImpl<T, DTO, R extends CustomCrudRepository<T>>
        implements CustomCrudService<T, DTO> {

    protected final R repository;
    private final ModelMapper modelMapper;
    private final Class<T> typeClassInstance;
    private final Class<DTO> typeClassDTO;
    @Autowired
    public CustomCrudServiceImpl(R repository, ModelMapper modelMapper, Class<T> typeClassInstance, Class<DTO> typeClassDTO) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.typeClassInstance = typeClassInstance;
        this.typeClassDTO = typeClassDTO;
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }


    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T update(Long id, T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }

    @Override
    public DTO saveDto(DTO dto) {
        return getDto(save(getInstance(dto)));
    }

    @Override
    public DTO getByIdDto(Long id) {
        return getDto(getById(id));
    }

    @Override
    public List<DTO> getAllDto() {
        return getAll().stream().map(this::getDto).collect(Collectors.toList());
    }

    @Override
    public DTO updateDto(DTO entityDto) {
        return saveDto(entityDto);
    }

    @Override
    public DTO getDto(T instance) {
        //log.info("Mapeando: " + typeClassInstance + " >> " + typeClassDTO);
        if (instance != null) {
            return modelMapper.map(instance, typeClassDTO);
        }
        return modelMapper.map(new Object(), typeClassDTO);
    }

    @Override
    public T getInstance(DTO dto) {
        //log.info("Mapeando: " + typeClassDTO + " >> " + typeClassInstance);
        if (dto != null) {
            return modelMapper.map(dto, typeClassInstance);
        }
        return modelMapper.map(new Object(), typeClassInstance);
    }
}
