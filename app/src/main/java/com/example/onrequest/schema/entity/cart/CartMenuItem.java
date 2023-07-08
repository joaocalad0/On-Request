package com.example.onrequest.schema.entity.cart;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.onrequest.schema.entity.item.MenuItem;

import java.util.Objects;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Cart.class,
                        parentColumns = {"cartId"},
                        childColumns = {"cartId"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = MenuItem.class,
                        parentColumns = {"menuItemId"},
                        childColumns = {"menuItemId"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class CartMenuItem implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long cartMenuItemId;

    @ColumnInfo(name = "menuItemId", index = true)
    private Long menuItemId;

    @ColumnInfo(name = "cartId", index = true)
    private Long cartId;

    public CartMenuItem(long cartMenuItemId, Long menuItemId, Long cartId) {
        this.cartMenuItemId = cartMenuItemId;
        this.menuItemId = menuItemId;
        this.cartId = cartId;
    }

    @Ignore
    public CartMenuItem(Cart cart, MenuItem menuItem) {
        this.menuItemId = menuItem.getMenuItemId();
        this.cartId = cart.getCartId();
    }

    @Ignore
    protected CartMenuItem(Parcel in) {
        cartMenuItemId = in.readLong();
        if (in.readByte() == 0) {
            menuItemId = null;
        } else {
            menuItemId = in.readLong();
        }
        if (in.readByte() == 0) {
            cartId = null;
        } else {
            cartId = in.readLong();
        }
    }

    public static final Creator<CartMenuItem> CREATOR = new Creator<CartMenuItem>() {
        @Override
        public CartMenuItem createFromParcel(Parcel in) {
            return new CartMenuItem(in);
        }

        @Override
        public CartMenuItem[] newArray(int size) {
            return new CartMenuItem[size];
        }
    };

    public long getCartMenuItemId() {
        return cartMenuItemId;
    }

    public void setCartMenuItemId(long cartMenuItemId) {
        this.cartMenuItemId = cartMenuItemId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(cartMenuItemId);
        if (menuItemId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(menuItemId);
        }
        if (cartId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(cartId);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartMenuItem that = (CartMenuItem) o;
        return cartMenuItemId == that.cartMenuItemId && Objects.equals(menuItemId, that.menuItemId) && Objects.equals(cartId, that.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartMenuItemId, menuItemId, cartId);
    }
}
