package data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventBrite implements Parcelable {

    public final static Parcelable.Creator<EventBrite> CREATOR = new Creator<EventBrite>() {

        @Override
        public EventBrite createFromParcel(Parcel in) {
            return new EventBrite(in);
        }

        @Override
        public EventBrite[] newArray(int size) {
            return (new EventBrite[size]);
        }
    };
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    protected EventBrite(Parcel in) {
        this.pagination = ((Pagination) in.readValue((Pagination.class.getClassLoader())));
        in.readList(this.events, (data.entities.Event.class.getClassLoader()));
    }

    public EventBrite() {
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pagination);
        dest.writeList(events);
    }

    public int describeContents() {
        return 0;
    }
}
