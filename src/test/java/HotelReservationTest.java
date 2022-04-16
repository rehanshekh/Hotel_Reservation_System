import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class HotelReservationTest {
    Scanner in = new Scanner(System.in);
    HotelReservation reservation = new HotelReservation();

    @Test
    public void WhenAddedHotelData_ToHotelReservationSystem_ShouldNotReturnNull() {
        List<Hotel> hotels = reservation.getList();
        for (Hotel hotel : hotels) {
            System.out.println("Added Hotel " + hotel.getName() + " to Hotel Reservation System");
            Assert.assertNotNull(hotel);
        }
    }
}
