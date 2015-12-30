package mattnewsom.clicker;

/**
 * Created by Matthew on 12/16/2015.
 */
public class FarmCountLogic {
    double cropCount = 0;
    double cropCountIncrement = 1;
    double upgrade = 1;

    //call this method to increment crop by cropCountIncrement
    public double incrementCrops (){
        cropCount = cropCountIncrement+cropCount;
        return cropCount;
    }


    public double getCropCount(){
        return cropCount;
    }

    //call this in conjunction with remove crops to upgrade clicks
    public double changeIncrement (){

        //TODO determine how applicable the function is
        cropCountIncrement = cropCountIncrement+(upgrade*Math.exp(3.0));
        upgrade = upgrade+5;
        return cropCountIncrement;
    }

    public double removeCrops(double remove){
        cropCount = cropCount-remove;
        return cropCount-remove;
    }

    public double costToUpgrade(){
        //generate an array of costs?

        return Math.exp(upgrade);
    }
}

