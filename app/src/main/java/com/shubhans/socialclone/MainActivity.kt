package com.shubhans.socialclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shubhans.socialclone.prestation.componet.StandardScaffold
import com.shubhans.socialclone.ui.theme.SocialCloneTheme
import com.shubhans.socialclone.utils.Navigation
import com.shubhans.socialclone.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val scaffoldState = rememberScaffoldState()
                    StandardScaffold(
                        navController = navController,
                        modifier = Modifier.fillMaxSize(),
                        state = scaffoldState,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.MainFeedScreen.route,
                            Screen.ChatScreen.route,
                            Screen.ProfileScreen.route,
                            Screen.ActivityScreen.route
                        )
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}



