package hackathon.emirates.cheaproute;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhan on 3/14/15.
 */
public class CityLeg {
    private SkyscannerPlaceDetail skyscannerPlace;
    private int duration;
    private float latitude;
    private float longitude;
    private TripadvisorPlace tripadvisorPlace;
    private String skyscannerId;
    private String tripadvisorId;

    public CityLeg(SkyscannerPlaceDetail detail, String dur) {
        this.skyscannerPlace = detail;
        int duration = Integer.parseInt(dur);
        this.duration = duration > 0 ? duration : 0;
        this.skyscannerId = detail.getPlaceId();

        // Calling Google to get Lat Long
        new GoogleGeocodeAPI().execute(this.skyscannerPlace.getPlaceName(), this.skyscannerPlace.getCountryName());
    }

    private class GoogleGeocodeAPI extends AsyncTask<String, Void, GoogleLocationInfo>{
        @Override
        protected GoogleLocationInfo doInBackground(String... params) {
            String address = params[0] + ", " + params[1];
            List<NameValuePair> query = new ArrayList<NameValuePair>();
            query.add(new BasicNameValuePair("key", AppSettings.Google_Key));
            query.add(new BasicNameValuePair("address", address));

            String url = "https://maps.googleapis.com/maps/api/geocode/json?" +
                    URLEncodedUtils.format(query, "UTF-8");

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            GoogleLocationData locationData;
            try {
                GoogleLocationResponse response = mapper.readValue(new URL(url), GoogleLocationResponse.class);
                if (response.getStatus().equals("OK")) {
                    locationData = response.getResults()[0];
                    return locationData.getGeometry().getLocation();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(GoogleLocationInfo result) {
            if (result != null) {
                latitude = result.lat;
                longitude = result.lng;
            }

            new TripadvisorLocationAPI().execute(latitude, longitude);
        }
    }

    private class TripadvisorLocationAPI extends AsyncTask<Float, Void, TripadvisorPlace> {

        @Override
        protected TripadvisorPlace doInBackground(Float... params) {


            return null;
        }

        @Override
        protected  void onPostExecute(TripadvisorPlace place) {

        }
    }
}