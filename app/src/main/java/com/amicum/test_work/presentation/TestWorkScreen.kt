package com.amicum.test_work.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amicum.R
import com.amicum.utils.Arg
import com.amicum.utils.TopBarOther

@Composable
fun TestWorkScreen(navController: NavHostController) {

    val viewModel: TestWorkViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            TopBarOther(header = stringResource(R.string.sComment),
                imageOther = Icons.Default.Done,
                onBack = {
                    navController.popBackStack()
                },
                onOther = {
                    navController.previousBackStackEntry?.arguments?.putString(
                        Arg.comment,
                        viewModel.comment.value
                    )
                    navController.popBackStack()
                })
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            val edMod = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .border(1.dp, MaterialTheme.colors.onBackground, shape = RoundedCornerShape(5.dp))

            TextField(
                value = viewModel.comment.value,
                onValueChange = {
                    viewModel.comment.value = it
                },
                modifier = edMod,
                singleLine = false,
                placeholder = { Text("Введите комментарий") },
            )
        }
    }
}

data class Com(
    val comment: String? = null
)