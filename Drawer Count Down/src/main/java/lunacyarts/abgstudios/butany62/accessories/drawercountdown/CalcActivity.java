package lunacyarts.abgstudios.butany62.accessories.drawercountdown;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class CalcActivity extends AppCompatActivity {
    FloatingActionButton btn_refresh;
    EditText drawer_final_d;

    EditText penny_input;
    TextView penny_drawer;
    TextView penny_safe;

    EditText penny_inputR;

    EditText nickel_input;
    TextView nickel_drawer;
    TextView nickel_safe;

    EditText nickel_inputR;

    EditText dime_input;
    TextView dime_drawer;
    TextView dime_safe;

    EditText dime_inputR;

    EditText quarter_input;
    TextView quarter_drawer;
    TextView quarter_safe;

    EditText quarter_inputR;

    EditText dollar_input;
    TextView dollar_drawer;
    TextView dollar_safe;

    EditText five_input;
    TextView five_drawer;
    TextView five_safe;

    EditText ten_input;
    TextView ten_drawer;
    TextView ten_safe;

    EditText twenty_input;
    TextView twenty_drawer;
    TextView twenty_safe;

    EditText fifty_input;
    TextView fifty_drawer;
    TextView fifty_safe;

    EditText hundred_input;
    TextView hundred_drawer;
    TextView hundred_safe;

    TextView total_drawer;
    TextView total_safe;

    boolean calculateSafe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        btn_refresh = (FloatingActionButton) findViewById(R.id.calc);
        drawer_final_d = (EditText) findViewById(R.id.DrawerFinalD);

        penny_input = (EditText) findViewById(R.id.PennyNumber);
        penny_drawer = (TextView) findViewById(R.id.PennyDrawer);
        penny_safe = (TextView) findViewById(R.id.PennySafe);

        penny_inputR = (EditText) findViewById(R.id.PennyNumberR);

        nickel_input = (EditText) findViewById(R.id.NickelsNumber);
        nickel_drawer = (TextView) findViewById(R.id.NickelsDrawer);
        nickel_safe = (TextView) findViewById(R.id.NickelsSafe);

        nickel_inputR = (EditText) findViewById(R.id.NickelsNumberR);

        dime_input = (EditText) findViewById(R.id.DimesNumber);
        dime_drawer = (TextView) findViewById(R.id.DimesDrawer);
        dime_safe = (TextView) findViewById(R.id.DimesSafe);

        dime_inputR = (EditText) findViewById(R.id.DimesNumberR);

        quarter_input = (EditText) findViewById(R.id.QuartersNumber);
        quarter_drawer = (TextView) findViewById(R.id.QuartersDrawer);
        quarter_safe = (TextView) findViewById(R.id.QuartersSafe);

        quarter_inputR = (EditText) findViewById(R.id.QuartersNumberR);

        dollar_input = (EditText) findViewById(R.id.DollarsNumber);
        dollar_drawer = (TextView) findViewById(R.id.DollarsDrawer);
        dollar_safe = (TextView) findViewById(R.id.DollarsSafe);

        five_input = (EditText) findViewById(R.id.FivesNumber);
        five_drawer = (TextView) findViewById(R.id.FivesDrawer);
        five_safe = (TextView) findViewById(R.id.FivesSafe);

        ten_input = (EditText) findViewById(R.id.TensNumber);
        ten_drawer = (TextView) findViewById(R.id.TensDrawer);
        ten_safe = (TextView) findViewById(R.id.TensSafe);

        twenty_input = (EditText) findViewById(R.id.TwentiesNumber);
        twenty_drawer = (TextView) findViewById(R.id.TwentiesDrawer);
        twenty_safe = (TextView) findViewById(R.id.TwentiesSafe);

        fifty_input = (EditText) findViewById(R.id.FiftiesNumber);
        fifty_drawer = (TextView) findViewById(R.id.FiftiesDrawer);
        fifty_safe = (TextView) findViewById(R.id.FiftiesSafe);

        hundred_input = (EditText) findViewById(R.id.HundredsNumber);
        hundred_drawer = (TextView) findViewById(R.id.HundredsDrawer);
        hundred_safe = (TextView) findViewById(R.id.HundredsSafe);

        total_drawer = (TextView) findViewById(R.id.TotalDrawer);
        total_safe = (TextView) findViewById(R.id.TotalSafe);

        toggleVisibleSafe(false);

        btn_refresh.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //defines what you want the drawer to count down to (defaults at $100).
                int drawerFinal_d = setInput(drawer_final_d.getText().toString(), 100);

                //Defines the Pennies for both the drawer and the safe (1: safe 2: drawer).
                int inputPSafe = 0;
                int inputPDrawerC = setInput(penny_input.getText().toString(), 0);

                //Defines the penny rolls.
                int inputPDrawerRC = setInput(penny_inputR.getText().toString(), 0) * 50;

                //Defines the nickels.
                int inputNSafe = 0;
                int inputNDrawerC = setInput(nickel_input.getText().toString(), 0) * 5;

                //Defines the nickel rolls.
                int inputNDrawerRD = setInput(nickel_inputR.getText().toString(), 0) * 2;

                //Defines the dimes.
                int inputDSafe = 0;
                int inputDDrawerC = setInput(dime_input.getText().toString() , 0) * 10;

                //Defines the dime rolls.
                int inputDDrawerRD = setInput(dime_inputR.getText().toString(), 0) * 5;

                //Defines the quarters.
                int inputQSafe = 0;
                int inputQDrawerC = setInput(quarter_input.getText().toString(), 0) * 25;

                //Defines the quarter rolls.
                int inputQDrawerRD = setInput(quarter_inputR.getText().toString(), 0) * 10;

                //Defines the ones.
                int input1Safe = 0;
                int input1DrawerD = setInput(dollar_input.getText().toString(), 0);

                //Defines the fives.
                int input5Safe = 0;
                int input5DrawerD = setInput(five_input.getText().toString(), 0) * 5;

                //Defines the tens.
                int input10Safe = 0;
                int input10DrawerD = setInput(ten_input.getText().toString(), 0) * 10;

                //Defines the twenties.
                int input20Safe = 0;
                int input20DrawerD = setInput(twenty_input.getText().toString(), 0) * 20;

                //Defines the fifties.
                int input50Safe = 0;
                int input50DrawerD = setInput(fifty_input.getText().toString(), 0) * 50;

                //Defines the hundreds.
                int input100Safe = 0;
                int input100DrawerD = setInput(hundred_input.getText().toString(), 0) * 100;

                //Defines the pennies and rolls added together.
                int outputPCTotal = inputPDrawerC + inputPDrawerRC;
                int outputPDTotal = 0;

                //Separates into dollars and cents.
                while (outputPCTotal >= 100) {
                    outputPCTotal -= 100;
                    outputPDTotal += 1;
                }

                //
                int outputNCTotal = inputNDrawerC + (inputNDrawerRD * 100);
                int outputNDTotal = 0;

                //
                while (outputNCTotal >= 100) {
                    outputNCTotal -= 100;
                    outputNDTotal +=1;
                }

                //
                int outputDCTotal = inputDDrawerC + (inputDDrawerRD * 100);
                int outputDDTotal = 0;

                //
                while (outputDCTotal >= 100) {
                    outputDCTotal -= 100;
                    outputDDTotal += 1;
                }

                //
                int outputQCTotal = inputQDrawerC + (inputQDrawerRD * 100);
                int outputQDTotal = 0;

                //
                while (outputQCTotal >= 100) {
                    outputQCTotal -= 100;
                    outputQDTotal += 1;
                }

                if (calculateSafe) {

                    while (((inputPDrawerC + inputPDrawerRC + inputNDrawerC + inputDDrawerC + inputQDrawerC) /100) * 100 !=
                            inputPDrawerC + inputPDrawerRC + inputNDrawerC + inputDDrawerC + inputQDrawerC) {

                        inputPDrawerC -= 1;
                        inputPSafe += 1;
                        if (inputPSafe == 5){
                            inputPSafe -= 5;
                            inputPDrawerC += 5;
                            inputNDrawerC -= 5;
                            inputNSafe += 5;
                        } if (inputNSafe == 10) {
                            inputNSafe -= 10;
                            inputNDrawerC += 10;
                            inputDDrawerC -= 10;
                            inputDSafe += 10;
                        } if (inputNSafe + inputDSafe == 25) {
                            inputNSafe -= 5;
                            inputNDrawerC += 5;
                            inputDSafe -= 10;
                            inputDDrawerC += 10;
                            inputQDrawerC -= 25;
                            inputQSafe += 25;
                        }
                    }

                    while (outputPDTotal + outputNDTotal + outputDDTotal + outputQDTotal + inputNDrawerRD + inputDDrawerRD + inputQDrawerRD + input1DrawerD + input5DrawerD + input10DrawerD +
                            input20DrawerD + input50DrawerD + input100DrawerD > drawerFinal_d) {

                        input1DrawerD -= 1;
                        input1Safe += 1;

                        if (input1Safe == 5) {
                            input1DrawerD += 5;
                            input1Safe -= 5;
                            input5DrawerD -= 5;
                            input5Safe += 5;
                        }
                        if (input5Safe == 10) {
                            input5DrawerD += 10;
                            input5Safe -= 10;
                            input10DrawerD -= 10;
                            input10Safe += 10;
                        }
                        if (input10Safe == 20) {
                            input10DrawerD += 20;
                            input10Safe -= 20;
                            input20DrawerD -= 20;
                            input20Safe += 20;
                        }
                        if (input20Safe + input10Safe == 50) {
                            input10DrawerD += 10;
                            input10Safe -= 10;
                            input20DrawerD += 40;
                            input20Safe -= 40;
                            input50DrawerD -= 50;
                            input50Safe += 50;
                        }
                        if (input50Safe == 100) {
                            input50DrawerD += 100;
                            input50Safe -= 100;
                            input100DrawerD -= 100;
                            input100Safe += 100;
                        }
                    }

                    while (input100DrawerD < 0) {
                        input50DrawerD -= 100;
                        input50Safe += 100;
                        input100Safe -= 100;
                        input100DrawerD += 100;
                    }
                    while (input50DrawerD < 0) {
                        input10DrawerD -= 10;
                        input20DrawerD -= 40;
                        input50Safe -= 50;
                        input10Safe += 10;
                        input20Safe += 40;
                        input50DrawerD += 50;
                    }
                    while (input20DrawerD < 0) {
                        input10DrawerD -= 20;
                        input20Safe -= 20;
                        input10Safe += 20;
                        input20DrawerD += 20;
                    }
                    while (input10DrawerD < 0) {
                        input5DrawerD -= 10;
                        input10Safe -= 10;
                        input5Safe += 10;
                        input10DrawerD += 10;
                    }
                }

                //Sets the strings so that if the cents place is below 10, it will add in the 0 that
                //would have otherwise been missing.
                String psText;
                if (inputPSafe < 10) { psText = "0.0"; } else { psText = "0."; }
                String pdText;
                if (outputPCTotal < 10) { pdText = ".0"; } else { pdText = "."; }

                //Sets the text for the drawer and safe.
                penny_safe.setText(psText + inputPSafe);
                penny_drawer.setText(outputPDTotal + pdText + outputPCTotal);

                //Outputs nickel values to chart.
                String nsText = "0."; if (inputNSafe < 10) { nsText = "0.0"; }
                String ndText = "."; if (outputNCTotal < 10) { ndText = ".0"; }
                nickel_safe.setText(nsText + inputNSafe);
                nickel_drawer.setText(outputNDTotal + ndText + outputNCTotal);

                //Outputs dime values to chart.
                String dsText = "0."; if (inputDSafe < 10) { dsText = "0.0"; }
                String ddText = "."; if (outputDCTotal < 10) { ddText = ".0"; }
                dime_safe.setText(dsText + inputDSafe);
                dime_drawer.setText(outputDDTotal + ddText + outputDCTotal);

                //Outputs quarter values to chart.
                String qsText = "0."; if (inputQSafe < 10) { qsText = "0.0"; }
                String qdText = "."; if (outputQCTotal < 10) { qdText = ".0"; }
                quarter_safe.setText(qsText + inputQSafe);
                quarter_drawer.setText(outputQDTotal + qdText + outputQCTotal);

                //Outputs ones.
                dollar_safe.setText(input1Safe + ".00");
                dollar_drawer.setText(input1DrawerD + ".00");

                //Outputs fives.
                five_safe.setText(input5Safe + ".00");
                five_drawer.setText(input5DrawerD + ".00");

                //Outputs tens.
                ten_safe.setText(input10Safe + ".00");
                ten_drawer.setText(input10DrawerD + ".00");

                //Outputs twenties.
                twenty_safe.setText(input20Safe + ".00");
                twenty_drawer.setText(input20DrawerD + ".00");

                //Outputs fifties.
                fifty_safe.setText(input50Safe + ".00");
                fifty_drawer.setText(input50DrawerD + ".00");

                //Outputs hundreds.
                hundred_safe.setText(input100Safe + ".00");
                hundred_drawer.setText(input100DrawerD + ".00");

                int outputT1 = inputPSafe + inputNSafe + inputDSafe + inputQSafe;
                int outputT1D = input1Safe + input5Safe + input10Safe + input20Safe + input50Safe + input100Safe;
                while (outputT1 >= 100) {
                    outputT1 -= 100;
                    outputT1D += 1;
                }

                int outputT2 = inputPDrawerC + inputPDrawerRC + inputNDrawerC + inputDDrawerC + inputQDrawerC;
                int outputT2D = inputNDrawerRD + inputDDrawerRD + inputQDrawerRD + input1DrawerD + input5DrawerD + input10DrawerD + input20DrawerD +
                        input50DrawerD + input100DrawerD;
                while (outputT2 >= 100) {
                    outputT2 -= 100;
                    outputT2D += 1;
                }


                String ot1Text = ".";if (outputT1 < 10) { ot1Text = ".0"; }
                String ot2Text = "."; if (outputT2 < 10) { ot2Text = ".0"; }

                total_safe.setText(outputT1D + ot1Text + outputT1);
                total_drawer.setText(outputT2D + ot2Text + outputT2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Refresh_Menu_Item) {
            penny_input.setText("");
            nickel_input.setText("");
            dime_input.setText("");
            quarter_input.setText("");
            dollar_input.setText("");
            five_input.setText("");
            ten_input.setText("");
            twenty_input.setText("");
            fifty_input.setText("");
            hundred_input.setText("");
            penny_inputR.setText("");
            nickel_inputR.setText("");
            dime_inputR.setText("");
            quarter_inputR.setText("");
            penny_drawer.setText(R.string._000_00);
            penny_safe.setText(R.string._000_00);
            nickel_drawer.setText(R.string._000_00);
            nickel_safe.setText(R.string._000_00);
            dime_drawer.setText(R.string._000_00);
            dime_safe.setText(R.string._000_00);
            quarter_drawer.setText(R.string._000_00);
            quarter_safe.setText(R.string._000_00);
            dollar_drawer.setText(R.string._000_00);
            dollar_safe.setText(R.string._000_00);
            five_drawer.setText(R.string._000_00);
            five_safe.setText(R.string._000_00);
            ten_drawer.setText(R.string._000_00);
            ten_safe.setText(R.string._000_00);
            twenty_drawer.setText(R.string._000_00);
            twenty_safe.setText(R.string._000_00);
            fifty_drawer.setText(R.string._000_00);
            fifty_safe.setText(R.string._000_00);
            hundred_drawer.setText(R.string._000_00);
            hundred_safe.setText(R.string._000_00);
        } else if (item.getItemId() == R.id.Calc_Menu_Item) {
            if (item.isChecked()) {
                item.setChecked(false); calculateSafe = false; toggleVisibleSafe(false);}
            else {
                item.setChecked(true); calculateSafe = true; toggleVisibleSafe(true);}
        }
        return true;
    }

    private int setInput(String input, int elser) {
        if (!input.matches("")) { elser = Integer.parseInt(input); }
        return elser;
    }

    private void toggleVisibleSafe(boolean visible) {

        int vis = View.INVISIBLE;
        if (visible) {
            vis = View.VISIBLE;
        }

        findViewById(R.id.count_down_tray).setVisibility(vis);
        findViewById(R.id.Safe).setVisibility(vis);
        findViewById(R.id.b_space_1).setVisibility(vis);
        findViewById(R.id.PennySafe).setVisibility(vis);
        findViewById(R.id.b_space_2).setVisibility(vis);
        findViewById(R.id.NickelsSafe).setVisibility(vis);
        findViewById(R.id.b_space_3).setVisibility(vis);
        findViewById(R.id.DimesSafe).setVisibility(vis);
        findViewById(R.id.b_space_4).setVisibility(vis);
        findViewById(R.id.QuartersSafe).setVisibility(vis);
        findViewById(R.id.DollarsSafe).setVisibility(vis);
        findViewById(R.id.FivesSafe).setVisibility(vis);
        findViewById(R.id.TensSafe).setVisibility(vis);
        findViewById(R.id.TwentiesSafe).setVisibility(vis);
        findViewById(R.id.FiftiesSafe).setVisibility(vis);
        findViewById(R.id.HundredsSafe).setVisibility(vis);
        findViewById(R.id.TotalSafe).setVisibility(vis);
    }
}
