package com.bhargav.checkit.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bhargav.checkit.R
import com.bhargav.checkit.Routes
import com.bhargav.checkit.model.People
import com.bhargav.checkit.ui.components.TaskCard
import com.bhargav.checkit.ui.theme.DarkBlue
import com.bhargav.checkit.ui.theme.TealBlue
import com.bhargav.checkit.ui.theme.Yellow

const val yashu =
    "https://instagram.fbom8-1.fna.fbcdn.net/v/t51.2885-19/323119505_2221353338073676_678820546848859758_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fbom8-1.fna.fbcdn.net&_nc_cat=104&_nc_ohc=bOpV3CjDfHsAX_iKtTz&edm=ANmP7GQBAAAA&ccb=7-5&oh=00_AfDl7qJ6slRci5tQejd1wTdhmcheWZsjVj91AU_0XxSBjw&oe=63BE869B&_nc_sid=276363"
const val bhargav =
    "https://instagram.fbom8-1.fna.fbcdn.net/v/t51.2885-19/312730275_1339425076870041_7707449270030096507_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fbom8-1.fna.fbcdn.net&_nc_cat=109&_nc_ohc=0YCCNptRC64AX8crx7K&edm=ACWDqb8BAAAA&ccb=7-5&oh=00_AfBR9vo3SViYlEX2zxtal_UJFX6uYXmK1Gm5BOiatNiyOg&oe=63BEE49C&_nc_sid=1527a3"


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue)
            .padding(24.dp)
    ) {
        Header(navController = navController, image = bhargav)

        Spacer(modifier = Modifier.height(24.dp))

        Greeting()

        Spacer(modifier = Modifier.height(24.dp))

        Stats(navController = navController)

        Cards(navController = navController)
    }
}

@Composable
fun Cards(navController: NavController) {
    Spacer(modifier = Modifier.height(16.dp))
    TaskCard(
        color = Yellow,
        title = "Today",
        subtitle = "3 active tasks",
        people = listOf(
            People(
                name = "Yashashwini",
                image = yashu
            ),
        ),
        onClick = { navController.navigate(Routes.View.route) }
    )
    Spacer(modifier = Modifier.height(16.dp))
    TaskCard(
        color = TealBlue,
        title = "Shopping List",
        subtitle = "16 active tasks",
        people = listOf(
            People(name = "Bhargav", image = bhargav),
            People(
                name = "Yashashwini",
                image = yashu
            ),
        ),
        onClick = { navController.navigate(Routes.View.route) }
    )
}


@Composable
fun Header(navController: NavController, image: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(shape = CircleShape)
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_baseline_person_24),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.White.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center,
                content = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "add",
                        tint = Color.White
                    )
                }
            )

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.White.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center,
                content = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "notifications",
                        tint = Color.White
                    )
                }
            )
        }
    }
}

@Composable
fun Greeting() = Text(
    text = "Good Morning,\nBhargav.",
    style = MaterialTheme.typography.h4,
    color = Color.White
)

@Composable
fun Stats(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = "Today's Monday", color = Color.White)
            Text(text = "Jan 6th, 2023", color = Color.Gray)
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = "75% done", color = Color.White)
            Text(text = "Completed tasks", color = Color.Gray)
        }
    }
}
