package sg.edu.ntu.medicine.lkc.service.AndroidApps;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkcuser
 */
public class Results {

    //"number_results":484,"has_next":true,"page":2,"num_pages":49,"limit":10
    @SerializedName("results")
    @Expose
    private List<Data> results = new ArrayList<Data>();
    @SerializedName("number_results")
    @Expose
    private Integer numberResults;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("num_pages")
    @Expose
    private Integer numPages;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    /**
     *
     * @return The results
     */
    public List<Data> getResults() {
        return results;
    }

    /**
     *
     * @param results The results
     */
    public void setResults(List<Data> results) {
        this.results = results;
    }

    /**
     *
     * @return The numberResults
     */
    public Integer getNumberResults() {
        return numberResults;
    }

    /**
     *
     * @param numberResults The number_results
     */
    public void setNumberResults(Integer numberResults) {
        this.numberResults = numberResults;
    }

    /**
     *
     * @return The hasNext
     */
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     *
     * @param hasNext The has_next
     */
    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     *
     * @return The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return The numPages
     */
    public Integer getNumPages() {
        return numPages;
    }

    /**
     *
     * @param numPages The num_pages
     */
    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    /**
     *
     * @return The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
