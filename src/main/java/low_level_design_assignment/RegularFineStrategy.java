class RegularFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(long overdueDays) {
        return overdueDays * 1.0; // Regular fine is $1 per day
    }
}


