package techin.tecn.egz.egzjur.service;


import lt.techin.zoo.dao.RoomRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import techin.tecn.egz.egzjur.exception.ZooValidationException;
import techin.tecn.egz.egzjur.model.Room;
import techin.tecn.egz.egzjur.model.RoomType;


import java.util.List;
import java.util.Optional;


@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final Integer maxRooms;

    public RoomService(RoomRepository roomRepository,
                       @Value("${rooms.max-rooms}") Integer maxRooms) {
        this.roomRepository = roomRepository;
        this.maxRooms = maxRooms;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> getById(Long id) {
        return roomRepository.findById(id);
    }


    public Room create(Room room) {
        if (roomRepository.count() >= maxRooms) {
            throw new ZooValidationException("Max Capacity of Rooms exceeded",
                    "roomCount", "Max Capacity of Rooms exceeded", null);
        }

        return roomRepository.save(room);
    }

    public Room update(Long id, Room room) {
        var existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ZooValidationException("Room does not exist",
                        "id", "Room not found", id.toString()));

        existingRoom.setName(room.getName());
        existingRoom.setType(room.getType());
        existingRoom.setDescription(room.getDescription());

        return roomRepository.save(existingRoom);
    }

    public Room replace(Long id, Room room) {
        room.setId(id);

        return roomRepository.save(room);
    }
    public boolean deleteById(Long id) {
        try {
            roomRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public String executeSpringDataNamedMethod(String input) {
        return String.valueOf(roomRepository.countByName(input));
    }

    public List<Room> findByType(RoomType type) {
        return roomRepository.findFirst3ByType(type);
    }


    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
            .matchingAny()
//            .withMatcher("date??", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact())
            .withIgnorePaths("id", "description",
                    "createdDate", "modifiedDate", "createdBy", "modifiedBy");

    private Pageable pageable(int page, int pageSize, String sortField, Sort.Direction sortDirection) {
        return PageRequest.of(page, pageSize, sortDirection, sortField);
    }

    @Transactional(readOnly = true)
    public Page<Room> findByExample(String name, RoomType roomType, int page, int pageSize) {

        Room room = new Room();
        if (name != null) {
            room.setName(name);
        }
        if (roomType != null) {
            room.setType(roomType);
        }

        Example<Room> roomExample = Example.of(room, SEARCH_CONDITIONS_MATCH_ANY);

        //Jeigu norime prisideti sorting parametrus ir krypti - isplesti sekanti
        Pageable pageable = PageRequest.of(page, pageSize);

        return roomRepository.findAll(roomExample, pageable);
    }
//
//    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
//            .matchingAny()
//            .withMatcher("birthDate", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withIgnorePaths("employeeId", "gender", "hireDate", "salaries", "titles");
//


}
