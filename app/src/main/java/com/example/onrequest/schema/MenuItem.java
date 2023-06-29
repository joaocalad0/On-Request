package com.example.onrequest.schema;

import android.net.Uri;

import java.io.Serializable;

public interface MenuItem extends Serializable {

    long getId();

    Double getPrice();

    String getName();

    Uri getDrinkAvatar();

}
