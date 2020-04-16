package io.github.thang86.weathers.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class demo
 */
public class Address implements Parcelable {
    private int icon;
    private String address;
    private String temperature;
    private int background;

    protected Address(Parcel in) {
        icon = in.readInt();
        address = in.readString();
        temperature = in.readString();
        background = in.readInt();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public Address(int icon, String address, String temperature, int background) {
        this.icon = icon;
        this.address = address;
        this.temperature = temperature;
        this.background = background;
    }

    public Address() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(address);
        dest.writeString(temperature);
        dest.writeInt(background);
    }
}
