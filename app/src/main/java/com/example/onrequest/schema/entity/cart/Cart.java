package com.example.onrequest.schema.entity.cart;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.onrequest.schema.entity.table.MenuTable;

import java.util.Objects;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = MenuTable.class,
                        parentColumns = {"menuTableId"},
                        childColumns = {"menuTableId"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class Cart implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long cartId;

    @ColumnInfo(name = "menuTableId", index = true)
    private Long menuTableId;

    @ColumnInfo(name = "cartState")
    private CartState cartState;

    public Cart(long cartId, Long menuTableId, CartState cartState) {
        this.cartId = cartId;
        this.menuTableId = menuTableId;
        this.cartState = cartState;
    }

    @Ignore
    public Cart(MenuTable menuTable) {
        this.menuTableId = menuTable.getMenuTableId();
        this.cartState = CartState.OPEN;
    }

    protected Cart(Parcel in) {
        cartId = in.readLong();
        cartState = CartState.valueOf(in.readString());
        if (in.readByte() == 0) {
            menuTableId = null;
        } else {
            menuTableId = in.readLong();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(cartId);
        dest.writeString(cartState.name());
        if (menuTableId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(menuTableId);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public Long getMenuTableId() {
        return menuTableId;
    }

    public void setMenuTableId(Long menuTableId) {
        this.menuTableId = menuTableId;
    }

    public CartState getCartState() {
        return cartState;
    }

    public void setCartState(CartState cartState) {
        this.cartState = cartState;
    }

    public void pay() {
        this.cartState = CartState.PAYED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId && Objects.equals(menuTableId, cart.menuTableId) && cartState == cart.cartState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, menuTableId, cartState);
    }
}
