package com.example.wazitoecommerce.ui.theme.screens.appointment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Paragliding
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Paragliding
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.theme.BlueStart
import com.example.wazitoecommerce.ui.theme.DeepBlue
import com.example.wazitoecommerce.ui.theme.LightGreen1
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.home.BottomNavItem


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppointmentScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var selected by rememberSaveable  { mutableIntStateOf(1) }
        Scaffold(
            bottomBar = {
                NavigationBar (
                    containerColor = Color.Transparent
                ){
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                                {

                                }
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title,
                                        tint = BlueStart)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },



            //Content Section
            content = @Composable{




                // Define a data class to hold appointment details
                        data class AppointmentDetails(
                val date: String,
                val time: String,
                val veterinarianName: String,
                val petName: String,
                val appointmentReason: String,
                val location: String,
                val confirmationNumber: String,
                var status: AppointmentStatus
            )



                @Composable
                fun AppointmentDetailsForm(onSubmit: (AppointmentDetails) -> Unit) {
                    var date by remember { mutableStateOf("") }
                    var time by remember { mutableStateOf("") }
                    var veterinarianName by remember { mutableStateOf("") }
                    var petName by remember { mutableStateOf("") }
                    var appointmentReason by remember { mutableStateOf("") }
                    var location by remember { mutableStateOf("") }
                    var doctorName by remember { mutableStateOf("") }


                    val focusManager = LocalFocusManager.current

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = "Appointment Details",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        TextField(
                            value = date,
                            onValueChange = { date = it },
                            label = { Text("Date") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = time,
                            onValueChange = { time = it },
                            label = { Text("Time") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = veterinarianName,
                            onValueChange = { veterinarianName = it },
                            label = { Text("Veterinarian Name") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = petName,
                            onValueChange = { petName = it },
                            label = { Text("Pet Name") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = appointmentReason,
                            onValueChange = { appointmentReason = it },
                            label = { Text("Appointment Reason") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = location,
                            onValueChange = { location = it },
                            label = { Text("Location") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                                FocusDirection.Down) })
                        )

                        TextField(
                            value = doctorName,
                            onValueChange = { doctorName = it },
                            label = { Text("Doctor Name") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
                        )

                        Button(
                            onClick = {
                                // Create AppointmentDetails object and pass it to the onSubmit callback
                                onSubmit(
                                    AppointmentDetails(
                                        date = date,
                                        time = time,
                                        veterinarianName = veterinarianName,
                                        petName = petName,
                                        appointmentReason = appointmentReason,
                                        location = location,
                                        confirmationNumber = doctorName,
                                        status = AppointmentStatus.SCHEDULED
                                    )
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(BlueStart)
                        ) {
                            Text("Submit")
                        }
                    }
                }

                @Composable
                fun Receipt(appointmentDetails: AppointmentDetails) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                            Card (
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp),
                                colors = CardDefaults.cardColors(
                                    Color.Gray
                                ), modifier = Modifier .size(width = 370.dp, height = 190.dp)
                        ){


                            Text(
                                text = "Appointment Receipt",
                                style = MaterialTheme.typography.headlineLarge,
                                color = Color.Black,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(bottom = 8.dp, start = 20.dp)
                            )

                            Text(
                                "Date: ${appointmentDetails.date}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "Time: ${appointmentDetails.time}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "Veterinarian: ${appointmentDetails.veterinarianName}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "Pet: ${appointmentDetails.petName}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "Reason: ${appointmentDetails.appointmentReason}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "Location: ${appointmentDetails.location}",
                                modifier = Modifier.padding(bottom = 4.dp, start = 10.dp)
                            )
                            Text(
                                "DoctorName: ${appointmentDetails.confirmationNumber}",
                                modifier = Modifier.padding(bottom = 8.dp, start = 10.dp)
                            )

                        }


                        Text("Appointment status: ${appointmentDetails.status}",
                            modifier = Modifier.padding(bottom = 8.dp, start = 40.dp),
                            color = LightGreen1)
                    }
                }

                var appointmentDetails by remember { mutableStateOf<AppointmentDetails?>(null) }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp, bottom = 10.dp, start = 16.dp, end = 16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Appointment Form",
                            style = MaterialTheme.typography.headlineMedium,
                            color = BlueStart,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        // Display UserDetailsForm if appointmentDetails is null
                        if (appointmentDetails == null) {
                            AppointmentDetailsForm { appointmentDetails = it }
                        } else {
                            // Display Receipt if appointmentDetails is not null
                            Receipt(appointmentDetails!!)
                        }
                    }




            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route= "home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),


    BottomNavItem(
        title = "Appointment",
        route = "appointment",
        selectedIcon = Icons.Filled.Receipt,
        unselectedIcon = Icons.Outlined.Receipt,
        hasNews = true,
        badges = 5
    ),

    BottomNavItem(
        title = "My Pet",
        route = "medical",
        selectedIcon = Icons.Filled.Paragliding,
        unselectedIcon = Icons.Outlined.Paragliding,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Vets",
        route = "vet",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = false,
        badges = 0
    ),


    )


data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)








@Preview(showBackground = true)
@Composable
fun AppointmentScreenPreview() {
    WazitoECommerceTheme {
        AppointmentScreen( navController = rememberNavController())
    }
}

