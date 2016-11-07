
package io.github.kolacbb.kolaweather.model.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("HeWeather5")
    @Expose
    private List<HeWeather5> heWeather5 = new ArrayList<HeWeather5>();

    /**
     * 
     * @return
     *     The heWeather5
     */
    public List<HeWeather5> getHeWeather5() {
        return heWeather5;
    }

    /**
     * 
     * @param heWeather5
     *     The HeWeather5
     */
    public void setHeWeather5(List<HeWeather5> heWeather5) {
        this.heWeather5 = heWeather5;
    }

}
