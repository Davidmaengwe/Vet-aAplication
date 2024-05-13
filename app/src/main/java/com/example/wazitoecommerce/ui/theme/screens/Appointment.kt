package com.example.wazitoecommerce.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppointmentCard(
    onReportSubmit: (String, String, String, String, String, String, String) -> Unit
) {
    var appointmentDate by remember { mutableStateOf("") }
    var appointmentTime by remember { mutableStateOf("") }
    var veterinarianName by remember { mutableStateOf("") }
    var petName by remember { mutableStateOf("") }
    var appointmentReason by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var confirmationNumber by remember { mutableStateOf("") }

        val context = LocalContext.current
        val focusManager = LocalFocusManager.current
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Appointment Details",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = appointmentDate,
                onValueChange = { appointmentDate = it },
                label = { Text("Date") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = appointmentTime,
                onValueChange = { appointmentTime = it },
                label = { Text("Time") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = veterinarianName,
                onValueChange = { veterinarianName = it },
                label = { Text("Veterinarian Name") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = petName,
                onValueChange = { petName = it },
                label = { Text("Pet Name") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = appointmentReason,
                onValueChange = { appointmentReason = it },
                label = { Text("Appointment Reason") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )

            TextField(
                value = confirmationNumber,
                onValueChange = { confirmationNumber = it },
                label = { Text("Confirmation Number") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
            )

        Button(
            onClick = {
                onReportSubmit(
                    appointmentDate,
                    appointmentTime,
                    veterinarianName,
                    petName,
                    appointmentReason,
                    location,
                    confirmationNumber
                )
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Submit Report")
        }
    }
}

@Composable
fun AppointmentScreen() {
    Surface(color = Color.White) {
        AppointmentCard { appointmentDate, appointmentTime, veterinarianName, petName, appointmentReason, location, confirmationNumber ->
            // Handle report submission
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Appointment Booking App",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        AppointmentScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
