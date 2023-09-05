package com.example.dedalus_ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dedalus_ui.R
import com.example.dedalus_ui.components.*
import com.example.dedalus_ui.components.data.DoctorScreenViewModel
import com.example.dedalus_ui.components.data.SignUp.SignUpViewModel
import kotlinx.coroutines.launch

@Composable
fun DoctorSelectionScreen(doctorViewModel: DoctorScreenViewModel = viewModel()){   // creating a reference of loginView model

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolBar(toolbarTitle = stringResource(R.string.home),
                logoutButtonClicked = {
                    doctorViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
                )
        },

        drawerContent = {
            NavigationDrawerHeader()
            NavigationDrawerBody(navigationDrawerItems = doctorViewModel.navigationItemsList,
            onNavigationItemClicked = {
                Log.d("ComingHere", "Inside_onNavigationItemClicked")
                Log.d("ComingHere", "${it.itemId} = ${it.title}")
            })

        }
    )
    {paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, top = 16.dp, end = 16.dp )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

//                HeadingTextForScreensComponent(value = "Enter the basic Details:")

                val category = listOf("Pain", "Infected")
                val affected_part = listOf("Knee Pain", "Back Pain", "Shoulder Pain", "Stomach Pain")
                doctorScreenDropDownAppMenu(parentList = category)
                

            }

        }
        
    }

}