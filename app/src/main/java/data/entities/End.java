package data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class End implements Parcelable {

    public final static Parcelable.Creator<End> CREATOR = new Creator<End>() {
        @Override
        public End createFromParcel(Parcel in) {
            return new End(in);
        }

        @Override
        public End[] newArray(int size) {
            return (new End[size]);
        }
    };
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("utc")
    @Expose
    private String utc;

    protected End(Parcel in) {
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
        this.local = ((String) in.readValue((String.class.getClassLoader())));
        this.utc = ((String) in.readValue((String.class.getClassLoader())));
    }

    public End() {
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(timezone);
        dest.writeValue(local);
        dest.writeValue(utc);
    }

    public int describeContents() {
        return 0;
    }
}
