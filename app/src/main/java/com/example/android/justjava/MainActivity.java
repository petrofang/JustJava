package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */


public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int pricePer = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }

    //  protected void onPause(){};

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int total = calculatePrice(quantity, pricePer);
        String orderSummary = createOrderSummary(total);
        displayMessage(orderSummary);
    }

    public String createOrderSummary(int price) {
        String orderSummary
                = "Name: " + "g-User #000023\n"
                + "Quantity: " + quantity + "\n"
                + "Total: " + price + "\n"
                + "Thank you";
        return orderSummary;
    }

    /**
     * learning about methods
     *
     * @param howMany is the number being ordered
     * @param howMuch is the price per unit
     */
    private int calculatePrice(int howMany, int howMuch) {
        return howMuch * howMany;
    }

    private int calculatePrice(int howMany) {
        return pricePer * howMany;
    }

    private int calculatePrice() {
        return pricePer * quantity;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int howMany) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + howMany);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }

    // when plus is clicked
    public void increment(View view) {
        ++quantity;
        displayQuantity(quantity);
    }

    // when minus is clicked
    public void decrement(View view) {
        if (quantity != 0) {
            quantity--;
            displayQuantity(quantity);
        } else {
            // WTF?
            Log.wtf("decrement", "This isn't even possible!");
        }
    }


}