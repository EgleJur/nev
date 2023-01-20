package techin.tecn.egz.egzjur.api.dto;


import techin.tecn.egz.egzjur.model.RoomType;

import javax.validation.constraints.*;
import java.util.Objects;

public class RoomDto {

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private RoomType type;

    private String description;

    public RoomDto() {
    }

    public RoomDto(String name, RoomType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(name, roomDto.name) && type == roomDto.type && Objects.equals(description, roomDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, description);
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
