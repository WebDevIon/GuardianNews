package com.example.webdevion.guardiannews;

public class Article {

    // Variable for storing the section of the article.
    private String mArticleSection;

    // Variable for storing the date of the article.
    private String mArticleDate;

    // Variable for storing the title of the article.
    private String mArticleTitle;

    /** Website URL of the article */
    private String mUrl;

    /**
     * Constructs a new {@link Article} object.
     *
     * @param articleSection is the section of the article
     * @param articleDate is the date of the article
     * @param articleTitle are the title of the article
     * @param url is the website URL to find more details about the article
     */
    public Article(String articleSection, String articleDate, String articleTitle, String url) {
        mArticleSection = articleSection;
        mArticleDate = articleDate;
        mArticleTitle = articleTitle;
        mUrl = url;
    }

    // Get the section of the article.
    public String getArticleSection(){
        return mArticleSection;
    }

    // Get the date of the article.
    public String getArticleDate(){
        return mArticleDate;
    }

    // Get the title of the article.
    public String getArticleTitle(){
        return mArticleTitle;
    }

    // Returns the website URL to find more information about the article.
    public String getUrl() {
        return mUrl;
    }

}
