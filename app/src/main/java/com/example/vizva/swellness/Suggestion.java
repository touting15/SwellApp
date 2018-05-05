package com.example.vizva.swellness;

//Suggestions class

public class Suggestion {
    String title;
    String subtitle;
    int photoId;
    String xp;

    Suggestion(String title, String subtitle, int photoId, String xp) {
        this.title = title;
        this.subtitle = subtitle;
        this.photoId = photoId;
        this.xp = "XP: " + xp;
    }

}
