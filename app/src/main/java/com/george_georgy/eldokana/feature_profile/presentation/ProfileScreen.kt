package com.george_georgy.eldokana.feature_profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthButton
import com.george_georgy.eldokana.feature_profile.presentation.components.ProfileListItem
import com.george_georgy.eldokana.feature_profile.presentation.components.ProfilePictureItem
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = getViewModel(),
    onBackArrowIcon : ()->Unit
) {

    val state = profileViewModel.profileState.value

    Scaffold(

        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFe7e7e7),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        onClick = {
                              onBackArrowIcon()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "My Profile",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,

                        )
                },
                actions = {
                    IconButton(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFe7e7e7), shape = RoundedCornerShape(15.dp)
                            ),
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                        )
                    }
                }

            )
        }) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                LazyColumn() {

                    item {

                        ProfilePictureItem(
                            painterResource(id = R.drawable.profile),
                            name = "${state.name?.firstname} ${state.name?.lastname}",
                            state.email
                        )

                    }
                    item {
                        ProfileListItem("My Orders", "Already have 12 orders")
                    }
                    item {
                        ProfileListItem("Shipping addresses", "3 addresses")
                    }
                    item {
                        ProfileListItem("Promocodes", "You have special promocodes")
                    }
                    item {
                        ProfileListItem("My reviews", "Reviews for 4 items")
                    }
                    item {
                        ProfileListItem("Settings", "Notification, password")
                    }
                }


                Spacer(modifier = Modifier.weight(1f))


                AuthButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = "Logout",
                    contentColor = Color.White,
                ) {

                }


            }
        }
    }
}

