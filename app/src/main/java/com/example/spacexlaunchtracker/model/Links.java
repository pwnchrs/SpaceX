package com.example.spacexlaunchtracker.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Links implements Serializable {
    @SerializedName("mission_patch")
    @Expose
    private String missionPatch;
    @SerializedName("mission_patch_small")
    @Expose
    private String missionPatchSmall;
    @SerializedName("reddit_campaign")
    @Expose
    private Object redditCampaign;
    @SerializedName("reddit_launch")
    @Expose
    private Object redditLaunch;
    @SerializedName("reddit_recovery")
    @Expose
    private Object redditRecovery;
    @SerializedName("reddit_media")
    @Expose
    private Object redditMedia;
    @SerializedName("presskit")
    @Expose
    private Object presskit;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("video_link")
    @Expose
    private String videoLink;
    @SerializedName("youtube_id")
    @Expose
    private String youtubeId;
    @SerializedName("flickr_images")
    @Expose
    private List<Object> flickrImages;

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public Object getRedditCampaign() {
        return redditCampaign;
    }

    public void setRedditCampaign(Object redditCampaign) {
        this.redditCampaign = redditCampaign;
    }

    public Object getRedditLaunch() {
        return redditLaunch;
    }

    public void setRedditLaunch(Object redditLaunch) {
        this.redditLaunch = redditLaunch;
    }

    public Object getRedditRecovery() {
        return redditRecovery;
    }

    public void setRedditRecovery(Object redditRecovery) {
        this.redditRecovery = redditRecovery;
    }

    public Object getRedditMedia() {
        return redditMedia;
    }

    public void setRedditMedia(Object redditMedia) {
        this.redditMedia = redditMedia;
    }

    public Object getPresskit() {
        return presskit;
    }

    public void setPresskit(Object presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public List<Object> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(List<Object> flickrImages) {
        this.flickrImages = flickrImages;
    }

}
