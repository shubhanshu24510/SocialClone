package com.shubhans.socialclone.utils

sealed class Screen(val route:String){
    object SplashScreen : Screen("splash_Screen")
    object RegisterScreen : Screen("register_Screen")
    object LoginScreen : Screen("login_Screen")
    object MainFeedScreen : Screen("main_feed_screen")
    object PostDetailsScreen : Screen("post_details")
    object ActivityScreen : Screen("activity_screen")
    object ChatScreen : Screen("chat_screen")
    object ProfileScreen : Screen("profile_screen")
    object ProfileEditScreen : Screen("edit_profile_screen")
    object PersonalListScreen : Screen("personal_list_screen")
    object CreatePostScreen : Screen("create_post_screen")
    object SearchScreen : Screen("search_screen")

}