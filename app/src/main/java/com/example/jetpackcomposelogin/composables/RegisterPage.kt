package com.example.jetpackcomposelogin.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposelogin.R
import com.example.jetpackcomposelogin.ui.theme.primaryColor
import com.example.jetpackcomposelogin.ui.theme.whiteBackground

@Composable
fun RegisterPage(navController: NavController) {
    val image = painterResource(id = R.drawable.login_image)
    val passwordVector = painterResource(id = R.drawable.password_eye)
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            contentAlignment = Alignment.TopCenter) {

            Image(painter = image, contentDescription = "Login main image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.8f)

            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(whiteBackground)
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(text = "Phone") },
                    placeholder = { Text(text = "Enter the phone number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)

                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = passwordVector, contentDescription = "Password icon",
                                tint = if (passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Enter the password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)

                )
                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = { confirmPasswordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {
                            Icon(
                                painter = passwordVector, contentDescription = "Password icon",
                                tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Confirm password") },
                    placeholder = { Text(text = "Confirm the password") },
                    singleLine = true,
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)

                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)){
                    Text(text = "Sign Up", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Login instead",fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.LoginPage.route){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }))
                Spacer(modifier = Modifier.padding(10.dp))

            }
        }
    }
}