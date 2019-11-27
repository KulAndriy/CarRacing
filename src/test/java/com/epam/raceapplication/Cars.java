package com.epam.raceapplication;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private int carNum;
    private List<Integer> speedEachSecond = new ArrayList<Integer>();
    private int averageSpeed;

    public void setSpeedEachSecond(int speedEachSecond) {
        this.speedEachSecond.add(speedEachSecond);
    }

    public List getSpeedEachSecond() {
        return speedEachSecond;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public void setAverageSpeed() {
        int sum = 0;
        for (Integer sps : speedEachSecond) {
            sum += sps;
        }
        this.averageSpeed = sum / speedEachSecond.size();
    }

    public double getAvarageSpeed() {
        int sum = 0;
        for (Integer sps : speedEachSecond) {
            sum += sps;
        }
        return sum / speedEachSecond.size();
    }
}
