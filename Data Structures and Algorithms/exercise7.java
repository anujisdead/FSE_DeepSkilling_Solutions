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
