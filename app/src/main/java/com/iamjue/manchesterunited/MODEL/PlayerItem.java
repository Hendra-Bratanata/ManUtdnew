package com.iamjue.manchesterunited.MODEL;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerItem implements Parcelable {
    String strPlayer, dateBorn, dateSigned, strPosition, strThumb, strNationality, strBirthLocation;
    String strDescriptionEN, strHeight, strWeight, strTwitter, strInstagram;


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

    public PlayerItem(Parcel in) {
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

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
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
