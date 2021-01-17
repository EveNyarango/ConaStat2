
package com.example.myconastat.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class CovidCases {
    @SerializedName("All")
    @Expose
    private List<All> all;
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
    public CovidCases(List<All> all) {
        super();
        this.all = all;
    }
    public List<All> getAll() {
        return all;
    }
    public void setAll(List <All> all) {
        this.all = all;
    }
}