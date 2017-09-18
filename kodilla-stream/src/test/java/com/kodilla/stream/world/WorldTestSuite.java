package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //given


            //asia
            //Rosja celowo zarówno w Azji jak i w Europie
        Country country1 = new Country("Rosja", new BigDecimal("142470272"));
        Country country2 = new Country("Chiny", new BigDecimal("1330044605"));
        Country country3 = new Country("Indie", new BigDecimal("1147996000"));

            //europa
        Country country4 = new Country("Rosja", new BigDecimal("142470272"));
        Country country5 = new Country("Dania", new BigDecimal("5569077"));
        Country country6 = new Country("Serbia", new BigDecimal("7209764"));

            //south america
        Country country7 = new Country("Brazylia", new BigDecimal("203429773"));
        Country country8 = new Country("Meksyk", new BigDecimal("113724226"));
        Country country9 = new Country("Ekwador", new BigDecimal("15007343"));

        List<Country> asiaList = new ArrayList<>();
        asiaList.add(country1);
        asiaList.add(country2);
        asiaList.add(country3);

        List<Country> europaList = new ArrayList<>();
        asiaList.add(country4);
        asiaList.add(country5);
        asiaList.add(country6);

        List<Country> southAmericaList = new ArrayList<>();
        asiaList.add(country7);
        asiaList.add(country8);
        asiaList.add(country9);

        Continent asia = new Continent(asiaList);
        Continent europa = new Continent(asiaList);
        Continent southAmerica = new Continent(asiaList);

        List<Continent> worldList = new ArrayList<>();
        worldList.add(asia);
        worldList.add(europa);
        worldList.add(southAmerica);

        World world = new World(worldList);

        //when
        BigDecimal peopleAllAroundTheWorld = world.getPeopleQuantity();

        //then  //w tej liczbie ludność Rosji jest tylko raz
        Assert.assertEquals(new BigDecimal("2965451060"),peopleAllAroundTheWorld);




    }



}
