import java.util.*;

public class Problem8_ParkingLot {

    static String[] parking = new String[10];

    public static void parkVehicle(String plate){

        int index = Math.abs(plate.hashCode()) % parking.length;

        while(parking[index] != null){
            index = (index + 1) % parking.length;
        }

        parking[index] = plate;
        System.out.println("Vehicle " + plate + " parked at spot " + index);
    }

    public static void exitVehicle(String plate){

        for(int i=0;i<parking.length;i++){
            if(plate.equals(parking[i])){
                parking[i] = null;
                System.out.println("Vehicle " + plate + " exited from spot " + i);
            }
        }
    }

    public static void main(String[] args){

        parkVehicle("ABC123");
        parkVehicle("XYZ999");
        exitVehicle("ABC123");
    }
}