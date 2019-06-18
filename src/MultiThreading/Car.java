package MultiThreading;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
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
    private static final double METERS_PER_SEC = 1000d / 3600;
    private static final int ONE_SEC_MILLIS = 1000;

    public long getFinishTime() {
        return FinishTime / ONE_SEC_MILLIS;
    }

    int FinishTime;

    public RaceCarRunnable(String name, int maxSpeed, CountDownLatch countDownLatch, int passedDistance, int distance,
                           boolean isFinished, int FinishTime) {
        super(name, maxSpeed);
        this.countDownLatch = countDownLatch;
        this.passedDistance = passedDistance;
        this.distance = distance;
        this.isFinished = isFinished;
        this.FinishTime = FinishTime;

    }

    private CountDownLatch countDownLatch;
    int passedDistance;
    int distance;
    boolean isFinished;

    public RaceCarRunnable(Car raceCar, int distance, CountDownLatch countDownLatch) {
        super(raceCar.getName(), raceCar.getMaxSpeed());
        this.distance = distance;
        this.countDownLatch = countDownLatch;
    }


    public int getRandomSpeed() {


        return ThreadLocalRandom.current().nextInt(getMaxSpeed() / 2, getMaxSpeed());
    }

    @Override
    public void run() {

        while (!isFinished) {
            FinishTime = (int) (System.currentTimeMillis() - Race.startRaceTime.get());
            int currentSpeed = getRandomSpeed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            passedDistance += (currentSpeed * 1000 / (60 * 60));


            if (passedDistance >= distance) {
                isFinished = true;
                countDownLatch.countDown();
                System.out.println(getName() + " " + "HAVE FINISHED");
            } else {
                System.out.println("CARNAME:" + " " + getName() + " " + "|CARSPEED:" + currentSpeed + " " + "|CARPROGRESS:" + " "
                        + passedDistance + " " + distance+"\t"+"TIME"+" "+getFinishTime());
            }
        }
    }


}

class Race {
    static AtomicLong startRaceTime;

    public static void main(String[] args) {
        final int distance = 1000;
        final ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", 250));
        cars.add(new Car("Lamborgini", 400));
        cars.add(new Car("Ferrari", 350));
        cars.add(new Car("Lanos", 220));
        CountDownLatch countDownLatch = new CountDownLatch(cars.size());
        List<RaceCarRunnable> raceCarRunnables = new ArrayList<>();
        cars.forEach(raceCar -> raceCarRunnables.add((new RaceCarRunnable(raceCar, distance, countDownLatch))));
        List<Thread> threads = new ArrayList();
        raceCarRunnables.forEach(raceCar -> threads.add(new Thread(raceCar)));
        startRace(threads);

        try {
            countDownLatch.await();
            System.out.println("=================== RACE OVER! ======================");
            System.out.println("!!!!!!!!!!!!! WINNER: " + defineWinner(raceCarRunnables).getName() + " !!!!!!!!!!!!!!!");
        } catch (InterruptedException ex) {
            System.err.print(ex);
        }

    }

    private static RaceCarRunnable defineWinner(final List<RaceCarRunnable> raceCarRunnables) {
        return raceCarRunnables.stream()
                .min(Comparator.comparingLong(RaceCarRunnable::getFinishTime))
                .orElseThrow(NoSuchElementException::new);
    }


    static void startRace(List<Thread> cars) {
        new Thread(() -> {
            try {

                System.out.println("3...");
                Thread.sleep(500);
                System.out.println("2...");
                Thread.sleep(500);
                System.out.println("1...");
                Thread.sleep(500);
                System.out.println("GO!!!");
                Thread.sleep(500);


                startRaceTime = new AtomicLong(System.currentTimeMillis());

                synchronized (cars) {
                    for (Thread car : cars) {
                        car.start();
                    }
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        ).start();
    }
}



