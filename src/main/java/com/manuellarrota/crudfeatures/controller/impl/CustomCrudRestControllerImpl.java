package com.manuellarrota.crudfeatures.controller.impl;


import com.manuellarrota.crudfeatures.controller.CustomCrudRestController;
import com.manuellarrota.crudfeatures.dto.GenericErrorDto;
import com.manuellarrota.crudfeatures.service.CustomCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

@Slf4j
public class CustomCrudRestControllerImpl<T, DTO, S extends CustomCrudService<T,DTO>> implements CustomCrudRestController<T, DTO, S> {

    final S service;

    @Autowired
    public CustomCrudRestControllerImpl(S service) {
        this.service = service;
    }


    @Override
    public String save(DTO dto, BindingResult result) throws GenericErrorDto {
        log.info("Save " + dto);
        if (result.hasErrors()) {
            //crearFormInicialError(model, result, dto);
            log.error(result.toString());
            return result.toString();
        }
        try {
            service.saveDto(dto);
        } catch (Error e) {
            log.info("Saved " + dto);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return dto.toString();
    }

    @Override
    public String get(DTO dto, BindingResult result) throws GenericErrorDto {
        return null;
    }

    @Override
    public String update(DTO dto, BindingResult result) throws GenericErrorDto {
        return null;
    }

    @Override
    public String delete(String id, BindingResult result) throws GenericErrorDto {
        return null;
    }
}
