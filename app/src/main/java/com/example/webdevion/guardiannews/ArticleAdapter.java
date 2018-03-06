package com.example.webdevion.guardiannews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link Article} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * The part of the articleDate string from The Guardian service that we use to determine
     * where the date ends and the time begins ("2017-04-28T18:29:31Z").
     */
    private static final String DATE_SEPARATOR = "T";

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        // Find the TextView with view ID article_section
        TextView articleSectionView = (TextView) listItemView.findViewById(R.id.article_section);
        // Display the section of the current article in that TextView
        articleSectionView.setText(currentArticle.getArticleSection());

        // Get the original articleDate string from the Article object,
        // which can be in the format of "2017-04-28T18:29:31Z".
        String originalDate = currentArticle.getArticleDate();

        // If the original date string (i.e. "2017-04-28T18:29:31Z") contains
        // a date (2017-04-28) and a time (18:29:31) then store the date in the
        // extractedDate string so only the date can be displayed in the TextView.
        String extractedDate;

        // Check whether the originalDate string contains the "T" text
        if (originalDate.contains(DATE_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the "T text. We expect an array of 2 Strings, where
            // the first String will be "2017-04-28" and the second String will be "18:29:31Z".
            String[] parts = originalDate.split(DATE_SEPARATOR);
            // The extractedDate should be "2017-04-28"
            extractedDate = parts[0];
        } else {
            // Otherwise, there is no "T" text in the originalDate string.
            // Hence, set the default text to display instead of the date "Unknown date".
            extractedDate = getContext().getString(R.string.unknown_date);
        }

        // Find the TextView with view ID article_date
        TextView articleDateView = (TextView) listItemView.findViewById(R.id.article_date);
        // Display the date of the current article in that TextView
        articleDateView.setText(extractedDate);

        // Find the TextView with view ID article_title
        TextView articleTitleView = (TextView) listItemView.findViewById(R.id.aricle_title);
        // Display the title of the current article in that TextView
        articleTitleView.setText(currentArticle.getArticleTitle());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
