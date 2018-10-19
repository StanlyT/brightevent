package data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Parcelable {

    public final static Parcelable.Creator<Pagination> CREATOR = new Creator<Pagination>() {
        @Override
        public Pagination createFromParcel(Parcel in) {
            return new Pagination(in);
        }

        @Override
        public Pagination[] newArray(int size) {
            return (new Pagination[size]);
        }

    };
    @SerializedName("object_count")
    @Expose
    private int objectCount;
    @SerializedName("page_number")
    @Expose
    private int pageNumber;
    @SerializedName("page_size")
    @Expose
    private int pageSize;
    @SerializedName("page_count")
    @Expose
    private int pageCount;
    @SerializedName("has_more_items")
    @Expose
    private boolean hasMoreItems;

    protected Pagination(Parcel in) {
        this.objectCount = ((int) in.readValue((int.class.getClassLoader())));
        this.pageNumber = ((int) in.readValue((int.class.getClassLoader())));
        this.pageSize = ((int) in.readValue((int.class.getClassLoader())));
        this.pageCount = ((int) in.readValue((int.class.getClassLoader())));
        this.hasMoreItems = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public Pagination() {
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isHasMoreItems() {
        return hasMoreItems;
    }

    public void setHasMoreItems(boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objectCount);
        dest.writeValue(pageNumber);
        dest.writeValue(pageSize);
        dest.writeValue(pageCount);
        dest.writeValue(hasMoreItems);
    }

    public int describeContents() {
        return 0;
    }
}
