public class Hotel {
    String name;
    int weekDayRates;
    int weekEndRates;

    public int getWeekEndRates() {
        return weekEndRates;
    }

    public void setWeekEndRates(int weekEndRates) {
        this.weekEndRates = weekEndRates;
    }

    public Hotel (String name, int rates){
        this.name=name;
        this.weekDayRates=rates;
    }

    public String getName() {
        return name;
    }

    public int getRates() {
        return weekDayRates;
    }
}
