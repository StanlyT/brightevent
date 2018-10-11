package data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable {

    public final static Parcelable.Creator<Event> CREATOR = new Creator<Event>() {

        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return (new Event[size]);
        }

    };
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("end")
    @Expose
    private End end;
    @SerializedName("organization_id")
    @Expose
    private String organizationId;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("capacity")
    @Expose
    private Object capacity;
    @SerializedName("capacity_is_custom")
    @Expose
    private Object capacityIsCustom;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("listed")
    @Expose
    private boolean listed;
    @SerializedName("shareable")
    @Expose
    private boolean shareable;
    @SerializedName("online_event")
    @Expose
    private boolean onlineEvent;
    @SerializedName("tx_time_limit")
    @Expose
    private int txTimeLimit;
    @SerializedName("hide_start_date")
    @Expose
    private boolean hideStartDate;
    @SerializedName("hide_end_date")
    @Expose
    private boolean hideEndDate;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("is_locked")
    @Expose
    private boolean isLocked;
    @SerializedName("privacy_setting")
    @Expose
    private String privacySetting;
    @SerializedName("is_series")
    @Expose
    private boolean isSeries;
    @SerializedName("is_series_parent")
    @Expose
    private boolean isSeriesParent;
    @SerializedName("is_reserved_seating")
    @Expose
    private boolean isReservedSeating;
    @SerializedName("show_pick_a_seat")
    @Expose
    private boolean showPickASeat;
    @SerializedName("show_seatmap_thumbnail")
    @Expose
    private boolean showSeatmapThumbnail;
    @SerializedName("show_colors_in_seatmap_thumbnail")
    @Expose
    private boolean showColorsInSeatmapThumbnail;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("is_free")
    @Expose
    private boolean isFree;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("logo_id")
    @Expose
    private String logoId;
    @SerializedName("organizer_id")
    @Expose
    private String organizerId;
    @SerializedName("venue_id")
    @Expose
    private String venueId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("format_id")
    @Expose
    private String formatId;
    @SerializedName("resource_uri")
    @Expose
    private String resourceUri;
    @SerializedName("is_externally_ticketed")
    @Expose
    private boolean isExternallyTicketed;
    @SerializedName("logo")
    @Expose
    private Logo logo;

    protected Event(Parcel in) {
        this.name = ((Name) in.readValue((Name.class.getClassLoader())));
        this.description = ((Description) in.readValue((Description.class.getClassLoader())));
        this.logo = ((Logo) in.readValue((Logo.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.start = ((Start) in.readValue((Start.class.getClassLoader())));
        this.end = ((End) in.readValue((End.class.getClassLoader())));
        this.organizationId = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        this.capacity = ((Object) in.readValue((Object.class.getClassLoader())));
        this.capacityIsCustom = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.listed = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.shareable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.onlineEvent = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.txTimeLimit = ((int) in.readValue((int.class.getClassLoader())));
        this.hideStartDate = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.hideEndDate = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.locale = ((String) in.readValue((String.class.getClassLoader())));
        this.isLocked = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.privacySetting = ((String) in.readValue((String.class.getClassLoader())));
        this.isSeries = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isSeriesParent = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isReservedSeating = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.showPickASeat = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.showSeatmapThumbnail = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.showColorsInSeatmapThumbnail = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.isFree = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
        this.logoId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizerId = ((String) in.readValue((String.class.getClassLoader())));
        this.venueId = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.subcategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.formatId = ((String) in.readValue((String.class.getClassLoader())));
        this.resourceUri = ((String) in.readValue((String.class.getClassLoader())));
        this.isExternallyTicketed = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public Event() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Object getCapacity() {
        return capacity;
    }

    public void setCapacity(Object capacity) {
        this.capacity = capacity;
    }

    public Object getCapacityIsCustom() {
        return capacityIsCustom;
    }

    public void setCapacityIsCustom(Object capacityIsCustom) {
        this.capacityIsCustom = capacityIsCustom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    public boolean isOnlineEvent() {
        return onlineEvent;
    }

    public void setOnlineEvent(boolean onlineEvent) {
        this.onlineEvent = onlineEvent;
    }

    public int getTxTimeLimit() {
        return txTimeLimit;
    }

    public void setTxTimeLimit(int txTimeLimit) {
        this.txTimeLimit = txTimeLimit;
    }

    public boolean isHideStartDate() {
        return hideStartDate;
    }

    public void setHideStartDate(boolean hideStartDate) {
        this.hideStartDate = hideStartDate;
    }

    public boolean isHideEndDate() {
        return hideEndDate;
    }

    public void setHideEndDate(boolean hideEndDate) {
        this.hideEndDate = hideEndDate;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getPrivacySetting() {
        return privacySetting;
    }

    public void setPrivacySetting(String privacySetting) {
        this.privacySetting = privacySetting;
    }

    public boolean isIsSeries() {
        return isSeries;
    }

    public void setIsSeries(boolean isSeries) {
        this.isSeries = isSeries;
    }

    public boolean isIsSeriesParent() {
        return isSeriesParent;
    }

    public void setIsSeriesParent(boolean isSeriesParent) {
        this.isSeriesParent = isSeriesParent;
    }

    public boolean isIsReservedSeating() {
        return isReservedSeating;
    }

    public void setIsReservedSeating(boolean isReservedSeating) {
        this.isReservedSeating = isReservedSeating;
    }

    public boolean isShowPickASeat() {
        return showPickASeat;
    }

    public void setShowPickASeat(boolean showPickASeat) {
        this.showPickASeat = showPickASeat;
    }

    public boolean isShowSeatmapThumbnail() {
        return showSeatmapThumbnail;
    }

    public void setShowSeatmapThumbnail(boolean showSeatmapThumbnail) {
        this.showSeatmapThumbnail = showSeatmapThumbnail;
    }

    public boolean isShowColorsInSeatmapThumbnail() {
        return showColorsInSeatmapThumbnail;
    }

    public void setShowColorsInSeatmapThumbnail(boolean showColorsInSeatmapThumbnail) {
        this.showColorsInSeatmapThumbnail = showColorsInSeatmapThumbnail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getFormatId() {
        return formatId;
    }

    public void setFormatId(String formatId) {
        this.formatId = formatId;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public boolean isIsExternallyTicketed() {
        return isExternallyTicketed;
    }

    public void setIsExternallyTicketed(boolean isExternallyTicketed) {
        this.isExternallyTicketed = isExternallyTicketed;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(start);
        dest.writeValue(end);
        dest.writeValue(organizationId);
        dest.writeValue(created);
        dest.writeValue(changed);
        dest.writeValue(capacity);
        dest.writeValue(capacityIsCustom);
        dest.writeValue(status);
        dest.writeValue(currency);
        dest.writeValue(listed);
        dest.writeValue(shareable);
        dest.writeValue(onlineEvent);
        dest.writeValue(txTimeLimit);
        dest.writeValue(hideStartDate);
        dest.writeValue(hideEndDate);
        dest.writeValue(locale);
        dest.writeValue(isLocked);
        dest.writeValue(privacySetting);
        dest.writeValue(isSeries);
        dest.writeValue(isSeriesParent);
        dest.writeValue(isReservedSeating);
        dest.writeValue(showPickASeat);
        dest.writeValue(showSeatmapThumbnail);
        dest.writeValue(showColorsInSeatmapThumbnail);
        dest.writeValue(source);
        dest.writeValue(isFree);
        dest.writeValue(version);
        dest.writeValue(logoId);
        dest.writeValue(organizerId);
        dest.writeValue(venueId);
        dest.writeValue(categoryId);
        dest.writeValue(subcategoryId);
        dest.writeValue(formatId);
        dest.writeValue(resourceUri);
        dest.writeValue(isExternallyTicketed);
        dest.writeValue(logo);
    }

    public int describeContents() {
        return 0;
    }
}
