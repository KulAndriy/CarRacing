package com.epam.race_thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private List<Integer> speedEachSecond = new ArrayList<Integer>();
    private int carNumber;
    private List<Integer> position = new ArrayList<Integer>();
    private int averageSpeed;

//    Race race =new Race();

//    Score score =new Score();

    public int getCarNumber() {
        return carNumber;
    }
    //
    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public synchronized void setAverageSpeed (){
        int sum = 0;
        for (Integer sps: speedEachSecond){
            sum += sps;
        }
        this.averageSpeed = sum/speedEachSecond.size();
    }

    public synchronized double getAverageSpeed(){
        int sum = 0;
        for (Integer sps: speedEachSecond){
            sum += sps;
        }
        return sum/speedEachSecond.size();
    }
    public synchronized List listAverageSpeed(){
        return Collections.singletonList(getAverageSpeed());
    }

    public List printAvSpeed(){
        for(int i=0;i<listAverageSpeed().size();i++){
            System.out.println(listAverageSpeed().size());
        }
        return printAvSpeed();
    }

    public synchronized void addSpeedEachSecond(int speedEachSecond) {
        this.speedEachSecond.add(speedEachSecond);
    }

    public synchronized List getSpeedEachSecond() {
        return speedEachSecond;
    }

    public void printFirstPlaces (int numberOfPlaces) {
//        for (int i = 0; i<numberOfPlaces; i++) {
//            int place = i+1;
//        System.out.println("The car " + getCarNumber() + " on position " + getPosition() + " with speeds per seconds " + getSpeedEachSecond());
//        System.out.println("The car " + getCarNumber() + " finished race with average speed " + sortCarsNumberBySpeed(listAverageSpeed())  + " and speeds per seconds " + getSpeedEachSecond());
//        System.out.println(" ");
        System.out.println("The car " + getCarNumber() + " finished race with average speed " + getAverageSpeed()  + " and speeds per seconds " + getSpeedEachSecond() );
//        }
    }

    public List<Cars> sortCarsNumberBySpeed(List<Cars> carsSpeed) {
        carsSpeed.sort(Comparator.comparing(Cars::getAverageSpeed).reversed());
        return carsSpeed;
    }
//    public synchronized void addPosition(int pos) {
//        this.position.add(pos);
//    }
//
//    public synchronized List getPosition() {
//        return position;
//    }
}
