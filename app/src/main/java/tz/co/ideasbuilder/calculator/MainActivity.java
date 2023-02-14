package tz.co.ideasbuilder.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
//this method is called when the button is clicked on the front end of the website
    int currentOrderSize = 0;
    int quantity;
    String message;
    long unitPrice = 5;

    public void increaseOrder(View view){
        showIncrease();
    }

    public void decreaseOrder(View view){
        showDecrease();
    }
    public void submitOrder(View view){
        message = setTopping();
        displayPrice(quantity, message);

        Log.i("MainActivity",message);

    }

    //the price method is declared here
    @SuppressLint("SetTextI18n")
    private void displayPrice(int unit, String additions){

        //the line below captures a textview that is to be affected by using findViewById
        TextView price = findViewById(R.id.price);
        //the below line is used to write to the text view through the object
        if (unit>0) {
            price.setText("You have ordered: " + unit + " cups \n" + "Total Price is: " + NumberFormat.getCurrencyInstance().format(unitPrice * unit) + "\n" + additions + "\n"+ "Thank you!");
        }
        else{
            price.setText("Please make your order");
        }
    }

    private int increase(){
        return currentOrderSize+=1;

    }
    private int decrease(){
        if(quantity<=0){

            return  0;
        }
        else {
            return currentOrderSize -= 1;
        }
    }
    @SuppressLint("SetTextI18n")
    private void showIncrease(){
        quantity = increase();
        TextView content = findViewById(R.id.quantity);
        content.setText(" " +  quantity);

    }
    @SuppressLint("SetTextI18n")
    private void showDecrease(){
        quantity = decrease();
        TextView content = findViewById(R.id.quantity);
        content.setText(" " +  quantity);

    }
public String setTopping(){
        if (hasWhippedCream() && hasChocolate()){
            unitPrice = 10;
            return "Topping chosen is: Whipped Cream & Chocolate";
        }


    else if(hasChocolate()){
            unitPrice =8;
            return "Topping is: Chocolate";
        }

        else if (hasWhippedCream()){
            unitPrice = 7;
            return "Topping chosen is: whipped cream";
        }
    else{
            unitPrice = 5;
            return "No toppings selected";
        }

}

    private boolean hasChocolate() {
        CheckBox choco = (CheckBox) findViewById(R.id.choco);
        return choco.isChecked();
    }

    private boolean hasWhippedCream() {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        return whippedCream.isChecked();
    }


}

