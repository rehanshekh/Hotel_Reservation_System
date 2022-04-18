public class Hotel {
    String name;
    int weekDayRates;
    int weekEndRates;
int ratings;

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Hotel(String name, int rates) {
        this.name = name;
        this.weekDayRates = rates;
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
