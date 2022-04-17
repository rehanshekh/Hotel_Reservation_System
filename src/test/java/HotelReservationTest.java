import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class HotelReservationTest {
    HotelReservation reservation = new HotelReservation();

    @Test
    public void WhenAddedHotelData_ToHotelReservationSystem_ShouldNotReturnNull() {
        List<Hotel> hotels = reservation.getList();
        for (Hotel hotel : hotels) {
            System.out.println("Added Hotel " + hotel.getName() + " to Hotel Reservation System");
            Assert.assertNotNull(hotel);
        }
    }
    @Test
    public void givenDateRange_ShouldReturn_CheapestHotel() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        long lowestRate = reservation.calculateCost(startDate, endDate);
        System.out.print("Total Rates: "+lowestRate);
        Assert.assertEquals(220,lowestRate);
    }
}
