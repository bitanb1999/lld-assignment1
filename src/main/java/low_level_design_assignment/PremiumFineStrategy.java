class PremiumFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(long overdueDays) {
        return overdueDays * 0.5; // Premium members get a 50% discount
    }
}
