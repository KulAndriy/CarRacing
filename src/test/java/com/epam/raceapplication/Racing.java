package com.epam.raceapplication;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Racing {

    final static int raceTime = 20;

    public static void main(String[] args) {
        final int numOfCars = 10;

        List<CompletableFuture<Cars>> carsTasks = new ArrayList<>(); // список из 100 ссылок

        for (int i = 1; i <= numOfCars; i++) {
            carsTasks.add(downloadCars(i));
        }

    // Создаём комбинированный Future, используя allOf()
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(carsTasks.toArray(new CompletableFuture[carsTasks.size()])
                );

    // Когда все задачи завершены, вызываем future.join(), чтобы получить результаты и собрать их в список
        CompletableFuture<List<Cars>> allcarsFuture = allFutures.thenApply(v -> carsTasks.stream()
                .map(carsCompletableFuture -> carsCompletableFuture.join())
                .collect(Collectors.toList()));
        List<Cars> collectResults = allcarsFuture.join();

        collectResults.forEach(averSp -> averSp.setAverageSpeed());

        collectResults = sortCarsNumberBySpeed(collectResults);

        collectResults.forEach(print -> System.out.println("The car " + print.getCarNum() + " finished race with average speed " + print.getAvarageSpeed()));

        showScore(3, collectResults);
        allFutures.cancel(true);
    }

    private static CompletableFuture<Cars> downloadCars(final int carNum) {
        CompletableFuture<Cars> completableFuture = CompletableFuture.supplyAsync(() -> {
            Random rand = new Random();
            Cars car = new Cars();
            car.setCarNum(carNum);
            for (int i = 1; i <= raceTime; i++) {
                car.setSpeedEachSecond(rand.nextInt(200) + 1);
                delay();
            }
            return car; // Код загрузки и возврата содержимого веб-страницы
        });
        return completableFuture;
    }

    private static List<Cars> sortCarsNumberBySpeed(List<Cars> carsSpeed) {
        carsSpeed.sort(Comparator.comparing(Cars::getAvarageSpeed).reversed());
        return carsSpeed;
    }

    private static void showScore(int numberPlaces, List<Cars> scoreList) {
        for (int i = 0; i < numberPlaces; i++) {
            int place = i + 1;
            System.out.println("The car " + scoreList.get(i).getCarNum() + " on the " + place + " place" + " with speeds per seconds " + scoreList.get(i).getSpeedEachSecond());
        }
    }

    private static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
