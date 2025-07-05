/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package luti.taxcategoryvat;

/**
 *
 * @author LUTS
 */
public class TaxCategoryVAT {

   
    static abstract class TaxCategory {
        protected double vatRate;

        public TaxCategory(double vatRate) {
            this.vatRate = vatRate;
        }

        public abstract double calculateVAT(double amount);

        public double getVatRate() {
            return vatRate;
        }
    }

    static class Retailer extends TaxCategory {
        public Retailer() {
            super(0.18); 
        }

        @Override
        public double calculateVAT(double amount) {
            System.out.printf("  (Retailer @ %.0f%%) ", this.vatRate * 100);
            return amount * this.vatRate;
        }
    }

    static class Wholesaler extends TaxCategory {
        public Wholesaler() {
            super(0.15); 
        }

        @Override
        public double calculateVAT(double amount) {
            System.out.printf("  (Wholesaler @ %.0f%%) ", this.vatRate * 100);
            return amount * this.vatRate;
        }
    }

    static class Importer extends TaxCategory {
        public Importer() {
            super(0.10);
        }

        @Override
        public double calculateVAT(double amount) {
            System.out.printf("  (Importer @ %.0f%%) ", this.vatRate * 100);
            return amount * this.vatRate;
        }
    }

    public static void main(String[] args) {
        // Create an array of TaxCategory objects
        TaxCategory[] taxpayerCategories = new TaxCategory[3];
        taxpayerCategories[0] = new Retailer();
        taxpayerCategories[1] = new Wholesaler();
        taxpayerCategories[2] = new Importer();

        double[] transactionAmounts = {1000.0, 500.0, 2000.0};

        System.out.println("Demonstrating VAT Calculation using Polymorphism:\n");

        for (int i = 0; i < taxpayerCategories.length; i++) {
            TaxCategory category = taxpayerCategories[i];
            double amount = transactionAmounts[i]; 

            System.out.printf("Calculating VAT for transaction amount %.2f for %s:%n", amount, category.getClass().getSimpleName());
            double vat = category.calculateVAT(amount); // Polymorphic call
            System.out.printf("  Calculated VAT: %.2f%n%n", vat);
        }

        
        System.out.println("\nAnother round of calculations:");
        System.out.println("Retailer VAT for 750.0: " + taxpayerCategories[0].calculateVAT(750.0));
        System.out.println("Wholesaler VAT for 1200.0: " + taxpayerCategories[1].calculateVAT(1200.0));
        System.out.println("Importer VAT for 3000.0: " + taxpayerCategories[2].calculateVAT(3000.0));
    }
}
