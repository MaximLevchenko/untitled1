package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Levchenko Maksym on 13.06.2019.
 */
class Car {
    String name;
    int maxSpeed;

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

class RaceCarRunnable extends Car implements Runnable {

    public RaceCarRunnable(String name, int maxSpeed, CountDownLatch countDownLatch, int passedDistance, int distance, boolean isFinished) {
        super(name, maxSpeed);
        this.countDownLatch = countDownLatch;
        this.passedDistance = passedDistance;
        this.distance = distance;
        this.isFinished = isFinished;
    }

    private final CountDownLatch countDownLatch;
    int passedDistance;
    int distance;
    boolean isFinished;

    public int getRandomSpeed() {


        return ThreadLocalRandom.current().nextInt(10, 50);
    }

    @Override
    public void run() {


        while (!isFinished) {
            int currentSpeed = getRandomSpeed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("carName:" + getName() + "carSpeed:" + currentSpeed + "carProgress:" + passedDistance + " "
                    + distance);
            passedDistance += (currentSpeed * 1000 / (60 * 60));
            if (passedDistance >= distance) {
                isFinished = true;
                System.out.println("FINISHED");
            } else {
                System.out.println(this);
            }
        }
    }
}

public class Race {
    public static void main(String[] args) {
        final ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", 250)));
        cars.add(new Car("Lamborgini", 400));
        cars.add(new Car("Ferrari", 350));
        cars.add(new Car("Lanos", 220));
        final CountDownLatch countDownLatch = new CountDownLatch(cars.size());
        final ArrayList<RaceCarRunnable>raceCarRunnables=new ArrayList<>();
        raceCarRunnables.forEach(raceCar->raceCarRunnables.add((new RaceCarRunnable(raceCar, distance, countDownLatch))));
        final List<Thread> threads = new ArrayList();

    }

    static void startRace(List<Thread> cars) {

    }
}


