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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Service {

    @Inject
    private BeerRepository beerRepository;

    @Inject
    private BrewerRepository brewerRepository;

    public BeerRepository getBeerRepository() {
        return beerRepository;
        }

    public BrewerRepository getBrewerRepository() {
        return brewerRepository;
        }
    }
