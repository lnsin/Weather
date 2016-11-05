
package io.github.kolacbb.kolaweather.model.HeWeather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeWeather {

    @SerializedName("HeWeather data service 3.0")
    @Expose
    private List<HeWeatherData> HeWeatherData = new ArrayList<HeWeatherData>();

    /**
     * 
     * @return
     *     The HeWeatherData
     */
    public List<HeWeatherData> getHeWeatherData() {
        return HeWeatherData;
    }

    /**
     * 
     * @param HeWeatherData
     *     The HeWeather data service 3.0
     */
    public void setHeWeatherData(List<HeWeatherData> HeWeatherData) {
        this.HeWeatherData = HeWeatherData;
    }

}
