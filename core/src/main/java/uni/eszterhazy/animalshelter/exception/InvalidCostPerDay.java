package uni.eszterhazy.animalshelter.exception;

public class InvalidCostPerDay extends Throwable{

    public InvalidCostPerDay(String costPerDay) {
        super(costPerDay);
    }
}
