import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;


@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class HotelReservationTest {
    HotelReservation reservation = new HotelReservation();
    Stream<Hotel> hotel = reservation.updateWeekendRates();

    @Test
    @Order(value=1)
    public void WhenAddedHotelData_ToHotelReservationSystem_ShouldNotReturnNull() {
        List<Hotel> hotels = reservation.getList();
        for (Hotel hotel : hotels) {
            System.out.println("Added Hotel " + hotel.getName() + " to Hotel Reservation System");
            Assert.assertNotNull(hotel);
        }
    }

    @Test
    @Order(value = 2)
    public void givenDateRange_ShouldReturn_CheapestHotel() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        long lowestRate = reservation.calculateCost(startDate, endDate);
        System.out.print("Total Rates: " + lowestRate);
        System.out.println();
        Assert.assertEquals(220, lowestRate);
    }

    @Test
    @Order(value = 3)
    public void WhenAddedRates_ToEachHotel_ShouldUpdateIt() {
        hotel = reservation.updateWeekendRates();
        Assert.assertEquals(90, hotel.findFirst().get().getWeekEndRates());
        hotel = reservation.updateWeekendRates();
        Assert.assertEquals(50, hotel.findFirst().get().getWeekEndRates());
        hotel = reservation.updateWeekendRates();
        Assert.assertEquals(150, hotel.findFirst().get().getWeekEndRates());
    }


    @Test
    @Order(4)
    public void ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ() {
        int count=1;
        WhenAddedHotelData_ToHotelReservationSystem_ShouldNotReturnNull();
        givenDateRange_ShouldReturn_CheapestHotel();
        WhenAddedRates_ToEachHotel_ShouldUpdateIt();
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 13);
        String cheapestHotel = reservation.getCheapestHotel(startDate, endDate, count);
        Assert.assertEquals("LakeWood", cheapestHotel);
        count++;
        cheapestHotel = reservation.getCheapestHotel(startDate,endDate,count);
        Assert.assertEquals("BridgeWood",cheapestHotel);
    }

}
