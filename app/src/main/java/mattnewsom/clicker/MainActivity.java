package mattnewsom.clicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    FarmCountLogic farmcounter = new FarmCountLogic();
    TextView txtView;
    TextView upgradeText;
    AutoCropIncrementer autoCropIncrementer = new AutoCropIncrementer();


// adds CPS using the scheduled executor
    //TODO figure out how to get text to update
    Runnable addCPS = new Runnable() {
        public void run() {
            farmcounter.cpsAddCrops(farmcounter.getCropsPerSecond());
            //txtView.setText(((int) farmcounter.getCropCount()) + " crops!");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.cropValue);
        upgradeText = (TextView) findViewById(R.id.upgradeClick);
        ScheduledExecutorService executor = autoCropIncrementer.getExecutor();
        executor.scheduleAtFixedRate(addCPS,0,1, TimeUnit.SECONDS);


    }

    public void cropClick(View v) {
        // Increments farmcounter by crop increment
        farmcounter.incrementCrops();
        String crops = ((int) farmcounter.getCropCount()) + " crops!";
        txtView.setText(crops);
    }

    public void upgradeClick(View v) {
        // upgrades increment value
        // at cost of crop


        if (farmcounter.getCropCount() > farmcounter.costToUpgrade()) {
            farmcounter.changeIncrement();
            String costToUpgrade = ((int) farmcounter.costToUpgrade()) + " crops to upgrade";
            upgradeText.setText(costToUpgrade);
        }
        String crops = ((int) farmcounter.getCropCount()) + " crops!";
        txtView.setText(crops);
    }

    public void addCPSClick (View v){
        //hard coded to add 1 farmers worth of CPS (2 crops right now)
        //TODO add in crop removal as cost to buy a farmer
        //TODO figure out if this is a valid way to implement this
        farmcounter.cpsIncrement(farmcounter.getCropsPerSecond()+ 2);
        farmcounter.getCropsPerSecond();

    }
}
