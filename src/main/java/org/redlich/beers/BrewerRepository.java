/*
 * Craft Beer Database Application
 * This demo application is featured in the `Getting Started with Jakarta NoSQL and MongoDB presentation`
 *
 * @author Otávio Santana
 * @author Michael P. Redlich
 *
 * @version 1.0.5
 */

package org.redlich.beers;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface BrewerRepository extends CrudRepository<Brewer, String> {

    @Query("select * from Brewer where city = @city")
    List<Brewer> query(@Param("city") String name);

    Stream<Brewer> findAll();

    List<Brewer> findByName(String brewer);

    List<Brewer> findByCityAndState(String city, String state);

    void deleteById(int id);

    void update(Brewer brewer);
    }
