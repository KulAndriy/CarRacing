package com.epam.race_thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunRace {

    private final static int NUM_CARS = 10;

    public static void main(String[] args) throws InterruptedException {

        Race race = new Race();
        Cars cars =new Cars();
        race.runners();
//        race.run();


//        cars.printAvSpeed();

        ArrayList<Race> runnersList = new ArrayList<Race>(Arrays.asList(new Race[NUM_CARS]));
        int po = 0;

        /*for (Race i : runners ){
            cars.setAverageSpeed();
        }*/
//        Arrays.sort(runners);

//    private static RacingCar1 createRace(int carNumber){
//        RacingCar1 racingCar1 = new RacingCar1();
//
//        racingCar1.setCarNumber(carNumber);
//
//        return racingCar1;
//    }
//        cars.printFirstPlaces(2);
    }



}
