package mattnewsom.clicker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Matthew on 1/13/2016.
 */
public class AutoCropIncrementer {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


    public ScheduledExecutorService getExecutor() {

        return executor;
    }

    }
