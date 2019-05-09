package com.example.marketbook;


import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Images")
public class Images extends ParseObject {

    private final String KEY_IMAGE = "image";
    private final String KEY_LISTING = "listing";

    public ParseFile getImage() {
        return  getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseObject getListing() {
        return getParseObject(KEY_LISTING);
    }

    public void setListing(ParseObject listing) {
        put(KEY_LISTING, listing);
    }
}
