import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class HotelReservationTest {
    HotelReservation reservation = new HotelReservation();
    Stream<Hotel> hotel = reservation.updateWeekendRates();

    @Test
    @Order(value = 1)
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
    public void givenDateRangeWithWeekDayWeekEnd_ShouldReturn_CheapestHotel() {
        int count = 1;
        WhenAddedHotelData_ToHotelReservationSystem_ShouldNotReturnNull();
        givenDateRange_ShouldReturn_CheapestHotel();
        WhenAddedRates_ToEachHotel_ShouldUpdateIt();
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 13);
        String cheapestHotel = reservation.getCheapestHotel(startDate, endDate, count);
        Assert.assertEquals("LakeWood", cheapestHotel);
        count++;
        cheapestHotel = reservation.getCheapestHotel(startDate, endDate, count);
        Assert.assertEquals("BridgeWood", cheapestHotel);
    }

    @Test
    public void WhenAddedRatings_ShouldUpdate_EachHotel() {
        givenDateRangeWithWeekDayWeekEnd_ShouldReturn_CheapestHotel();
        ArrayList<Hotel> ratedList = reservation.updateRatings();
        for (Hotel hotel : ratedList) {
            switch (hotel.getName()) {
                case "LakeWood" -> Assert.assertEquals(3, hotel.getRatings());
                case "BridgeWood" -> Assert.assertEquals(4, hotel.getRatings());
                case "RidgeWood" -> Assert.assertEquals(5, hotel.getRatings());
            }
        }
    }

    @Test
    public void givenDateRange_ShouldReturn_bestRatedHotel() {
        WhenAddedRatings_ShouldUpdate_EachHotel();
        Hotel cheapestRatedHotel = reservation.getCheapestRatedHotel();
        Assert.assertEquals("BridgeWood", cheapestRatedHotel.getName());

    }

    @Test
    public void WhenAddedSpecialRates_ShouldUpdate_EachHotel() {
        givenDateRange_ShouldReturn_bestRatedHotel();
        ArrayList<Hotel> specialList = reservation.updateSpecialRates();
        for (Hotel hotel : specialList) {
            switch (hotel.getName()) {
                case "LakeWood" -> {
                    Assert.assertEquals(80, hotel.getSpecialWeekdayRates());
                    Assert.assertEquals(80, hotel.getSpecialWeekendRates());
                }
                case "BridgeWood" -> {
                    Assert.assertEquals(110, hotel.getSpecialWeekdayRates());
                    Assert.assertEquals(50, hotel.getSpecialWeekendRates());
                }

                case "RidgeWood" -> {
                    Assert.assertEquals(100, hotel.getSpecialWeekdayRates());
                    Assert.assertEquals(40, hotel.getSpecialWeekendRates());
                }
            }
        }
    }
}
