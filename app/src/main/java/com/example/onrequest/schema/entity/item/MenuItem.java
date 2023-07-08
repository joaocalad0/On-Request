package com.example.onrequest.schema.entity.item;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class MenuItem implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long menuItemId;

    @Nullable
    @ColumnInfo(name = "menuItemName")
    private String menuItemName;

    @ColumnInfo(name = "menuItemPrice")
    private double menuItemPrice;

    @Nullable
    @ColumnInfo(name = "menuItemAvatar")
    private Uri menuItemAvatar;

    @Nullable
    @ColumnInfo(name = "menuItemCategory")
    private MenuItemCategory menuItemCategory;

    @Nullable
    @ColumnInfo(name = "menuItemDesc")
    private String menuItemDesc;

    public MenuItem() {
    }

    public MenuItem(long menuItemId, @Nullable String menuItemName, double menuItemPrice,
                    @Nullable Uri menuItemAvatar, @Nullable MenuItemCategory menuItemCategory, @Nullable String menuItemDesc) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
        this.menuItemAvatar = menuItemAvatar;
        this.menuItemCategory = menuItemCategory;
        this.menuItemDesc = menuItemDesc;
    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public Double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(Double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public Uri getMenuItemAvatar() {
        return menuItemAvatar;
    }

    public void setMenuItemAvatar(Uri menuItemAvatar) {
        this.menuItemAvatar = menuItemAvatar;
    }

    public MenuItemCategory getMenuItemCategory() {
        return menuItemCategory;
    }

    public void setMenuItemCategory(MenuItemCategory menuItemCategory) {
        this.menuItemCategory = menuItemCategory;
    }

    public String getMenuItemDesc() {
        return menuItemDesc;
    }

    public void setMenuItemDesc(String menuItemDesc) {
        this.menuItemDesc = menuItemDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected MenuItem(Parcel in) {
        this.menuItemId = in.readLong();
        this.menuItemName = in.readString();
        this.menuItemPrice = in.readDouble();
        this.menuItemAvatar = Uri.parse(in.readString());
        this.menuItemCategory = MenuItemCategory.valueOf(in.readString());
        this.menuItemDesc = in.readString();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeLong(this.menuItemId);
        parcel.writeString(this.menuItemName);
        parcel.writeDouble(this.menuItemPrice);
        parcel.writeString(this.menuItemAvatar.toString());
        parcel.writeString(this.menuItemCategory.name());
        parcel.writeString(this.menuItemDesc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return menuItemId == menuItem.menuItemId && Double.compare(menuItem.menuItemPrice, menuItemPrice) == 0 && Objects.equals(menuItemName, menuItem.menuItemName) && Objects.equals(menuItemAvatar, menuItem.menuItemAvatar) && menuItemCategory == menuItem.menuItemCategory && Objects.equals(menuItemDesc, menuItem.menuItemDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItemId, menuItemName, menuItemPrice, menuItemAvatar, menuItemCategory, menuItemDesc);
    }
}
