package com.example.marketbook;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

//this class needs to be registered in the parse class
//this class is used to parse data in the data or put database

@ParseClassName("Post")
public class Post extends ParseObject {
    //TODO: set up the comments and re-post functions

    public static final String KEY_DESCRIPTION = "text";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_LIKES = "likes";
    public static final String KEY_COMMENTS= "commentsAmount";
    public static final String KEY_SAVED= "saves";
    public static final String KEY_REPOSTS= "reposts";
    public static final String KEY_LIKEDFLAG= "liked";
    public static final String KEY_SAVEDFLAG= "saved";
    public static final String KEY_CREATED_AT = "createdAt";

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public int getLikes() {
        return getInt(KEY_LIKES);
    }

    public void setLikes(int likes){
        put(KEY_LIKES, likes );
    }

    public int getComments() {
        return getInt(KEY_COMMENTS);
    }

    public int getSaved() {
        return getInt(KEY_SAVED);
    }

    public void setSaved(int saved){
        put(KEY_SAVED, saved);
    }

    public int getReposts() {
        return getInt(KEY_REPOSTS);
    }

    public boolean getLikedFlagged(){return getBoolean(KEY_LIKEDFLAG);}

    public boolean getSavedFlagged(){return getBoolean(KEY_SAVEDFLAG);}

    public  void setLikedFlagged(Boolean flag){
        put(KEY_LIKEDFLAG, flag );
    }

    public  void setSavedFlagged(Boolean flag){
        put(KEY_SAVEDFLAG, flag );
    }


    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile image) {
        put(KEY_IMAGE, image);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

}
