package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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

    /**
     * Creates a string fragment base on Option 1 selection
     *
     * @return a string fragment to add to the order summary
     */
    private String option1Summary() {
        CheckBox checkBox = findViewById(R.id.cbOption1);
        boolean option1 = checkBox.isChecked();
        if (option1) {
            return "Bronze level investment\n";
        } else return "";
    }

    /**
     * Creates a string fragment base on Option 2 selection
     *
     * @return a string fragment to add to the order summary
     */
    private String option2Summary() {
        CheckBox checkBox = findViewById(R.id.cbOption2);
        boolean option2 = checkBox.isChecked();
        if (option2) {
            return "Investor Package selected! Dividend > 4% APY\n";
        } else return "";
    }


    /**
     * Assembles the text to fill the String of the order summary
     *
     * @param subTotal the total price as previously calculated
     * @return the String with the complete order summary
     */
    public String createOrderSummary(int subTotal) {
        return "Name: " + "g-User #000023\n"
                + option2Summary()
                + "Quantity: " + quantity + "\n"
                + option1Summary()
                + "Total: " + subTotal + "\n"
                + "Thank you";
    }

    /**
     * This is mostly unnecessary because these args are global variables
     *
     * @param howMany   the quantity being ordered
     * @param howMuch   the price per each unit
     * @return (int) sum total of calculated price
     */
    private int calculatePrice(int howMany, int howMuch) {
        return howMuch * howMany;
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

    /**
     * when plus is clicked
     */
    public void increment(View view) {
        ++quantity;
        displayQuantity(quantity);
    }

    /**
     * when minus is clicked
     */
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