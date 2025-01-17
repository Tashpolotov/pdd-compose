package com.example.pdd_compose.presentation.navigator.component

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdd_compose.R
import com.example.pdd_compose.ui.theme.PddcomposeTheme

@Composable
fun NewsBottomNavigation(
    items:List<BottomNavigationItem>,
    selected:Int,
    onItemClick:(Int)->Unit
) {
    NavigationBar(
    modifier = Modifier
        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        .fillMaxWidth(),
    containerColor =  Color.White,
    tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, bottomNavigationItem ->
            Log.d("RegisterScreen", "Item $index: ${bottomNavigationItem.text}, selected: ${index == selected}")
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = bottomNavigationItem.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = bottomNavigationItem.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.color_1CA1BF),
                    selectedTextColor = colorResource(id = R.color.color_1CA1BF),
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor =  Color.White
                )
            )

        }
    }

}

data class BottomNavigationItem(
    @DrawableRes val icon:Int,
    val text:String
)

@Preview(showBackground = true)

@Composable
fun BottomNavigationPreview(){
    PddcomposeTheme {
        NewsBottomNavigation(
            items = listOf(
                BottomNavigationItem(icon = R.drawable.ic_home, "Home"),
                BottomNavigationItem(icon = R.drawable.ic_video, "Video"),
                BottomNavigationItem(icon = R.drawable.ic_rating, "Rating"),
                BottomNavigationItem(icon = R.drawable.ic_profile, "Profile")
            ),
            selected = 0,
            onItemClick ={}
        )
    }
}
