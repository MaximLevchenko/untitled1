package MultiThreading;

import java.util.ArrayList;
import java.util.List;
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
                System.out.println("FINISHED");
            } else {
                isFinished = false;
            }
        }
    }
}

class Race {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add(1,"Lanos");
        cars.add(2,"Honda");
        cars.add(3,"Ferrari");
        cars.add(4,"Lamborgini");
        List<Thread> threads = new ArrayList();
        threads.add(new Thread(("Honda")));
        }

        static void startRace(List<Thread>cars){

    }
    }


