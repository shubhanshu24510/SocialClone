package com.shubhans.socialclone.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.prestation.logIn.LoginScreen
import com.shubhans.socialclone.prestation.mainFeed.MainFeedScreen
import com.shubhans.socialclone.prestation.post_details.PostDetailsScreen
import com.shubhans.socialclone.prestation.splash.SplashScreen
import com.shubhans.socialclone.prestation.register.RegisterScreen

@Composable
fun Navigation(navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(
                navController = navController
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
//        composable(Screen.ChatScreen.route) {
//            ChatScreen(navController = navController)
//        }
//        composable(Screen.ActivityScreen.route) {
//            ActivityScreen(navController = navController)
//        }
//        composable(Screen.CreatePostScreen.route) {
//            CreatePostScreen(navController = navController)
//        }
        composable(Screen.PostDetailsScreen.route) {
            PostDetailsScreen(
                navController = navController,
                post = Post(
                    username = "subhumans24510",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "Absolutely adore Quito! Nestled amid stunning mountains, this city captivates with its rich history",
                    likeCount = 54,
                    commentCount = 14
                )
            )
        }
//        composable(Screen.ProfileScreen.route) {
//            ProfileScreen(navController = navController)
//        }
//        composable(Screen.ProfileEditScreen.route) {
//            ProfileEditScreen(navController = navController)
//        }
//        composable(Screen.SearchScreen.route) {
//            SearchScreen(navController = navController)
//        }
//        composable(Screen.PersonalListScreen.route) {
//            PersonListScreen(navController = navController)
//        }
    }
}