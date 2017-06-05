package lunacyarts.abgstudios.butany62.accessories.drawercountdown;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final FloatingActionButton btn_refresh = (FloatingActionButton) findViewById(R.id.refresh);
        final FloatingActionButton btn_reset = (FloatingActionButton) findViewById(R.id.reset);
        final EditText drawer_final = (EditText) findViewById(R.id.DrawerFinal);

        final EditText penny_input = (EditText) findViewById(R.id.PennyNumber);
        final TextView penny_drawer = (TextView) findViewById(R.id.PennyDrawer);
        final TextView penny_safe = (TextView) findViewById(R.id.PennySafe);

        final EditText penny_inputR = (EditText) findViewById(R.id.PennyNumberR);

        final EditText nickel_input = (EditText) findViewById(R.id.NickelsNumber);
        final TextView nickel_drawer = (TextView) findViewById(R.id.NickelsDrawer);
        final TextView nickel_safe = (TextView) findViewById(R.id.NickelsSafe);

        final EditText nickel_inputR = (EditText) findViewById(R.id.NickelsNumberR);

        final EditText dime_input = (EditText) findViewById(R.id.DimesNumber);
        final TextView dime_drawer = (TextView) findViewById(R.id.DimesDrawer);
        final TextView dime_safe = (TextView) findViewById(R.id.DimesSafe);

        final EditText dime_inputR = (EditText) findViewById(R.id.DimesNumberR);

        final EditText quarter_input = (EditText) findViewById(R.id.QuartersNumber);
        final TextView quarter_drawer = (TextView) findViewById(R.id.QuartersDrawer);
        final TextView quarter_safe = (TextView) findViewById(R.id.QuartersSafe);

        final EditText quarter_inputR = (EditText) findViewById(R.id.QuartersNumberR);

        final EditText dollar_input = (EditText) findViewById(R.id.DollarsNumber);
        final TextView dollar_drawer = (TextView) findViewById(R.id.DollarsDrawer);
        final TextView dollar_safe = (TextView) findViewById(R.id.DollarsSafe);

        final EditText five_input = (EditText) findViewById(R.id.FivesNumber);
        final TextView five_drawer = (TextView) findViewById(R.id.FivesDrawer);
        final TextView five_safe = (TextView) findViewById(R.id.FivesSafe);

        final EditText ten_input = (EditText) findViewById(R.id.TensNumber);
        final TextView ten_drawer = (TextView) findViewById(R.id.TensDrawer);
        final TextView ten_safe = (TextView) findViewById(R.id.TensSafe);

        final EditText twenty_input = (EditText) findViewById(R.id.TwentiesNumber);
        final TextView twenty_drawer = (TextView) findViewById(R.id.TwentiesDrawer);
        final TextView twenty_safe = (TextView) findViewById(R.id.TwentiesSafe);

        final EditText fifty_input = (EditText) findViewById(R.id.FiftiesNumber);
        final TextView fifty_drawer = (TextView) findViewById(R.id.FiftiesDrawer);
        final TextView fifty_safe = (TextView) findViewById(R.id.FiftiesSafe);

        final EditText hundred_input = (EditText) findViewById(R.id.HundredsNumber);
        final TextView hundred_drawer = (TextView) findViewById(R.id.HundredsDrawer);
        final TextView hundred_safe = (TextView) findViewById(R.id.HundredsSafe);

        final TextView total_drawer = (TextView) findViewById(R.id.TotalDrawer);
        final TextView total_safe = (TextView) findViewById(R.id.TotalSafe);

        btn_refresh.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //defines what you want the drawer to count down to (defaults at $100).
                int drawer_final_f = setInput(drawer_final.getText().toString(), 100);

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
                int inputQDrawerD = 0;

                //Defines the quarter rolls.
                int inputQSafeR = 0;
                int inputQDrawerRD = setInput(quarter_inputR.getText().toString(), 0) * 10;

                //Makes inputP2 divisible by 5 and puts the remainder into P1.
                int penniesPlaceholder = inputPDrawerC / 5;
                if (penniesPlaceholder * 5 != inputPDrawerC) {
                    inputPSafe = inputPDrawerC - (penniesPlaceholder * 5);
                    inputPDrawerC = penniesPlaceholder * 5;
                }

                //
                int openNickelRoll = 0;
                int openDimeRoll = 0;
                int openQuarterRoll = 0;

                //Count out coins to get to a dollar amount with no cents.
                int coinTotal = inputPDrawerC + inputNDrawerC + inputDDrawerC + inputQDrawerC + inputPDrawerRC;
                int coinRound = coinTotal / 100;
                while (coinRound * 100 != coinTotal) {
                    inputNSafe += 5;
                    inputNDrawerC -= 5;
                    if (inputNSafe == 10) {
                        inputNSafe -= 10;
                        inputNDrawerC += 10;
                        inputDSafe += 10;
                        inputDDrawerC -= 10;
                    }
                    if (inputNSafe + inputDSafe == 25) {
                        inputNSafe -= 5;
                        inputNDrawerC += 5;
                        inputDSafe -= 20;
                        inputDDrawerC += 20;
                        inputQSafe += 25;
                        inputQDrawerC -= 25;
                    }

                    //Open rolls if needed.
                    if (inputNDrawerC < 0) {
                        inputNDrawerRD -= 2;
                        inputNDrawerC += 2;
                        openNickelRoll++;
                    }
                    if (inputDDrawerC < 0) {
                        inputDDrawerRD -= 5;
                        inputDDrawerC += 5;
                        openDimeRoll++;
                    }
                    if (inputQDrawerC < 0) {
                        inputQDrawerRD -= 10;
                        inputQDrawerC += 10;
                        openQuarterRoll++;
                    }

                    coinTotal = inputPDrawerC + inputNDrawerC + inputDDrawerC + inputQDrawerC + inputPDrawerRC;
                    coinRound = coinTotal / 100;
                }

                //Booleans to tell whether or not you need change.
                boolean needPennies = false;
                if (inputPDrawerC + inputPDrawerRC < 50) {
                    needPennies = true;
                }
                boolean needNickels = false;
                if (inputNDrawerC + (inputNDrawerRD * 100) < 200) {
                    needNickels = true;
                }
                boolean needDimes = false;
                if (inputDDrawerC + (inputDDrawerRD * 100) < 500) {
                    needDimes = true;
                }
                boolean needQuarters = false;
                if (inputQDrawerC + (inputQDrawerRD * 100) < 1000) {
                    needQuarters = true;
                }

                //Defines the pennies and rolls added together.
                int outputPCTotal = inputPDrawerC + inputPDrawerRC;
                int outputPDTotal = 0;

                //Separates into dollars and cents.
                while (outputPCTotal >= 100) {
                    outputPCTotal -= 100;
                    outputPDTotal += 1;
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

                //
                int outputNCTotal = inputNDrawerC + (inputNDrawerRD * 100);
                int outputNDTotal = 0;

                //
                while (outputNCTotal >= 100) {
                    outputNCTotal -= 100;
                    outputNDTotal +=1;
                }

                //Outputs nickel values to chart.
                String nsText = "0."; if (inputNSafe < 10) { nsText = "0.0"; }
                String ndText = "."; if (outputNCTotal < 10) { ndText = ".0"; }
                nickel_safe.setText(nsText + inputNSafe);
                nickel_drawer.setText(outputNDTotal + ndText + outputNCTotal);

                //
                int outputDCTotal = inputDDrawerC + (inputDDrawerRD * 100);
                int outputDDTotal = 0;

                //
                while (outputDCTotal >= 100) {
                    outputDCTotal -= 100;
                    outputDDTotal += 1;
                }

                //Outputs dime values to chart.
                String dsText = "0."; if (inputDSafe < 10) { dsText = "0.0"; }
                String ddText = "."; if (outputDCTotal < 10) { ddText = ".0"; }
                dime_safe.setText(dsText + inputDSafe);
                dime_drawer.setText(outputDDTotal + ddText + outputDCTotal);

                //
                int outputQCTotal = inputQDrawerC + (inputQDrawerRD * 100);
                int outputQDTotal = 0;

                //
                while (outputQCTotal >= 100) {
                    outputQCTotal -= 100;
                    outputQDTotal += 1;
                }

                //Outputs quarter values to chart.
                String qsText = "0."; if (inputQSafe < 10) { qsText = "0.0"; }
                String qdText = "."; if (outputQCTotal < 10) { qdText = ".0"; }
                quarter_safe.setText(qsText + inputQSafe);
                quarter_drawer.setText(outputQDTotal + qdText + outputQCTotal);

                //Defines the ones.
                int input1Safe = 0;
                int input1Drawer = setInput(dollar_input.getText().toString(), 0);

                //Defines the fives.
                int input5Safe = 0;
                int input5Drawer = setInput(five_input.getText().toString(), 0) * 5;

                //Defines the tens.
                int input10Safe = setInput(ten_input.getText().toString(), 0) * 10;

                //Defines the twenties.
                int input20Safe = setInput(twenty_input.getText().toString(), 0) * 20;
                int input20Drawer = 0;

                //Adds 20's if the drawer is below Drawer Final.
                coinTotal = ((inputPDrawerC + inputNDrawerC + inputDDrawerC + inputQDrawerC + inputPDrawerRC) / 100) +
                        input1Drawer + input5Drawer + inputNDrawerRD + inputDDrawerRD + inputQDrawerRD;
                while (coinTotal <= drawer_final_f) {
                    input20Safe -= 20;
                    input20Drawer += 20;
                }

                //Counts the drawer down to 100.
                coinTotal = ((inputPDrawerC + inputNDrawerC + inputDDrawerC + inputQDrawerC + inputPDrawerRC) / 100) +
                        input1Drawer + input5Drawer + inputNDrawerRD + inputDDrawerRD + inputQDrawerRD + input20Drawer;
                while (coinTotal > drawer_final_f) {
                    input1Safe += 1;
                    input1Drawer -= 1;
                    if (input1Safe == 5) {
                        input1Safe -= 5;
                        input1Drawer += 5;
                        input5Safe += 5;
                        input5Drawer -= 5;
                    }
                    coinTotal = ((inputPDrawerC + inputNDrawerC + inputDDrawerC + inputQDrawerC + inputPDrawerRC) / 100) +
                            input1Drawer + input5Drawer + inputNDrawerRD + inputDDrawerRD + inputQDrawerRD + input20Drawer;
                }

                //Outputs ones.
                dollar_safe.setText(input1Safe + ".00");
                dollar_drawer.setText(input1Drawer + ".00");

                //Outputs fives.
                five_safe.setText(input5Safe + ".00");
                five_drawer.setText(input5Drawer + ".00");

                //Outputs tens.
                ten_drawer.setText("0.00");
                ten_safe.setText(input10Safe + ".00");

                //Outputs twenties.
                twenty_safe.setText(input20Safe + ".00");
                twenty_drawer.setText(input20Drawer + ".00");

                //Defines the fifties.
                int input50Safe = setInput(fifty_input.getText().toString(), 0) * 50;

                //Outputs fifties.
                fifty_drawer.setText("0.00");
                fifty_safe.setText(input50Safe + ".00");

                //Defines the hundreds.
                int input100Safe = setInput(hundred_input.getText().toString(), 0);

                //Outputs hundreds.
                hundred_drawer.setText("0.00");
                hundred_safe.setText(input100Safe + ".00");

                int outputT1 = inputPSafe + inputNSafe + inputDSafe + inputQSafe;
                int outputT1D = input1Safe + input5Safe + input10Safe + input20Safe + input50Safe + input100Safe;
                while (outputT1 >= 100) {
                    outputT1 -= 100;
                    outputT1D += 1;
                }

                int outputT2 = inputPDrawerC + inputPDrawerRC + inputNDrawerC + inputDDrawerC + inputQDrawerC;
                int outputT2D = inputNDrawerRD + inputDDrawerRD + inputQDrawerRD + input1Drawer + input5Drawer + input20Drawer;
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

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }

    private int setInput(String input, int elser) {
        if (!input.matches("")) { elser = Integer.parseInt(input); }
        return elser;
    }
}
