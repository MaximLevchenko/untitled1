package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

    public RaceCarRunnable(String name, int maxSpeed, int passedDistance, int distance, boolean isFinished) {
        super(name, maxSpeed);
        this.passedDistance = passedDistance;
        this.distance = distance;
        this.isFinished = isFinished;
    }

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
            } else {
                isFinished = false;
            }
        }
    }
}

class Race {
    public static void main(String[] args) {
        List<RaceCarRunnable> cars = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
    }
}
