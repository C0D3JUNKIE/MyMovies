package cloud.mockingbird.mymovies.utilities;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtility {

  private static final String LOG_TAG = "JSON UTILITY:  ";

  private static final String STATUS_CODE = "status_code";
  public static final String STATUS_MESSAGE = "status_message";

  public static final String KEY_NUMBER_RESULTS = "total_results";
  public static final String KEY_TOTAL_PAGES = "total_pages";
  public static final String KEY_RESULTS = "all_results";

  public static final String KEY_VOTE_COUNT = "vote_count";
  public static final String KEY_ID =  "id";
  public static final String KEY_VIDEO = "video"; //This is a boolean value
  public static final String KEY_VOTE_AVERAGE = "vote_average";
  public static final String KEY_MOVIE_TITLE = "title";
  public static final String KEY_MOVIE_POPULARITY = "popularity";
  public static final String KEY_MOVIE_POSTER_PATH = "poster_path";
  public static final String KEY_MOVIE_ORIGINAL_LANGUAGE = "original_language";
  public static final String KEY_MOVIE_ORIGINAL_TITLE = "original_title";
  public static final String KEY_MOVIE_GENRE_ID = "genre_ids";
  public static final String KEY_MOVIE_BACKDROP_PATH = "backdrop_path";
  public static final String KEY_MOVIE_ADULT = "adult"; //This is a boolean value
  public static final String KEY_MOVIE_OVERVIEW = "overview";
  public static final String KEY_MOVIE_RELEASE_DATE = "release_date";

  public static String[][] getMoviePosterValuesFromJson(Context context, String movieJsonString) throws JSONException {

    JSONTokener tokener = new JSONTokener(movieJsonString);

    while(tokener.more()){
      Log.d(LOG_TAG, tokener.nextValue().toString());
    }

    JSONObject moviePoster_root = new JSONObject(movieJsonString);

    if(moviePoster_root.has(STATUS_CODE)) {

      //Assigning MovieDB status codes to vars for logging
      int movieDbResponse = moviePoster_root.getInt(STATUS_CODE);
      String movieDbStatus = moviePoster_root.getString(STATUS_MESSAGE);
      //Switch for MovieDB status codes, for specific messages see:  https://www.themoviedb.org/documentation/api/status-codes
      switch (movieDbResponse) {
        case 200:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 201:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 400:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 401:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 403:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 404:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 405:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 406:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 422:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 429:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 500:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 501:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 503:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        case 504:
          Log.v(LOG_TAG, movieDbStatus);
          return null;
        default:
          return null;
      }
    }

    JSONArray jsonMoviePosterArray = moviePoster_root.getJSONArray(KEY_ID);

    String[][] movieContentValues = new String[jsonMoviePosterArray.length()][];

    for(int i = 0; i <jsonMoviePosterArray.length(); i++) {

      JSONObject individualMovieObject = jsonMoviePosterArray.getJSONObject(i);

      int vote_count = moviePoster_root.getInt(KEY_VOTE_COUNT);
      int identification = moviePoster_root.getInt(KEY_ID);

      double rating = moviePoster_root.getDouble(KEY_VOTE_AVERAGE);

      String video = moviePoster_root.getString(KEY_VIDEO);
      String title = moviePoster_root.getString(KEY_MOVIE_TITLE);
      String image = moviePoster_root.getString(KEY_MOVIE_POSTER_PATH);
      String popularity = moviePoster_root.getString(KEY_MOVIE_POPULARITY);
      String original_language = moviePoster_root.getString(KEY_MOVIE_ORIGINAL_LANGUAGE);
      String original_title = moviePoster_root.getString(KEY_MOVIE_ORIGINAL_TITLE);

      List<String> genreList = new ArrayList<>();
      JSONArray genre_ids = moviePoster_root.getJSONArray(KEY_MOVIE_GENRE_ID);

      String backdrop_path = moviePoster_root.getString(KEY_MOVIE_BACKDROP_PATH);
      String adult = moviePoster_root.getString(KEY_MOVIE_ADULT);
      String plot = moviePoster_root.getString(KEY_MOVIE_OVERVIEW);
      String release_date = moviePoster_root.getString(KEY_MOVIE_RELEASE_DATE);

      String[] individualMovie = {String.valueOf(identification), title, plot, original_language, release_date, image, String.valueOf(vote_count), String.valueOf(rating)};

      movieContentValues[i] = individualMovie;

    }

    return movieContentValues;

  }

}

