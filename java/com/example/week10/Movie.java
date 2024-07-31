package com.example.week10;

public class Movie {
    public String Title;
    public String Year;
    public String imdbID;
    public String Poster;
    public String Type;
    public String mDirector;
    public String mPlot;

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        this.Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }
    public void setgImdbID(String imdbid) {
        this.imdbID = imdbid;
    }

    public String getPoster() {
        return Poster;
    }
    public void setPoster(String type) {
        this.Poster = type;
    }

    public String getType() {
        return Type;
    }
    public void setType(String type) {
        this.Type = type;
    }

    public String getDirector() {
        return mDirector;
    }
    public void setDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public String getPlot() {
        return mPlot;
    }
    public void setPlot(String mPlot) {
        this.mPlot = mPlot;
    }

}
