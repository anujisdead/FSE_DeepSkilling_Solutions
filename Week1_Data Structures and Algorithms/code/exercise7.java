package code;
class Forecast {
    static double futureValue(double current, double rate, int years) {
        if (years == 0) return current;
        return futureValue(current * (1 + rate), rate, years - 1);
    }

    static double futureValueDP(double current, double rate, int years) {
        double result = current;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }
}

class ForecastTest {
    public static void main(String[] args) {
        double currentAmount = 1000;
        double rate = 0.05;
        int years = 10;

        System.out.println("Calculating future value for:");
        System.out.println("Initial Amount: " + currentAmount);
        System.out.println("Rate: " + rate);
        System.out.println("Years: " + years);

        double futureRecursive = Forecast.futureValue(currentAmount, rate, years);
        System.out.println("\nFuture Value (Recursive): " + futureRecursive);

        double futureDP = Forecast.futureValueDP(currentAmount, rate, years);
        System.out.println("Future Value (DP): " + futureDP);
    }
}
