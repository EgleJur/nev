package techin.tecn.egz.egzjur.api.dto;


import techin.tecn.egz.egzjur.model.AnimalType;

import java.util.Objects;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalDto {

    private String name;

    private AnimalType type;

    private String description;

    private Boolean registered;

    public AnimalDto() {
    }

    public AnimalDto(String name, AnimalType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public AnimalDto(String name, AnimalType type, String description, Boolean registered) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.registered = registered;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(name, animalDto.name) && type == animalDto.type && Objects.equals(description, animalDto.description) && Objects.equals(registered, animalDto.registered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, description, registered);
    }

    @Override
    public String toString() {
        return "AnimalDto{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", registered=" + registered +
                '}';
    }

}
