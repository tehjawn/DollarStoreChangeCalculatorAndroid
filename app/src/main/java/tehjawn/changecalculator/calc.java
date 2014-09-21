package tehjawn.changecalculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class calc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final Button calculate = (Button) findViewById(R.id.calcButton);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView itemPrice = (TextView) findViewById(R.id.priceInput);
                TextView itemPayment = (TextView) findViewById(R.id.paymentInput);

                TextView quarterAmount = (TextView)findViewById(R.id.qAmount);
                quarterAmount.setText("Quarter Amount");
                TextView dimeAmount = (TextView)findViewById(R.id.dAmount);
                dimeAmount.setText("Dime Amount");
                TextView nickelAmount = (TextView)findViewById(R.id.nAmount);
                nickelAmount.setText("Nickel Amount");
                TextView pennyAmount = (TextView)findViewById(R.id.pAmount);
                pennyAmount.setText("Penny Amount");

                TextView changeAmount = (TextView)findViewById(R.id.changeAmount);
                changeAmount.setText("Change");
                TextView logicTrue = (TextView)findViewById(R.id.logCheckText);
                logicTrue.setText("Payment was accepted");
                logicTrue.setTextColor(Color.GREEN);

                int quarters = -1;
                int dimes = -1;
                int nickels = -1;
                int pennies = -1;
                int change = -1;
                boolean wasSolved = false;
                LeastChangePossible lcp = new LeastChangePossible();

                if  ( ( itemPayment.getText().toString().matches("") ) || ( itemPrice.getText().toString().matches("") ) ) {
                    Toast.makeText(getApplicationContext(), "Please input payment and item price values", Toast.LENGTH_SHORT).show();
                //} else if ( Integer.parseInt(itemPrice) > itemPayment){

                }

                else {
                    int price = Integer.parseInt( itemPrice.getText().toString() );
                    int payment = Integer.parseInt( itemPayment.getText().toString() );
                    wasSolved = lcp.calculateChange(price, payment);
                }

                if (wasSolved) {
                    quarters = lcp.getQuarters();
                    dimes = lcp.getDimes();
                    nickels = lcp.getNickels();
                    pennies = lcp.getPennies();
                    change = lcp.getTotalChange();

                    quarterAmount.setText(Integer.toString(quarters));
                    dimeAmount.setText(Integer.toString(dimes));
                    nickelAmount.setText(Integer.toString(nickels));
                    pennyAmount.setText(Integer.toString(pennies));
                    changeAmount.setText(Integer.toString(change));
                } else {
                    logicTrue.setText("Payment was denied");
                    logicTrue.setTextColor(Color.RED);
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
