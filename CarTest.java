//Prototype implementation of Car Test class
//Mandatory assignment
//Course 02158 Concurrent Programming, DTU, Fall 2019

//Hans Henrik Lovengreen       Oct 8, 2019

public class CarTest extends Thread {

    CarTestingI cars;
    int testno;

    public CarTest(CarTestingI ct, int no) {
        cars = ct;
        testno = no;
    }

    public void run() {
        try {
            switch (testno) { 
            case 0:
                // Demonstration of startAll/stopAll.
                // Should let the cars go one round (unless very fast)
                cars.startAll();
                sleep(3000);
                cars.stopAll();
                break;

            case 1:
                // Demonstration of Remove/Restore car at the same spot.
                // The resulting behavior shows that a car being removed will be restored at the previous spot that it
                // was removed from.
                cars.startAll();
                sleep(2000);
                cars.removeCar(6);
                sleep(3000);
                cars.restoreCar(6);
                break;

            case 2:
                // Demonstration of Remove/Restore car at the same spot inside the alley.
                // The resulting behavior shows that the car can be restored inside the alley without problems.
                cars.startAll();
                sleep(7000);
                cars.removeCar(6);
                sleep(4000);
                cars.restoreCar(6);
                break;



            case 19:
                // Demonstration of speed setting.
                cars.println("Setting high speeds");
                for (int i = 1; i < 9; i++) {
                    cars.setSpeed(i,20.0);
                    cars.setVariation(i,20);
                };
                break;

            default:
                cars.println("Test " + testno + " not available");
            }

            cars.println("Test ended");

        } catch (Exception e) {
            System.err.println("Exception in test: "+e);
        }
    }

}



