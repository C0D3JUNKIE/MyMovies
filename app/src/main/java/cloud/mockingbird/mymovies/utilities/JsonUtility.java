package cloud.mockingbird.mymovies.utilities;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * JSON Utility class for parsing The Movie Database API response.
 */
public class JsonUtility {


  //Constant keys for json matching
  private static final String LOG_TAG = "JSON UTILITY:  ";
  private static final String STATUS_CODE = "status_code";

  public static final String STATUS_MESSAGE = "status_message";

  public static final String KEY_NUMBER_RESULTS = "total_results";
  public static final String KEY_TOTAL_PAGES = "total_pages";
  public static final String KEY_RESULTS = "results";

  public static final String KEY_VOTE_COUNT = "vote_count";
  public static final String KEY_ID = "id";
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

  /**
   * Method for associating returned values from API to MyMovies and MoviePoster object.
   *
   * @return String[][] multidimensional array with associated values.
   */
  public static String[][] getMoviePosterValuesFromJson(String movieJsonString)
      throws JSONException {

    //Declaring and initializing tokener.  Saw on walkthrough not sure this is needed since we are not doing a lot of iterating.
    //Strictly for logging purposes I presume.
    JSONTokener tokener = new JSONTokener(movieJsonString);
    //checking for additional elements and logging
    while (tokener.more()) {
      Log.d(LOG_TAG, tokener.nextValue().toString());
    }

    //Declaring and instantiating json object
    JSONObject moviePoster_root = new JSONObject(movieJsonString);
    //Logging status codes returned from TheMovieDB
    if (moviePoster_root.has(STATUS_CODE)) {
      //Assigning MovieDB status codes to vars for logging
      int movieDbResponse = moviePoster_root.getInt(STATUS_CODE);
      String movieDbStatus = moviePoster_root.getString(STATUS_MESSAGE);
      if (moviePoster_root.has(STATUS_MESSAGE)) {
        movieDbStatus = String
            .format("JSON STATUS MESSAGE: ", moviePoster_root.getString(STATUS_MESSAGE));
      }
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

    //Get individual array of a movie
    JSONArray jsonMoviePosterArray = moviePoster_root.getJSONArray(KEY_RESULTS);
    //Grabbing number of arrays from returned json
    int jsonArrayLength = jsonMoviePosterArray.length();
    //Create and instantiate object to hold individual movies
    String[][] movieContentValues = new String[jsonArrayLength][];

    //Loop through the individual values and assign to above array
    for (int i = 0; i < jsonMoviePosterArray.length(); i++) {

      JSONObject individualMovieObject = jsonMoviePosterArray.getJSONObject(i);

      int vote_count = individualMovieObject.getInt(KEY_VOTE_COUNT);
      int identification = individualMovieObject.getInt(KEY_ID);

      double rating = individualMovieObject.getDouble(KEY_VOTE_AVERAGE);

      String video = individualMovieObject.getString(KEY_VIDEO);
      String title = individualMovieObject.getString(KEY_MOVIE_TITLE);
      String image = individualMovieObject.getString(KEY_MOVIE_POSTER_PATH);
      String popularity = individualMovieObject.getString(KEY_MOVIE_POPULARITY);
      String original_language = individualMovieObject.getString(KEY_MOVIE_ORIGINAL_LANGUAGE);
      String original_title = individualMovieObject.getString(KEY_MOVIE_ORIGINAL_TITLE);

      List<String> genreList = new ArrayList<>();
      JSONArray genre_ids = individualMovieObject.getJSONArray(KEY_MOVIE_GENRE_ID);

      String backdrop_path = individualMovieObject.getString(KEY_MOVIE_BACKDROP_PATH);
      String adult = individualMovieObject.getString(KEY_MOVIE_ADULT);
      String plot = individualMovieObject.getString(KEY_MOVIE_OVERVIEW);
      String release_date = individualMovieObject.getString(KEY_MOVIE_RELEASE_DATE);

      //String array to hold individual movie:  id[0], title[1], plot[2], language[3], date[4], image[5], vote[6], rating[7]
      String[] individualMovie = {String.valueOf(identification), title, plot, original_language,
          release_date, image, String.valueOf(vote_count), String.valueOf(rating)};
      movieContentValues[i] = individualMovie;

    }

    //return parsed values
    return movieContentValues;

  }

}

