public class Hotel {
    String name;
    int weekDayRates;
    int weekEndRates;
    int ratings;
    int specialWeekdayRates;

    public int getSpecialWeekendRates() {
        return specialWeekendRates;
    }

    public void setSpecialWeekendRates(int specialWeekendRates) {
        this.specialWeekendRates = specialWeekendRates;
    }

    public int getSpecialWeekdayRates() {
        return specialWeekdayRates;
    }

    public void setSpecialWeekdayRates(int specialWeekdayRates) {
        this.specialWeekdayRates = specialWeekdayRates;
    }

    int specialWeekendRates;

    public Hotel(String name, int rates) {
        this.name = name;
        this.weekDayRates = rates;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getWeekEndRates() {
        return weekEndRates;
    }

    public void setWeekEndRates(int weekEndRates) {
        this.weekEndRates = weekEndRates;
    }

    public String getName() {
        return name;
    }

    public int getRates() {
        return weekDayRates;
    }
}
