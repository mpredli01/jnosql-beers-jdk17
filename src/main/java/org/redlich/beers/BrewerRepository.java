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

import java.util.List;


@ApplicationScoped
public interface BrewerRepository extends Repository<Brewer, String> {

    List<Brewer> findAll();

    List<Brewer> findByName(String brewer);

    void deleteById(int id);

    void update(Brewer brewer);
    }
