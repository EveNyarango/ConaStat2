
package com.example.myconastat.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class CovidCases {
    @SerializedName("All")
    @Expose
    private All all;
    /**
     * No args constructor for use in serialization
     *
     */
    public CovidCases() {
    }
    /**
     *
     * @param all
     */
    public CovidCases(All all) {
        super();
        this.all = all;
    }
    public All getAll() {
        return all;
    }
    public void setAll(All all) {
        this.all = all;
    }
}