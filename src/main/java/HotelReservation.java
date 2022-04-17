import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HotelReservation {

    List<String> dateRange = new ArrayList<>();
    List<Hotel> hotelList = new ArrayList<>();

    public HotelReservation() {
        addHotels();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }

    public void reservationRange() {
        dateRange.add("10Sep2020");
        dateRange.add("11Sep2020");
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

    public long calculateCost(LocalDate startDate, LocalDate endDate) {
        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        Optional<Hotel> cheapestHotel = hotelList.stream().min(Comparator.comparing(Hotel::getRates));
        System.out.print(cheapestHotel.get().name + ",");
        return (cheapestHotel.get().weekDayRates * numOfDays);
    }

    public Stream<Hotel> updateWeekendRates() {
        Stream<Hotel> hotel = hotelList.stream().filter(n -> {
            if (n.getRates() == 220) {
                n.setWeekEndRates(150);
                System.out.println("For RidgeWood Weekday & Weekend Rates per day is " + n.getRates() + " & " + n.getWeekEndRates());
                return true;
            } else if ((n.getRates() == 160) && (n.getWeekEndRates() == 0)) {
                n.setWeekEndRates(50);
                System.out.println("For BridgeWood Weekday & Weekend Rates per day is " + n.getRates() + " & " + n.getWeekEndRates());
                return true;
            } else if ((n.getRates() == 110) && (n.getWeekEndRates() == 0)) {
                n.setWeekEndRates(90);
                System.out.println("For LakeWood Weekday & Weekend Rates per day is " + n.getRates() + " & " + n.getWeekEndRates());
                return true;
            }
            return false;
        });
        return hotel;
    }
}
