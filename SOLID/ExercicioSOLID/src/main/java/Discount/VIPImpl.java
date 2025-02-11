package Discount;

public class VIPImpl implements DiscountServiceInterface {

    @Override
    public double calculateDiscount(double total, String customerType){

        return 500;
    }
}
