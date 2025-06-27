package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.CategoriaAnimalDto;
import com.granja.animal_farm_web.Entity.CategoriaAnimal;
import com.granja.animal_farm_web.Services.CategoriaAnimalService;
import com.granja.animal_farm_web.repository.CategoriaAnimalRepo;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaAnimalBusiness {
    @Autowired
    private CategoriaAnimalService categoriaAnimalService;
    @Autowired
    private CategoriaAnimalRepo categoriaAnimalRepo;
    @Autowired
    private ModelMapper modelMapper;

    public CategoriaAnimalDto crearCategoriaAnimal(CategoriaAnimalDto categoriaAnimalDto) {
        categoriaAnimalDto.setCategoriaAnimalId(null);
        validarCoherenciaDatos(categoriaAnimalDto);
        CategoriaAnimal categoriaAnimal = modelMapper.map(categoriaAnimalDto, CategoriaAnimal.class);
        categoriaAnimal.setCategoriaAnimalId(null);
        CategoriaAnimal creado = categoriaAnimalService.crearCategoriaAnimal(categoriaAnimal);
        return modelMapper.map(creado, CategoriaAnimalDto.class);
    }

    private void validarCoherenciaDatos(CategoriaAnimalDto categoriaAnimalDto) {
        // Puedes agregar reglas de validación específicas para CategoriaAnimal aquí
        if (categoriaAnimalDto.getNombreCategoria() == null || categoriaAnimalDto.getNombreCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío");
        }
    }

    private CategoriaAnimal validarExistenciaCategoriaAnimal(int id) {
        CategoriaAnimal categoriaAnimal = categoriaAnimalService.obtenerCategoriaAnimalId(id);
        if (categoriaAnimal == null) {
            throw new NotFoundException("Categoría de animal no encontrada con id: " + id);
        }
        return categoriaAnimal;
    }

    public List<CategoriaAnimalDto> listarCategoriasAnimales() {
        return categoriaAnimalService.listarCategoriaAnimal().stream()
            .map(categoriaAnimal -> modelMapper.map(categoriaAnimal, CategoriaAnimalDto.class))
            .collect(Collectors.toList());
    }

    public CategoriaAnimalDto actualizarCategoriaAnimal(int id, CategoriaAnimalDto categoriaAnimalDto) {
        validarExistenciaCategoriaAnimal(id);
        validarCoherenciaDatos(categoriaAnimalDto);
        CategoriaAnimal categoriaAnimal = modelMapper.map(categoriaAnimalDto, CategoriaAnimal.class);
        CategoriaAnimal actualizado = categoriaAnimalService.actualizarCategoriaAnimal(id, categoriaAnimal);
        return modelMapper.map(actualizado, CategoriaAnimalDto.class);
    }

    public CategoriaAnimalDto obtenerCategoriaAnimalPorId(int id) {
        CategoriaAnimal categoriaAnimal = validarExistenciaCategoriaAnimal(id);
        return modelMapper.map(categoriaAnimal, CategoriaAnimalDto.class);
    }
}
