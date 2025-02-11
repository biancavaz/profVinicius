package Discount;

public class NormalImpl implements DiscountServiceInterface {

    @Override
    public double calculateDiscount(double total, String customerType) {
        return total * 0.05;
    }
}
