package sg.edu.ntu.medicine.lkc.service.AndroidApps;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//Android
@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("trackId")
    @Expose
    private Integer trackId;
    @SerializedName("iap")
    @Expose
    private Boolean iap;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("downloads")
    @Expose
    private String downloads;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("screenshots")
    @Expose
    private List<String> screenshots = new ArrayList<String>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("cat_type")
    @Expose
    private Integer catType;
    @SerializedName("content_rating")
    @Expose
    private String contentRating;
    @SerializedName("i18n_lang")
    @Expose
    private List<String> i18nLang = new ArrayList<String>();
    @SerializedName("cat_key")
    @Expose
    private String catKey;
    @SerializedName("price_i18n_countries")
    @Expose
    private List<Object> priceI18nCountries = new ArrayList<Object>();
    @SerializedName("downloads_max")
    @Expose
    private Integer downloadsMax;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("market_update")
    @Expose
    private String marketUpdate;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("cat_int")
    @Expose
    private Integer catInt;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("price_numeric")
    @Expose
    private Double priceNumeric;
    @SerializedName("downloads_min")
    @Expose
    private Integer downloadsMin;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("number_ratings")
    @Expose
    private Integer numberRatings;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("icon_72")
    @Expose
    private String icon72;
    @SerializedName("promo_video")
    @Expose
    private String promoVideo;
    @SerializedName("market_url")
    @Expose
    private String marketUrl;
    @SerializedName("deep_link")
    @Expose
    private String deepLink;

    /**
     *
     * @return The iap
     */
    public Boolean getIap() {
        return iap;
    }

    /**
     *
     * @param iap The iap
     */
    public void setIap(Boolean iap) {
        this.iap = iap;
    }

    /**
     *
     * @return The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     *
     * @param lang The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     *
     * @return The downloads
     */
    public String getDownloads() {
        return downloads;
    }

    /**
     *
     * @param downloads The downloads
     */
    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    /**
     *
     * @return The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return The screenshots
     */
    public List<String> getScreenshots() {
        return screenshots;
    }

    /**
     *
     * @param screenshots The screenshots
     */
    public void setScreenshots(List<String> screenshots) {
        this.screenshots = screenshots;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return The catType
     */
    public Integer getCatType() {
        return catType;
    }

    /**
     *
     * @param catType The cat_type
     */
    public void setCatType(Integer catType) {
        this.catType = catType;
    }

    /**
     *
     * @return The contentRating
     */
    public String getContentRating() {
        return contentRating;
    }

    /**
     *
     * @param contentRating The content_rating
     */
    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    /**
     *
     * @return The i18nLang
     */
    public List<String> getI18nLang() {
        return i18nLang;
    }

    /**
     *
     * @param i18nLang The i18n_lang
     */
    public void setI18nLang(List<String> i18nLang) {
        this.i18nLang = i18nLang;
    }

    /**
     *
     * @return The catKey
     */
    public String getCatKey() {
        return catKey;
    }

    /**
     *
     * @param catKey The cat_key
     */
    public void setCatKey(String catKey) {
        this.catKey = catKey;
    }

    /**
     *
     * @return The priceI18nCountries
     */
    public List<Object> getPriceI18nCountries() {
        return priceI18nCountries;
    }

    /**
     *
     * @param priceI18nCountries The price_i18n_countries
     */
    public void setPriceI18nCountries(List<Object> priceI18nCountries) {
        this.priceI18nCountries = priceI18nCountries;
    }

    /**
     *
     * @return The downloadsMax
     */
    public Integer getDownloadsMax() {
        return downloadsMax;
    }

    /**
     *
     * @param downloadsMax The downloads_max
     */
    public void setDownloadsMax(Integer downloadsMax) {
        this.downloadsMax = downloadsMax;
    }

    /**
     *
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return The packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     *
     * @param packageName The package_name
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     *
     * @return The marketUpdate
     */
    public String getMarketUpdate() {
        return marketUpdate;
    }

    /**
     *
     * @param marketUpdate The market_update
     */
    public void setMarketUpdate(String marketUpdate) {
        this.marketUpdate = marketUpdate;
    }

    /**
     *
     * @return The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return The catInt
     */
    public Integer getCatInt() {
        return catInt;
    }

    /**
     *
     * @param catInt The cat_int
     */
    public void setCatInt(Integer catInt) {
        this.catInt = catInt;
    }

    /**
     *
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     *
     * @param rating The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     *
     * @return The priceNumeric
     */
    public Double getPriceNumeric() {
        return priceNumeric;
    }

    /**
     *
     * @param priceNumeric The price_numeric
     */
    public void setPriceNumeric(Double priceNumeric) {
        this.priceNumeric = priceNumeric;
    }

    /**
     *
     * @return The downloadsMin
     */
    public Integer getDownloadsMin() {
        return downloadsMin;
    }

    /**
     *
     * @param downloadsMin The downloads_min
     */
    public void setDownloadsMin(Integer downloadsMin) {
        this.downloadsMin = downloadsMin;
    }

    /**
     *
     * @return The developer
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     *
     * @param developer The developer
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     *
     * @return The numberRatings
     */
    public Integer getNumberRatings() {
        return numberRatings;
    }

    /**
     *
     * @param numberRatings The number_ratings
     */
    public void setNumberRatings(Integer numberRatings) {
        this.numberRatings = numberRatings;
    }

    /**
     *
     * @return The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return The icon72
     */
    public String getIcon72() {
        return icon72;
    }

    /**
     *
     * @param icon72 The icon_72
     */
    public void setIcon72(String icon72) {
        this.icon72 = icon72;
    }

    /**
     *
     * @return The promoVideo
     */
    public String getPromoVideo() {
        return promoVideo;
    }

    /**
     *
     * @param promoVideo The promo_video
     */
    public void setPromoVideo(String promoVideo) {
        this.promoVideo = promoVideo;
    }

    /**
     *
     * @return The marketUrl
     */
    public String getMarketUrl() {
        return marketUrl;
    }

    /**
     *
     * @param marketUrl The market_url
     */
    public void setMarketUrl(String marketUrl) {
        this.marketUrl = marketUrl;
    }

    /**
     *
     * @return The deepLink
     */
    public String getDeepLink() {
        return deepLink;
    }

    /**
     *
     * @param deepLink The deep_link
     */
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }
    
    

}

