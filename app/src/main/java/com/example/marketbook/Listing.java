package com.example.marketbook;


import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Listing")
public class Listing extends ParseObject {

    private final String KEY_DESCRIPTION = "description";
    private final String KEY_ADDRESS = "address";
    private final String KEY_USER = "user";


    public String getDescriptio() {
        return getString(KEY_DESCRIPTION);

    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public String getAddress() {
        return getString(KEY_ADDRESS);
    }

    public void setAddress(String address) {
        put(KEY_ADDRESS,address);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER,user);
    }


}
