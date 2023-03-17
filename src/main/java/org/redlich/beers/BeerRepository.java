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
public interface BeerRepository extends CrudRepository<Beer, Integer> {

    @Query("select * from Beer where name = @name")
    List<Beer> query(@Param("name") String name);

    Stream<Beer> findAll();

    Stream<Beer> findByName(String beer);

    List<Beer> findByAbv(double abv);

    Stream<Beer> findByBrewerId(int brewer_id);

    void deleteById(int id);

    void update(Brewer brewer);

}
