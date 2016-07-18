package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee!
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCups) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCups);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nAdd whipped cream?" + addWhippedCream;
        priceMessage += "\nAdd chocolate?" + addChocolate;
        priceMessage += "\nQuantity: " + quantity + "\n";
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method is called when the plus or minus button is clicked.
     */
    public void increase(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrease(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}