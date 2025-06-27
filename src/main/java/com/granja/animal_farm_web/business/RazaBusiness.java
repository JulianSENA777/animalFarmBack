package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.RazaDto;
import com.granja.animal_farm_web.Entity.CategoriaAnimal;
import com.granja.animal_farm_web.Entity.Raza;
import com.granja.animal_farm_web.Services.RazaService;
import com.granja.animal_farm_web.Services.CategoriaAnimalService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RazaBusiness {
    @Autowired
    private RazaService razaService;
    @Autowired
    private CategoriaAnimalService categoriaAnimalService;
    @Autowired
    private ModelMapper modelMapper;

    public RazaDto crearRaza(RazaDto razaDto) {
        validarCoherenciaDatos(razaDto);
        Raza raza = modelMapper.map(razaDto, Raza.class);
        if (razaDto.getCategoriaAnimalDto() != null && razaDto.getCategoriaAnimalDto().getCategoriaAnimalId() != null) {
            CategoriaAnimal categoria = categoriaAnimalService.obtenerCategoriaAnimalId(razaDto.getCategoriaAnimalDto().getCategoriaAnimalId());
            if (categoria == null) throw new NotFoundException("Categoría no encontrada");
            raza.setCategoriaAnimal(categoria);
        }
        Raza creado = razaService.crearRaza(raza);
        RazaDto creadoDto = modelMapper.map(creado, RazaDto.class);
        if (creado.getCategoriaAnimal() != null) {
            creadoDto.setCategoriaAnimalDto(modelMapper.map(creado.getCategoriaAnimal(), com.granja.animal_farm_web.Dto.CategoriaAnimalDto.class));
        }
        return creadoDto;
    }

    private void validarCoherenciaDatos(RazaDto razaDto) {
        if (razaDto.getNombreRaza() == null || razaDto.getNombreRaza().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la raza no puede estar vacío");
        }
    }

    private Raza validarExistenciaRaza(int id) {
        Raza raza = razaService.obtenerRazaId(id);
        if (raza == null) {
            throw new NotFoundException("Raza no encontrada con id: " + id);
        }
        return raza;
    }

    public List<RazaDto> listarRazas() {
        return razaService.listarRaza().stream()
            .map(raza -> {
                RazaDto dto = modelMapper.map(raza, RazaDto.class);
                if (raza.getCategoriaAnimal() != null) {
                    dto.setCategoriaAnimalDto(modelMapper.map(raza.getCategoriaAnimal(), com.granja.animal_farm_web.Dto.CategoriaAnimalDto.class));
                }
                return dto;
            })
            .collect(Collectors.toList());
    }

    public RazaDto actualizarRaza(int id, RazaDto razaDto) {
        validarExistenciaRaza(id);
        validarCoherenciaDatos(razaDto);
        Raza raza = modelMapper.map(razaDto, Raza.class);
        if (razaDto.getCategoriaAnimalDto() != null && razaDto.getCategoriaAnimalDto().getCategoriaAnimalId() != null) {
            CategoriaAnimal categoria = categoriaAnimalService.obtenerCategoriaAnimalId(razaDto.getCategoriaAnimalDto().getCategoriaAnimalId());
            if (categoria == null) throw new NotFoundException("Categoría no encontrada");
            raza.setCategoriaAnimal(categoria);
        }
        Raza actualizado = razaService.actualizarRaza(id, raza);
        RazaDto actualizadoDto = modelMapper.map(actualizado, RazaDto.class);
        if (actualizado.getCategoriaAnimal() != null) {
            actualizadoDto.setCategoriaAnimalDto(modelMapper.map(actualizado.getCategoriaAnimal(), com.granja.animal_farm_web.Dto.CategoriaAnimalDto.class));
        }
        return actualizadoDto;
    }

    public RazaDto obtenerRazaPorId(int id) {
        Raza raza = validarExistenciaRaza(id);
        RazaDto dto = modelMapper.map(raza, RazaDto.class);
        if (raza.getCategoriaAnimal() != null) {
            dto.setCategoriaAnimalDto(modelMapper.map(raza.getCategoriaAnimal(), com.granja.animal_farm_web.Dto.CategoriaAnimalDto.class));
        }
        return dto;
    }
}
