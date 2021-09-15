package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class card implements Parcelable {
    private String nama, alamat;
    private int umur;

    public card() {
        this.nama = "";
        this.umur = 0;
        this.alamat = "";
    }

    public card(String nama, int umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }


    protected card(Parcel in) {
        nama = in.readString();
        umur = in.readInt();
        alamat = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<card> CREATOR = new Creator<card>() {
        @Override
        public card createFromParcel(Parcel in) {
            return new card(in);
        }

        @Override
        public card[] newArray(int size) {
            return new card[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(umur);
        dest.writeString(alamat);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

}



