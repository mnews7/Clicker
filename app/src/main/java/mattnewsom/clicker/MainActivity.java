package mattnewsom.clicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FarmCountLogic farmcounter = new FarmCountLogic();
    TextView txtView;
    TextView upgradeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.cropValue);
        upgradeText = (TextView)findViewById(R.id.upgradeClick);

    }

    public void cropClick(View v){
        // Increments farmcounter by crop increment
        farmcounter.incrementCrops();

        String crops = ((int)farmcounter.getCropCount())+" crops!";


        txtView.setText(crops);


    }

    public void upgradeClick(View v){
        // upgrades increment value
        // at cost of crop
        //TODO remove hardcoded 12

        if (farmcounter.getCropCount()> farmcounter.costToUpgrade() ) {
            farmcounter.removeCrops(farmcounter.costToUpgrade());
            farmcounter.changeIncrement();
            String costToUpgrade = ((int)farmcounter.costToUpgrade())+" crops to upgrade";
            upgradeText.setText(costToUpgrade);
        }
        String crops = ((int) farmcounter.getCropCount())+" crops!";
        txtView.setText(crops);



    }
}
