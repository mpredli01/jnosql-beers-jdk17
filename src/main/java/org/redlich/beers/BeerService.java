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

import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.document.DocumentTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.stream.Stream;

import static jakarta.nosql.document.DocumentQuery.select;

@ApplicationScoped
public class BeerService {

    @Inject
    private DocumentTemplate template;

    public Beer insert(Beer beer) {
        return template.insert(beer);
        }

    public Stream<Beer> findByName(String name) {
        DocumentQuery query = select()
                .from("Beer")
                .where("name")
                .eq(name)
                .build();
        return template.select(query);
        }

    public Stream<Beer> findByBrewerId(int brewer_id) {
        DocumentQuery query = select()
                .from("Beer")
                .where("brewer_id")
                .eq(brewer_id)
                .build();
        return template.select(query);
        }

    public Stream<Beer> findByAbv(double abv) {
        DocumentQuery query = select()
                .from(Beer.class.getSimpleName())
                .where("abv")
                .gt(abv)
                .build();
        return template.select(query);
        }
    }
