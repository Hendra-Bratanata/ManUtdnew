package com.iamjue.manchesterunited;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerItem implements Parcelable {
    private String strPlayer, dateBorn, dateSigned, strPosition, strThumb, strNationality, strBirthLocation;
    private String strDescriptionEN, strHeight, strWeight, strTwitter, strInstagram;


    public PlayerItem(String strPlayer, String dateBorn, String dateSigned, String strPosition, String strThumb, String strNationality,
                      String strBirthLocation, String strDescriptionEN, String strHeight, String strWeight, String strTwitter, String strInstagram) {
        this.dateBorn = dateBorn;
        this.strPlayer = strPlayer;
        this.dateSigned = dateSigned;
        this.strPosition = strPosition;
        this.strThumb = strThumb;
        this.strNationality = strNationality;
        this.strBirthLocation = strBirthLocation;
        this.strDescriptionEN = strDescriptionEN;
        this.strHeight = strHeight;
        this.strWeight = strWeight;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;


    }

    protected PlayerItem(Parcel in) {
        strPlayer = in.readString();
        dateBorn = in.readString();
        dateSigned = in.readString();
        strPosition = in.readString();
        strThumb = in.readString();
        strNationality = in.readString();
        strBirthLocation = in.readString();
        strDescriptionEN = in.readString();
        strHeight = in.readString();
        strWeight = in.readString();
        strTwitter = in.readString();
        strInstagram = in.readString();
    }

    public static final Creator<PlayerItem> CREATOR = new Creator<PlayerItem>() {
        @Override
        public PlayerItem createFromParcel(Parcel in) {
            return new PlayerItem(in);
        }

        @Override
        public PlayerItem[] newArray(int size) {
            return new PlayerItem[size];
        }
    };

    String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }

    String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strPlayer);
        dest.writeString(dateBorn);
        dest.writeString(dateSigned);
        dest.writeString(strPosition);
        dest.writeString(strThumb);
        dest.writeString(strNationality);
        dest.writeString(strBirthLocation);
        dest.writeString(strDescriptionEN);
        dest.writeString(strHeight);
        dest.writeString(strWeight);
        dest.writeString(strTwitter);
        dest.writeString(strInstagram);
    }
}
