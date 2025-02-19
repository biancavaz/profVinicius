package org.example;

import Discount.DiscountServiceInterface;
import Discount.VIPImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DiscountServiceInterface discount = new VIPImpl();
    }
}