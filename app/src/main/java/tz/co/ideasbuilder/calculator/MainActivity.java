package tz.co.ideasbuilder.calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//this method is called when the button is clicked on the front end of the website
    int currentOrderSize = 0;
    int quantity;

    public void increaseOrder(View view){
        showIncrease();
    }

    public void decreaseOrder(View view){
        showDecrease();
    }
    public void submitOrder(View view){

    }
// the quantity display method is declaired here
    public void display(int unit) {
        TextView content = (TextView) findViewById(R.id.quantity);
        content.setText(" " + unit);
    }
    //the price method is declared here
    public void displayPrice(int unit){
        int unitPrice = 5;
        //the line below captures a textview that is to be affected by using findViewById
        TextView price = (TextView) findViewById(R.id.price);
        //the below line is used to write to the text view through the object
        price.setText("$" + unitPrice*unit);
    }

    public int increase(){
        return currentOrderSize+=1;

    }
    public int decrease(){
        if(quantity<=0){

            return  0;
        }
        else {
            return currentOrderSize -= 1;
        }
    }
    public void showIncrease(){
        quantity = increase();
        TextView content = (TextView) findViewById(R.id.quantity);
        content.setText(" " +  quantity);
        displayPrice(quantity);
    }
    public void showDecrease(){
        quantity = decrease();
        TextView content = (TextView) findViewById(R.id.quantity);
        content.setText(" " +  quantity);
        displayPrice(quantity);
    }
}

