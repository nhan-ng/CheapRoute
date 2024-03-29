package hackathon.emirates.cheaproute;

/**
 * Created by nhan on 3/14/15.
 *       "ranking_data": {
 "geo_location_id": "60745",
 "ranking_string": "#1 of 139 activities in Boston",
 "geo_location_name": "Boston",
 "ranking_out_of": "139",
 "ranking": "1"
 }
 */
public class TripadvisorRankingDetail {
    public String geo_location_id;
    public String ranking_string;
    public String geo_location_name;
    public String ranking_out_of;
    public String ranking;

    public TripadvisorRankingDetail(String geo_location_id, String ranking_string, String geo_location_name, String ranking_out_of, String ranking) {
        this.geo_location_id = geo_location_id;
        this.ranking_string = ranking_string;
        this.geo_location_name = geo_location_name;
        this.ranking_out_of = ranking_out_of;
        this.ranking = ranking;
    }

    public TripadvisorRankingDetail() {
    }

    public String getGeo_location_id() {
        return geo_location_id;
    }

    public void setGeo_location_id(String geo_location_id) {
        this.geo_location_id = geo_location_id;
    }

    public String getRanking_string() {
        return ranking_string;
    }

    public void setRanking_string(String ranking_string) {
        this.ranking_string = ranking_string;
    }

    public String getGeo_location_name() {
        return geo_location_name;
    }

    public void setGeo_location_name(String geo_location_name) {
        this.geo_location_name = geo_location_name;
    }

    public String getRanking_out_of() {
        return ranking_out_of;
    }

    public void setRanking_out_of(String ranking_out_of) {
        this.ranking_out_of = ranking_out_of;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
