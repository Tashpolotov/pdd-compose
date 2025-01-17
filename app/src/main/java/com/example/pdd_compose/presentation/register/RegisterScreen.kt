package com.example.pdd_compose.presentation.register

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pdd_compose.R
import com.example.pdd_compose.domain.model.register.UserModel
import com.example.pdd_compose.presentation.nav_graph.Route
import com.example.pdd_compose.util.Resource

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val registrationResult by viewModel.user.collectAsState()
    var hasNavigated by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.onboarding_backround))
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth(1f)
                .padding(top = 195.dp, start = 16.dp, end = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
            ,
            painter = painterResource(id = R.drawable.img_dialog),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Image(
            modifier = modifier
                .fillMaxWidth(1f)
                .padding(top = 14.dp, start = 100.dp, end = 100.dp)
                .align(alignment = Alignment.CenterHorizontally)
            ,
            painter = painterResource(id = R.drawable.ic_enot_tarelka),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(top = 60.dp, end = 16.dp, start = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
            ,
            text = "А как тебя зовут",
            fontSize = 12.sp,
            color = colorResource(id = R.color.color_0D0D0D),
            textAlign = TextAlign.Center,
        )

        OutlinedTextField(
            value = name.value ,
            onValueChange = { name.value = it },
            label = { Text(text = "Введите ваше имя")},
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            maxLines = 1,
            shape = RoundedCornerShape(16.dp),

            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 12.sp,
                color = colorResource(id = R.color.color_0D0D0D)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            )
        )
        Button(
            onClick = {   viewModel.sendName(UserModel(name.value))},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.color_FF9600)
            )  
        
        ) {
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = "Продолжить",
                fontSize = 16.sp,
                color = colorResource(id = R.color.color_0D0D0D),
            )
        }
        when (registrationResult) {
            is Resource.Success -> {
                if (!hasNavigated) {
                    Log.d("RegisterScreen", "Registration successful, navigating to PddNavigation")
                    navController.navigate(Route.PddNavigation.route)
                    hasNavigated = true
                }
            }
            is Resource.Error -> {
                Toast.makeText(context, "Ошибка бро", Toast.LENGTH_SHORT).show()
                hasNavigated = false // Сбрасываем флаг в случае ошибки
            }
            is Resource.Loading -> {
                Log.d("RegisterScreen", "Registration loading")
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }
            else -> {}
        }
    }

}