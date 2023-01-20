package techin.tecn.egz.egzjur.api.dto.mapper;


import techin.tecn.egz.egzjur.api.dto.AnimalDto;
import techin.tecn.egz.egzjur.api.dto.AnimalEntityDto;
import techin.tecn.egz.egzjur.model.Animal;

public class AnimalMapper {

    public static AnimalDto toAnimalDto(Animal animal) {
        var animalDto = new AnimalDto();

        animalDto.setName(animal.getName());
        animalDto.setType(animal.getType());
        animalDto.setDescription(animal.getDescription());
        animalDto.setRegistered(animal.getRegistered());

        return animalDto;
    }

    public static AnimalEntityDto toAnimalEntityDto(Animal animal) {
        var animalDto = new AnimalEntityDto();

        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setType(animal.getType());
        animalDto.setDescription(animal.getDescription());
        animalDto.setRegistered(animal.getRegistered());

        return animalDto;
    }

    public static Animal toAnimal(AnimalDto animalDto) {
        var animal = new Animal();

        animal.setName(animalDto.getName());
        animal.setType(animalDto.getType());
        animal.setDescription(animalDto.getDescription());
        animal.setRegistered(animalDto.getRegistered());

        return animal;
    }

    public static Animal toAnimalFromEntityDto(AnimalEntityDto animalDto) {
        var animal = new Animal();

        animal.setId(animalDto.getId());
        animal.setName(animalDto.getName());
        animal.setType(animalDto.getType());
        animal.setDescription(animalDto.getDescription());
        animal.setRegistered(animalDto.getRegistered());

        return animal;
    }

}
