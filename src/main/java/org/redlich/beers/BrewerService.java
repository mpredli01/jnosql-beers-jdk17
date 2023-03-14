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
import jakarta.nosql.mapping.document.DocumentTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.stream.Stream;

import static jakarta.nosql.document.DocumentQuery.select;

@ApplicationScoped
public class BrewerService {

    @Inject
    private DocumentTemplate template;

    public Brewer insert(Brewer brewer) {
        return template.insert(brewer);
        }

    public Stream<Beer> findByName(String name) {
        DocumentQuery query = select()
                .from("Brewer")
                .where("name")
                .eq(name)
                .build();
        return template.select(query);
        }

    public Stream<Brewer> findByCityAndState(String city, String state) {
        DocumentQuery query = select()
                .from("Brewer")
                .where("city")
                .eq(city)
                .and("state")
                .eq(state)
                .build();
        return template.select(query);
        }
    }
