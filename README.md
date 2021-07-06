:woman_technologist:# android-movie-app 

🎬Application that displays a list of Movies, TV shows and Trending using the Modern Android Application Development tools and API's.

To test this code you will need to:

1. Get an API Key from TMDB
2. Create a file on the Utils package with: const val SECRET_KEY = "PLACE YOUR API KEY HERE"
3. Api tested in Postman 

Base URL = "https://api.themoviedb.org/3/"

## Tech-Stack


1. Kotlin
2. Dagger 2 (For Dependency Injection)
3. rxJava (For Managing Background Tasks)
4. Retrofit (For Networking)
5. JetPack
6. ViewModel (For managing UI related data in a lifecycle conscious way)
7. LiveData (For notifying views of data changes)
8. Clean Architecture
9. MVVM
10.Postman

## Create a New Project

1. Open Android Studio and start a new project.
2. Select Empty Activity.
3. I have named my app- Movies and Tv Shows.  
4. For this project, I have set the minimum API level to 21.  
5. Make sure androidx.* artifacts is checked and click Finish.

## Import Dependencies

After it’s done building, open the app-level build.gradle and add the dependencies. As of this writing, those are the latest versions. Make sure to check the latest version of each dependency from the links provided.
Click Sync Now at the top right corner and it's done setting up the project.

## Project Resources

Open the xml files and need to add these strings. All three xml file like- strings.xml, colors.xml and styles.xml. 

## Fetch Movies from TMDb API Using Retrofit

In this section, I have used the Retrofit to connect to TMDb’s API. 
1. Add INTERNET permission in AndroidManifest.xml.
2. Create a new data class called Movie.
3. Create a new data class called GetMoviesResponse.
4. Create a new interface called Api.
5. Create a new object called MoviesRepository.
6. Add a new method in MoviesRepository called getPopularMovies().
7. Open MainActivity and call the getPopularMovies() method of MoviesRepository.
8. Run the app and check Logcat.(I can see the movie names in my terminal)

## Create a Horizontal List and Load Images Using Glide

Now that I can finally fetch movies from TMDb, it’s time to show these movies to the UI.

1. Open activity_main.xml and add a RecyclerView for popular movies.
2. Under res->layout folder, create a new layout called item_movie.xml.
3. Create a new class called MoviesAdapter.
4. Open the MainActivity and instantiate RecyclerView and Adapter.
5. Run the app. Scroll through the list and I can see all the movies poster and I have achieved half way. 

Take a deep breath and relax. :grinning:

## Pagination

While scrolling through the list, notice that you only see a limited number of movies. 
TMDb has thousands and thousands of movies in their database. Especially, when most of the time the user won’t scroll all of it. That’s why they paginate their movies API.

1. Open Api and I can see a the page parameter.
    class MoviesAdapter(
         private var movies: MutableList<Movie>
     ) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
         ...
    
         fun appendMovies(movies: List<Movie>) {
             this.movies.addAll(movies)
             notifyItemRangeInserted(
                 this.movies.size,
                 movies.size - 1
             )
         }
    
         ...
    }
    
    