import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
    Scanner in = new Scanner(System.in);
    List<String> dateRange = new ArrayList<>();
    List<Hotel> hotelList = new ArrayList<>();

    public HotelReservation() {
        addHotels();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }

    public void reservationRange(int range) {
        for (int i = 1; i <= range; i++) {
            System.out.println("Enter the " + i + " date of stay");
            dateRange.add(in.next());
        }
    }

    private void addHotels() {
        Hotel Hotel1 = new Hotel("LakeWood", 110);
        hotelList.add(Hotel1);
        Hotel Hotel2 = new Hotel("BridgeWood", 160);
        hotelList.add(Hotel2);
        Hotel Hotel3 = new Hotel("RidgeWood", 220);
        hotelList.add(Hotel3);
    }

    public List getList() {
        return hotelList;
    }

}

