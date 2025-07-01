package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.AnimalDto;
import com.granja.animal_farm_web.Entity.Animal;
import com.granja.animal_farm_web.Services.AnimalService;
import com.granja.animal_farm_web.exception.AnimalNotFoundException;
import com.granja.animal_farm_web.repository.AnimalRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalBusiness {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AnimalDto crearAnimal(AnimalDto animalDto) {
        animalDto.setAnimalId(null);
        validarCoherenciaDatos(animalDto);
        if (animalRepo.existsByNombreAnimal(animalDto.getNombreAnimal())) {
            throw new IllegalArgumentException("El nombre del animal ya existe");
        }
        Animal animal = modelMapper.map(animalDto, Animal.class);
        if (animalDto.getRaza() != null) {
            animal.setRaza(modelMapper.map(animalDto.getRaza(), com.granja.animal_farm_web.Entity.Raza.class));
        }
        animal.setAnimalId(null);
        Animal creado = animalService.crearAnimal(animal);
        AnimalDto creadoDto = modelMapper.map(creado, AnimalDto.class);
        if (creado.getRaza() != null) {
            creadoDto.setRaza(modelMapper.map(creado.getRaza(), com.granja.animal_farm_web.Dto.RazaDto.class));
        }
        return creadoDto;
    }

    private void validarCoherenciaDatos(AnimalDto animalDto) {
        // Edad y fecha de nacimiento
        if (animalDto.getFechaNacimiento() != null && animalDto.getEdad() != null) {
            int edadCalculada = java.time.Period.between(animalDto.getFechaNacimiento(), java.time.LocalDate.now()).getYears();
            if (!animalDto.getEdad().equals(edadCalculada)) {
                throw new IllegalArgumentException("La edad no coincide con la fecha de nacimiento");
            }
        }
        // Peso positivo
        if (animalDto.getPeso() != null && animalDto.getPeso().signum() <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
        // Puedes agregar más reglas aquí
    }

    private Animal validarExistenciaAnimal(int id) {
        Animal animal = animalService.obtenerAnimalPorId(id);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal no encontrado con id: " + id);
        }
        return animal;
    }

    public AnimalDto actualizarAnimal(int id, AnimalDto animalDto) {
        validarExistenciaAnimal(id);
        validarCoherenciaDatos(animalDto);
        Animal animal = modelMapper.map(animalDto, Animal.class);
        Animal actualizado = animalService.actualizarAnimal(id, animal);
        return modelMapper.map(actualizado, AnimalDto.class);
    }

    public AnimalDto cambiarEstadoSalud(int id, com.granja.animal_farm_web.Entity.Enums.estadoSaludAnimal estadoSalud) {
        validarExistenciaAnimal(id);
        Animal animal = animalService.cambiarEstadoSalud(id, estadoSalud);
        return modelMapper.map(animal, AnimalDto.class);
    }

    public AnimalDto cambiarEstadoAnimal(int id, boolean estado) {
        validarExistenciaAnimal(id);
        Animal animal = animalService.cambiarEstadoAnimal(id, estado);
        return modelMapper.map(animal, AnimalDto.class);
    }

    public List<AnimalDto> listarAnimales() {
        List<Animal> animales = animalRepo.findAll();
        return animales.stream()
                .map(animal -> {
                    AnimalDto dto = modelMapper.map(animal, AnimalDto.class);
                    if (animal.getRaza() != null) {
                        dto.setRaza(modelMapper.map(animal.getRaza(), com.granja.animal_farm_web.Dto.RazaDto.class));
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public AnimalDto obtenerAnimalPorId(int id) {
        Animal animal = validarExistenciaAnimal(id);
        return modelMapper.map(animal, AnimalDto.class);
    }
}
