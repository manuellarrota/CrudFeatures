package com.manuellarrota.crudfeatures.controller;

import com.manuellarrota.crudfeatures.dto.GenericErrorDto;
import com.manuellarrota.crudfeatures.service.CustomCrudService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public interface CustomCrudRestController<T, DTO, S extends CustomCrudService<T,DTO>>{

    @PostMapping("/save")
    String save(@ModelAttribute("objetcDto") @Valid DTO dto, BindingResult result) throws GenericErrorDto;

    @PostMapping("/get")
    String get(@ModelAttribute("objetoConsultaDto") @Valid DTO dto, BindingResult result) throws GenericErrorDto;

    @PostMapping("/update")
    String update(@ModelAttribute("objetoDto")@Valid DTO dto, BindingResult result) throws GenericErrorDto;

    @PostMapping("/delete")
    String delete(@ModelAttribute("id") @Valid String id, BindingResult result) throws GenericErrorDto;


}