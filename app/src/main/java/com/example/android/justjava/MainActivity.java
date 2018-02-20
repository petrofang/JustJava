package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to buy g-UNIT
 */
public class MainActivity extends AppCompatActivity {
    /**
     * TODO:    fold these global vars into the submitOrder method and pass args to other methods
     * or should I? Do global variables use less memory than passing
     * them from method to method in Java?  Alternatively:
     * TODO:    clean up child methods and remove args; use global variables exclusively,
     */
    int quantity = 0;
    int pricePer = 5;
    //  final int XEM_PRICE_FACTOR = 1;
    boolean option1;
    boolean option2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }

    //  protected void onPause(){};

    /**
     * when the Order button is clicked...
     * do the math
     * build the string using the math
     * display the string
     *
     * @param view the view that called it, I think? the Order button?
     */
    public void submitOrder(View view) {
        /*  */
        CheckBox checkBox = findViewById(R.id.cbOption1);
        option1 = checkBox.isChecked();
        checkBox = findViewById(R.id.cbOption2);
        option2 = checkBox.isChecked();

        int subTotal = calculatePrice(quantity, pricePer);
        String orderSummary = createOrderSummary(subTotal);
        displayMessage(orderSummary);
    }


    /**
     * Assembles the text to fill the String of the order summary
     *
     * @param subTotal the total price as previously calculated
     * @return the String with the complete order summary
     */
    public String createOrderSummary(int subTotal) {
        return nameSummary()
                + option2Summary()
                + quantity + " coin generated.." + "\n"
                + option1Summary()
                + "Total: " + subTotal + " XEM\n"
                + "Thank you";
    }

    /**
     * Creates a string fragment based on Option 1 selection
     *
     * @return a string fragment to add to the order summary
     */
    private String option1Summary() {
        if (option1) {
            return "form factor: Bronzed coins\n";
        } else return "form factor: Wooden coins\n";
    }

    /**
     * Create a string fragment based on the name
     *
     * @return string fragment to add to order summary
     */
    private String nameSummary() {
        EditText editText = findViewById(R.id.etName);
        String name = editText.getText().toString();
        return "Name: " + name + "\n";
    }

    /**
     * Creates a string fragment based on Option 2 selection
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
     * This method calculates the subtotal of the order based on selection options
     *
     * @param howMany the quantity being ordered
     * @param howMuch the price per each unit
     * @return (int) sum total of calculated price
     */
    private int calculatePrice(int howMany, int howMuch) {
        int subTotal = howMany * howMuch;
        if (!option1) {
            subTotal = subTotal / 100 + 1;
        }
        if (option2) {
            subTotal += 12000;
        }
        /* convert from XEM to USD:
        subTotal = subTotal * XEM_PRICE_FACTOR;
         */
        return subTotal;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int howMany) {
        String string = "" + howMany;
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(string);
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
        if (quantity < 100) {
            ++quantity;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "Current Max: 100 gUnit", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * when minus is clicked
     */
    public void decrement(View view) {
        if (quantity != 0) {
            quantity--;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "gUnit sales are locked (no inversion)", Toast.LENGTH_SHORT).show();
        }
    }


}