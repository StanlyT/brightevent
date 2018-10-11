package data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events implements Parcelable {

    public final static Parcelable.Creator<Events> CREATOR = new Creator<Events>() {

        @Override
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return (new Events[size]);
        }

    };
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    protected Events(Parcel in) {
        in.readList(this.events, (Event.class.getClassLoader()));
    }

    public Events() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(events);
    }

    public int describeContents() {
        return 0;
    }

}
