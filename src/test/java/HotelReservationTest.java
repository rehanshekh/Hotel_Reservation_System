import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

public class HotelReservationTest {
    HotelReservation reservation = new HotelReservation();
    Stream<Hotel> hotel =reservation.updateWeekendRates();
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
        System.out.print("Total Rates: " + lowestRate);
        Assert.assertEquals(220, lowestRate);
    }

    @Test
    public void WhenAddedRates_ToEachHotel_ShouldUpdateIt() {

        hotel =  reservation.updateWeekendRates();
        Assert.assertEquals(90, hotel.findFirst().get().getWeekEndRates());
        hotel =  reservation.updateWeekendRates();
        Assert.assertEquals(50, hotel.findFirst().get().getWeekEndRates());
        hotel =  reservation.updateWeekendRates();
        Assert.assertEquals(150, hotel.findFirst().get().getWeekEndRates());
    }
}
