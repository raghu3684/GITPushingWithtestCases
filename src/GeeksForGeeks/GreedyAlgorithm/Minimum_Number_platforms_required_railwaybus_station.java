package GeeksForGeeks.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ggorantla on 12/22/2014.
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class Minimum_Number_platforms_required_railwaybus_station {
    public void minimum_number_platforms_required_railway_bus_station(int[] arr, int[] dep){
        List<TimeNode> allTrains = new ArrayList<>();
        for (int a :arr){
            allTrains.add(new TimeNode(a,"Arrive"));
        }

        for (int d:dep){
            allTrains.add(new TimeNode(d,"Departure"));
        }

        Collections.sort(allTrains);

        for (TimeNode t: allTrains){
            System.out.println(t);
        }

        int stations = 0, result = 0;
        for (int i = 0; i < allTrains.size(); i++){
            if (stations > result)
                result = stations;
            if (allTrains.get(i).status.equals("Arrive")){
                stations++;
        //        System.out.println(stations);
            }
            else {
                stations--;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Minimum_Number_platforms_required_railwaybus_station object = new Minimum_Number_platforms_required_railwaybus_station();
        int[] arr11 = {};
        int[] dep11 = {};
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        object.minimum_number_platforms_required_railway_bus_station(arr,dep);
    }
}

class TimeNode implements Comparable<TimeNode>{
    int time ;
    String status;

    TimeNode(int time, String status){
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(TimeNode o) {
        return Integer.compare(time,o.time);
    }

    @Override
    public String toString(){
        return time+" "+status;
    }
}