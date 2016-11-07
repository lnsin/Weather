
package io.github.kolacbb.kolaweather.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astro {

    @SerializedName("mr")
    @Expose
    private String mr;
    @SerializedName("ms")
    @Expose
    private String ms;
    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("ss")
    @Expose
    private String ss;

    /**
     * 
     * @return
     *     The mr
     */
    public String getMr() {
        return mr;
    }

    /**
     * 
     * @param mr
     *     The mr
     */
    public void setMr(String mr) {
        this.mr = mr;
    }

    /**
     * 
     * @return
     *     The ms
     */
    public String getMs() {
        return ms;
    }

    /**
     * 
     * @param ms
     *     The ms
     */
    public void setMs(String ms) {
        this.ms = ms;
    }

    /**
     * 
     * @return
     *     The sr
     */
    public String getSr() {
        return sr;
    }

    /**
     * 
     * @param sr
     *     The sr
     */
    public void setSr(String sr) {
        this.sr = sr;
    }

    /**
     * 
     * @return
     *     The ss
     */
    public String getSs() {
        return ss;
    }

    /**
     * 
     * @param ss
     *     The ss
     */
    public void setSs(String ss) {
        this.ss = ss;
    }

}
