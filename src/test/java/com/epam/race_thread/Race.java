package com.epam.race_thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Race extends Thread {
    private int time = 5;
    private int averageSpeed;
    private int pos;
    final static int NUM_CARS = 10;


//    Cars cars = new Cars();
Cars cars = new Cars();
    public void runners() throws InterruptedException {
        Race [] runners = new Race [NUM_CARS + 1];
        List<Race> list = new CopyOnWriteArrayList<>(runners);
        ;
        Cars cars = new Cars();
        for (int i = 1; i <= NUM_CARS; i++) {

            runners[i] = new Race();
            list = new CopyOnWriteArrayList<>(runners);
            list.get(i).start();
            list.get(i).cars.setCarNumber(i);

//            runners[i].start();
//            runners[i].cars.setCarNumber(i);
//            numbersList = Arrays.asList(runners);
//            List<Race[]> records = (List<Race[]>) Arrays.asList(runners);
//            Arrays.sort(runners);

//            runners[i].cars.addPosition(i);
//            cars.addPosition(i);
//            cars.printFirstPlaces(2);

        }
        for (int i = 1; i <= NUM_CARS; i++) {
            list.get(i).join();
//            try {
//                runners[i].join();

//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            numbersList.get(i).start();

//            Arrays.sort(runners).;

//            cars.printFirstPlaces(2);
//            runnersList.get(i).join();
        }

    }

    @Override
    public void run() {
//runners();

        Random ran = new Random();
//        cars.setCarNumber(cars.getCarNumber());
//        Score score = new Score();
//        Arrays.sort(runners);

        System.out.println(cars.getCarNumber() + " is start running.");
        for (int i = 1; i <= time; i++) {
            try {
                cars.addSpeedEachSecond(ran.nextInt(100) + 1);
//                pos++;
//                score.position++;
//                cars.addPosition(score.position);
//                simulateDelay();
//                score.position++;
//                score.setPlaces(score.position);
//                timeArray[i][i] = s;
//                speedArray[i] = s;

                cars.setAverageSpeed();
                cars.listAverageSpeed();
                cars.sortCarsNumberBySpeed(cars.listAverageSpeed());
//                List<int[]> records = Arrays.asList(ru);
//                Arrays.sort(new int[]{i});
//                System.out.println(score.position);
//                if (score.winner == false) {
//                System.out.println("The car " + cars.getCarNumber() + " on position " + score.position + " with speeds per seconds " + cars.getSpeedEachSecond());

                Thread.sleep(1000);        //Приостанавливает поток на 1 секунду

            } catch (InterruptedException e) {
            }

//                System.out.println(speedArray[i]);
//                System.out.println("яйцо!" + Thread.currentThread().getName());
        }

        synchronized (cars) {
            cars.sortCarsNumberBySpeed(cars.listAverageSpeed());
            cars.printFirstPlaces(2);
//            cars.printAvSpeed();
//            cars.sortCarsNumberBySpeed(cars.listAverageSpeed());
        }

//        synchronized (score) {
//            score.announceWinner(getCarNumber());
//            score.printFirstPlaces(2);
//        score.announceWinner(getCarNumber());
//        }
//        cars.printFirstPlaces(2);
    }


    private static void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

