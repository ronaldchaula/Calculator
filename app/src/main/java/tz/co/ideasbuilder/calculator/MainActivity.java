package tz.co.ideasbuilder.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    String message,name,orderSummary,subject,mail,email;
    long unitPrice = 5;

    public void increaseOrder(View view){
        showIncrease();
    }

    public void decreaseOrder(View view){
        showDecrease();
    }

    //after this button has been clicked the intent will be initialized

    public void submitOrder(View view){
        message = setTopping();
        name = getName();
        orderSummary = orderSummary(quantity, message);
        email = "admin@cmadvocates.co.tz";
        subject = "Order Summary From "+name;
        mail = name + " "+orderSummary;
        Log.w("MainActivity",subject);
        Log.w("MainActivity",mail);

        Intent sendOrder = new Intent(Intent.ACTION_SENDTO);
        sendOrder.setData(Uri.parse("mailto:")); //only email apps should respond to this call.
        sendOrder.putExtra(Intent.EXTRA_EMAIL,"admin@cmadvocates.co.tz");
        sendOrder.putExtra(Intent.EXTRA_SUBJECT,subject);
        sendOrder.putExtra(Intent.EXTRA_TEXT,mail);
if (sendOrder.resolveActivity(getPackageManager())!=null && orderSummary!=null){
    startActivity(sendOrder);
}
else if (orderSummary==null){
    Toast.makeText(this,"Make an order",Toast.LENGTH_SHORT).show();
}
        else{
            Toast.makeText(this,"Activity not found",Toast.LENGTH_SHORT).show();
}
    }



    //the price method is declared here
    @SuppressLint("SetTextI18n")
    private String orderSummary(int unit, String additions){

        //the line below captures a textview that is to be affected by using findViewById
        TextView price = findViewById(R.id.price);
        //the below line is used to write to the text view through the object
        if (unit>0) {
            String message;
            message = " have ordered: " + unit + " cup(s) \n" + "Total Price is: " + NumberFormat.getCurrencyInstance().format(unitPrice * unit) + "\n" + additions + "\n"+ "Thank you!";
            price.setText("Order placed");
            return message;
        }
        else{
            price.setText("Please make your order");
            return null;
        }

    }

    private int increase(){
        if(quantity>=100){
            return 100;
        }
        else {
            return currentOrderSize += 1;
        }
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
            unitPrice = 8;
            return "Topping chosen is: Whipped Cream & Chocolate";
        }


    else if(hasChocolate()){
            unitPrice =7;
            return "Topping is: Chocolate";
        }

        else if (hasWhippedCream()){
            unitPrice = 6;
            return "Topping chosen is: whipped cream";
        }
    else{
            unitPrice = 5;
            return "No toppings selected";
        }

}

    private boolean hasChocolate() {
        CheckBox choco = findViewById(R.id.choco);
        return choco.isChecked();
    }

    private boolean hasWhippedCream() {
        CheckBox whippedCream = findViewById(R.id.whippedCream);
        return whippedCream.isChecked();
    }

private String getName(){
    EditText name = findViewById(R.id.enteredName);
    return name.getText().toString();
}
}

