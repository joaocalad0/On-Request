package com.example.onrequest.schema.entity.cart;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import com.example.onrequest.schema.entity.item.MenuItem;

import java.util.Objects;

public class CartWithMenuItems implements Parcelable {

    @Embedded
    public CartMenuItem cartMenuItem;

    @Relation(entity = Cart.class, parentColumn = "cartId", entityColumn = "cartId")
    public Cart cart;

    @Relation(entity = MenuItem.class, parentColumn = "menuItemId", entityColumn = "menuItemId")
    public MenuItem menuItem;

    public CartWithMenuItems() {
    }

    @Ignore
    protected CartWithMenuItems(Parcel in) {
        cartMenuItem = in.readParcelable(CartMenuItem.class.getClassLoader());
        cart = in.readParcelable(Cart.class.getClassLoader());
        menuItem = in.readParcelable(MenuItem.class.getClassLoader());
    }

    public static final Creator<CartWithMenuItems> CREATOR = new Creator<CartWithMenuItems>() {
        @Override
        public CartWithMenuItems createFromParcel(Parcel in) {
            return new CartWithMenuItems(in);
        }

        @Override
        public CartWithMenuItems[] newArray(int size) {
            return new CartWithMenuItems[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(cartMenuItem, i);
        parcel.writeParcelable(cart, i);
        parcel.writeParcelable(menuItem, i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartWithMenuItems that = (CartWithMenuItems) o;
        return Objects.equals(cartMenuItem, that.cartMenuItem) && Objects.equals(cart, that.cart) && Objects.equals(menuItem, that.menuItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartMenuItem, cart, menuItem);
    }
}
