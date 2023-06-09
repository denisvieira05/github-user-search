package com.denisvieira05.githubusersearch.ui.modules.homescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.denisvieira05.githubusersearch.ui.components.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSuggestedItem(
    userName: String,
    avatarUrl: String?,
    onPress: () -> Unit
) {
    ElevatedCard(
        onClick = { onPress() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageUrl = avatarUrl,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape),
                contentDescription = "User Profile Image",
                loadingSize = 90.dp
            )

            Spacer(modifier = Modifier.height(18.dp))
            Text(
                "@$userName",
                fontWeight = FontWeight.SemiBold,
            )
        }
    }

}