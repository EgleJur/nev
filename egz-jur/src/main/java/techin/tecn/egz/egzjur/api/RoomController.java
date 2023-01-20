package techin.tecn.egz.egzjur.api;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import techin.tecn.egz.egzjur.api.dto.RoomDto;
import techin.tecn.egz.egzjur.api.dto.RoomEntityDto;

import techin.tecn.egz.egzjur.api.dto.mapper.RoomMapper;
import techin.tecn.egz.egzjur.model.RoomType;
import techin.tecn.egz.egzjur.service.RoomService;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

import static org.springframework.http.ResponseEntity.ok;
import static techin.tecn.egz.egzjur.api.dto.mapper.RoomMapper.*;

@Controller
@RequestMapping("/api/v1/rooms")
@Validated
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public List<RoomEntityDto> getRooms() {
        return roomService.getAll().stream()
                .map(RoomMapper::toRoomEntityDto)
                .collect(toList());

    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomEntityDto> getRoom(@PathVariable Long roomId) {
        var roomOptional = roomService.getById(roomId);

        var responseEntity = roomOptional
                .map(room -> ok(toRoomEntityDto(room)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
        var roomDeleted = roomService.deleteById(roomId);

        if (roomDeleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto roomDto) {
        var createdRoom = roomService.create(toRoom(roomDto));

        return ok(toRoomDto(createdRoom));
    }

    @PatchMapping("/{roomId}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long roomId, @RequestBody RoomDto roomDto) {
        var updatedRoom = roomService.update(roomId, toRoom(roomDto));

        return ok(toRoomDto(updatedRoom));
    }
    @PutMapping("/{roomId}")
    public ResponseEntity<RoomDto> replaceRoom(@PathVariable Long animalId, @RequestBody RoomDto roomDto) {
        var updatedRoom = roomService.replace(animalId, toRoom(roomDto));

        return ok(toRoomDto(updatedRoom));
    }

    @GetMapping("/custom")
    public ResponseEntity<String> executeCustom(@RequestParam String input) {
        var result = roomService.executeSpringDataNamedMethod(input);
        return ok(result);
    }

    @GetMapping("/type/top")
    public ResponseEntity<List<RoomDto>> findLatestByType(@RequestParam RoomType type) {
        var result = roomService.findByType(type).stream()
                .map(RoomMapper::toRoomDto)
                .collect(toList());

        return ok(result);
    }
    @GetMapping("/search")
    @ResponseBody
    public List<RoomEntityDto> findRoomsPaged(@RequestParam(required = false) String name, @RequestParam(required = false) RoomType type,
                                              @RequestParam int page, @RequestParam int pageSize) {
        return roomService.findByExample(name, type, page, pageSize).stream()
                .map(RoomMapper::toRoomEntityDto)
                .collect(toList());
    }
}
