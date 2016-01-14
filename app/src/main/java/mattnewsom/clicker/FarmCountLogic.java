package mattnewsom.clicker;

/**
 * Created by Matthew on 12/16/2015.
 */
public class FarmCountLogic {
    double cropCount = 0;
    double cropCountIncrement = 1;
    double upgrade = 1;
    double cropsPerSecond = 0;



    //call this method to increment crop by cropCountIncrement
    public double incrementCrops (){
        cropCount = cropCountIncrement+cropCount;
        return cropCount;
    }

    public double getCropCount(){
        return cropCount;
    }

    //call this to upgrade clicks
    public double changeIncrement (){

        cropCountIncrement = cropCountIncrement+1;
        removeCrops(costToUpgrade());
        upgrade = (upgrade*Math.exp(1.15));
        return cropCountIncrement;
    }

    public double removeCrops(double remove){
        cropCount = cropCount-remove;
        return cropCount;
    }

    public double costToUpgrade(){
        return upgrade*Math.exp(1.15);
    }

    public void cpsIncrement(double increment){
        cropsPerSecond=cropsPerSecond+increment;

    }
    public double getCropsPerSecond(){
        return cropsPerSecond;
    }

    public void cpsAddCrops(double cps){
        cropCount = cropCount+cps;
    }


}

