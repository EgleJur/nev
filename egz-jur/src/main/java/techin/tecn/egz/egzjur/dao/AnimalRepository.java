package techin.tecn.egz.egzjur.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import techin.tecn.egz.egzjur.model.Animal;

import java.util.List;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

// findStoreByLocationId

    @Query(value = "SELECT a FROM Animal a WHERE a.status = 1",
            nativeQuery = true)
    List<Animal> findAllMarkedAnimals();


    @Modifying
    @Query("delete Animal a where (a.registered IS NULL or a.registered = false)")
    //The @Modifying annotation is used to enhance the @Query annotation so
        // that we can execute not only SELECT queries, but also INSERT, UPDATE, DELETE, and even DDL queries.
    int deleteNonRegisteredAnimals();


    ///update set room animal, where animal.id = 1;

//    @Query(
//            value = "SELECT * FROM animal a WHERE a.status = 1",
//            nativeQuery = true)
//    Collection<Animal> findAllActiveAnimalNative();
    //native query nebegaletume paduoti "sort"

    //findAll(Sort.by(Sort.Direction.ASC, "name"));
    //findAll(Sort.by("LENGTH(name)"));

//    @Query(value = "SELECT a FROM animal a")
//    List<Animal> findAllAnimals(Sort sort);

}
