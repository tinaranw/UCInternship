package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RoleUser implements Parcelable {

    @SerializedName("id")
    private String roleuser_id;
    @SerializedName("uci_role_id")
    private String roleuser_role_id;
    @SerializedName("uci_user_id")
    private String roleuser_user_id;

    public RoleUser(){}

    public String getRoleuser_id() {
        return roleuser_id;
    }

    public void setRoleuser_id(String roleuser_id) {
        this.roleuser_id = roleuser_id;
    }

    public String getRoleuser_role_id() {
        return roleuser_role_id;
    }

    public void setRoleuser_role_id(String roleuser_role_id) {
        this.roleuser_role_id = roleuser_role_id;
    }

    public String getRoleuser_user_id() {
        return roleuser_user_id;
    }

    public void setRoleuser_user_id(String roleuser_user_id) {
        this.roleuser_user_id = roleuser_user_id;
    }



    public RoleUser(String roleuser_id, String roleuser_role_id, String roleuser_user_id) {
        this.roleuser_id = roleuser_id;
        this.roleuser_role_id = roleuser_role_id;
        this.roleuser_user_id = roleuser_user_id;
    }



    protected RoleUser(Parcel in) {
        roleuser_id = in.readString();
        roleuser_role_id = in.readString();
        roleuser_user_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(roleuser_id);
        dest.writeString(roleuser_role_id);
        dest.writeString(roleuser_user_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RoleUser> CREATOR = new Creator<RoleUser>() {
        @Override
        public RoleUser createFromParcel(Parcel in) {
            return new RoleUser(in);
        }

        @Override
        public RoleUser[] newArray(int size) {
            return new RoleUser[size];
        }
    };
}
