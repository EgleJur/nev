package techin.tecn.egz.egzjur.api.dto;


import techin.tecn.egz.egzjur.model.RoomType;


import java.time.LocalDateTime;
import java.util.Objects;

public class RoomEntityDto extends RoomDto {

    private Long id;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;


    public RoomEntityDto() {
    }

    public RoomEntityDto(Long id, String name, RoomType type, String description) {
        super(name, type, description);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoomEntityDto that = (RoomEntityDto) o;
        return Objects.equals(id, that.id) && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, modifiedDate);
    }

    @Override
    public String toString() {
        return "RoomEntityDto{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                " " + super.toString() +
                '}';
    }
}
