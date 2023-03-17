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

import jakarta.nosql.document.DocumentTemplate;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.List;
import java.util.stream.Stream;

public class BeerApp {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            System.out.println();
            System.out.println("*-----------------------------------------------------------------------------*");
            System.out.println("* Craft Beer Database Application                                             *");
            System.out.println("* A demonstration on how to create a Jakarta NoSQL and MongoDB application    *");
            System.out.println("*-----------------------------------------------------------------------------*");
            System.out.println();

            BeerRepository beerRepository = container.select(BeerRepository.class).get();
            BrewerRepository brewerRepository = container.select(BrewerRepository.class).get();

            var beers = beerRepository.findAll();
            var brewers = brewerRepository.findAll();

            long noOfBeers = beerRepository.count();
            long noOfBrewers = brewerRepository.count();

            System.out.println("\n");
            System.out.println("* First, let's get some current statistics on the `Beer` and `Brewer` collections:");
            System.out.println("There are " + noOfBeers + " beers in the `Beer` collection of the database");
            System.out.println("There are " + noOfBrewers + " brewers in the `Brewer` collection of the database" + "\n");

            Brewer brewer01 = Brewer.builder()
                    .id((int)noOfBrewers + 1)
                    .name("Maine Beer Company")
                    .city("Freeport")
                    .state("Maine")
                    .build();
            brewerRepository.save(brewer01);

            Brewer brewer02 = Brewer.builder()
                    .id((int)noOfBrewers + 2)
                    .name("American Icon Brewery")
                    .city("Vero Beach")
                    .state("Florida")
                    .build();
            brewerRepository.save(brewer02);

            System.out.println("* Let's find a specific brewer by name, say, American Icon Brewery:");
            List<Brewer> brewerList = brewerRepository.findByName("American Icon Brewery");
            int brewer_id = brewerList.get(0).getId();
            String brewerName = brewerList.get(0).getName();
            System.out.println(brewerList);
            System.out.println();

            System.out.println("* Let's obtain the `brewerId` of " + brewerName + ":");
            System.out.println("The `brewerId` of " + brewerName + " is " + brewer_id);
            System.out.println();

            System.out.println("* Let's add two new beers from " + brewerName + " using its `brewerId` (" + brewer_id + "):\n");
            Beer beer01 = Beer.builder()
                    .id((int) noOfBeers + 1)
                    .name("Freedom Torch Milk Stout")
                    .type(BeerType.STOUT)
                    .brewer_id(brewer_id)
                    .abv(6.0)
                    .build();
            beerRepository.save(beer01);

            Beer beer02 = Beer.builder()
                    .id((int) noOfBeers + 2)
                    .name("Power Plant Amber Lager")
                    .type(BeerType.LAGER)
                    .brewer_id(brewer_id)
                    .abv(5.4)
                    .build();
            beerRepository.save(beer02);

            System.out.println("* Let's find varieties of beer by " + brewerName + " using its `brewerId` (" + brewer_id + "):");
            Stream<Beer> byBrewerId = beerRepository.findByBrewerId(brewer_id);
            byBrewerId.forEach(beerByBrewer -> System.out.println(beerByBrewer));
            System.out.println();

            System.out.println("* Let's find a specific beer by name, say, Pumking:");
            Stream<Beer> beerStream1 = beerRepository.findByName("Pumking");
            beerStream1.forEach(beer -> System.out.println(beer));
            System.out.println();

            System.out.println("* Let's find brewers by city and state, say, New Orleans, Louisiana:");
            List<Brewer> brewerStream = brewerRepository.findByCityAndState("New Orleans", "Louisiana");
            brewerStream.forEach(brewer -> System.out.println(brewer));
            System.out.println();

            System.out.println("* Let's find beers by ABV greater than 8.0%:");
            List<Beer> beerStream = beerRepository.findByAbv(8.0);
            beerStream.forEach(beered -> System.out.println(beered));
            System.out.println();

            /*/ uncomment this section to delete a beer from the database
            System.out.println("Deleting beer by beer_id...");
            beerRepository.deleteById(21);
            /*/

            /*/ uncomment this section to delete a brewer from the database
            System.out.println("Deleting brewer by brewer_id");
            brewerRepository.deleteById(34);
            /*/

            System.out.println("* Let's find another beer by name using using the query() method:");
            var beerByName = beerRepository.query("Purple Monkey Dishwasher");
            beerByName.forEach(purple -> System.out.println(purple));

            System.out.println("* Let's find brewers from Flemington, New Jersey:");
            var brewerByCity = brewerRepository.query("Flemington");
            brewerByCity.forEach(flemington -> System.out.println(flemington));

            DocumentTemplate template = container.select(DocumentTemplate.class).get();
            System.out.println("* Let's find the second beer in the `Beer` collection and the fourth brewer from the `Brewer` collection:");
            System.out.println(template.find(Beer.class, 2));
            System.out.println(template.find(Brewer.class, 4));
            System.out.println();

            }
        catch(IndexOutOfBoundsException exception) {
            System.out.println("EXCEPTION:");
            System.out.println("The cause was: " + exception.getCause());
            System.out.println("The message is: " + exception.getMessage());
            }
        }

    private BeerApp() {
        }
    }
