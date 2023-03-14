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

import jakarta.data.repository.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

@ApplicationScoped
public interface BeerRepository extends Repository<Beer, Integer> {

    Stream<Beer> findAll();

    Stream<Beer> findByName(String beer);

    Stream<Beer> findByBrewerId(int brewer_id);
    }
