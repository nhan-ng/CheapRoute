package hackathon.emirates.cheaproute;

/**
 * Created by ManhTu on 3/14/2015.
 */

public class SkyscannerFlights {
    public String SessionKey;
    public String Status;
    public SkyscannerIntinerary[] Intineraries;

    public String getStatus() {
        return Status;
    }

    public SkyscannerIntinerary[] getIntineraries() {
        return Intineraries;
    }


}
