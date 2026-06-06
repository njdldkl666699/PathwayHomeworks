package io.njdldkl.android.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.njdldkl.android.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        avatarId = R.drawable.ciallo,
                        fullName = stringResource(R.string.full_name),
                        title = stringResource(R.string.title),
                        phone = stringResource(R.string.phone),
                        contact = stringResource(R.string.contact),
                        email = stringResource(R.string.email),
                        modifier = Modifier
                            .background(colorResource(R.color.light_green))
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun BasicInfo(
    avatarId: Int,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(avatarId),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = fullName,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = title,
            color = colorResource(R.color.dimmed_green),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.2f)
        )
    }
}

@Composable
fun IconText(
    imageVector: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier.weight(0.1f)
        )
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = colorResource(R.color.dimmed_green),
        )
        Text(
            text = text,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(8.dp)
                .weight(0.7f)
        )
        Spacer(
            modifier = Modifier.weight(0.1f)
        )
    }
}

@Composable
fun SocialInfo(
    phone: String,
    contact: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        IconText(
            imageVector = Icons.Default.Phone,
            text = phone,
            modifier = modifier
        )
        IconText(
            imageVector = Icons.Default.Share,
            text = contact,
            modifier = modifier
        )
        IconText(
            imageVector = Icons.Default.Email,
            text = email,
            modifier = modifier
        )
    }
}

@Composable
fun BusinessCard(
    avatarId: Int,
    fullName: String,
    title: String,
    phone: String,
    contact: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Spacer(Modifier.weight(0.2f))
        BasicInfo(avatarId, fullName, title, Modifier.weight(0.3f))
        Spacer(Modifier.weight(0.2f))
        SocialInfo(phone, contact, email, Modifier.weight(0.15f))
    }
}

//@Preview(showBackground = true)
@Composable
fun BasicInfoPreview() {
    MyApplicationTheme {
        BasicInfo(
            avatarId = R.drawable.ciallo,
            fullName = "可乐",
            title = "南开大学软件学院",
            modifier = Modifier
                .background(colorResource(R.color.light_green))
                .fillMaxWidth()
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun SocialInfoPreview() {
    MyApplicationTheme {
        SocialInfo(
            phone = "+86 114 5141 9198",
            contact = "@njdldkl666699",
            email = "2312454@mail.nankai.edu.cn",
            modifier = Modifier
                .background(colorResource(R.color.light_green))
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SocialCardPreview() {
    MyApplicationTheme {
        BusinessCard(
            avatarId = R.drawable.ciallo,
            fullName = "可乐",
            title = "南开大学软件学院",
            phone = "+86 114 5141 9198",
            contact = "@njdldkl666699",
            email = "2312454@mail.nankai.edu.cn",
            modifier = Modifier
                .background(colorResource(R.color.light_green))
                .fillMaxSize()
        )
    }
}