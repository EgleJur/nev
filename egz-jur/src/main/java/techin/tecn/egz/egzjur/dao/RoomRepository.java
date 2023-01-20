package lt.techin.zoo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techin.tecn.egz.egzjur.model.Room;
import techin.tecn.egz.egzjur.model.RoomType;


import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    long countByName(String name);

    List<Room> findFirst3ByType(RoomType type);

}
