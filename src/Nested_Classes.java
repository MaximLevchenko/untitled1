class GameConsole {
    String brand;
    String model;
    String serial;
    boolean isOn;
    Gamepad firstGamepad ;
    Gamepad secondGamepad ;

    public GameConsole(String brand, String model, String serial ) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.firstGamepad =new Gamepad( brand, 1 );;
        this.secondGamepad = new Gamepad(brand, 2) ;
    }

    class Gamepad {
        String brand;
        String consoleSerial;
        int connectedNumber;
        String color;
        int chargeLevel = 100;
        boolean isOn;

        public Gamepad(String brand, int connectedNumber)
                        {
            this.brand = brand;
            this.consoleSerial =serial;
            this.connectedNumber = connectedNumber;
        }


    }

    public static void main(String[] args) {

    }

}




