package be.odisee.logindemo.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.odisee.logindemo.R
import be.odisee.logindemo.model.User

enum class Screens(@StringRes val titleId: Int) {
    Login(R.string.login),
    Register(R.string.register),
    Main(R.string.app_name)
}

@Composable
fun LoginApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        Screens.valueOf(currentBackStackEntry?.destination?.route ?: Screens.Main.name)
    var currentUser: User? by remember {
        mutableStateOf(null)
    }
    Scaffold(
        topBar = {
            LoginTopAppBar(
                currentScreen = currentScreen,
                canNavigateUp = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                })
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = Screens.Login.name,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            composable(Screens.Login.name) {
                LoginView(
                    onRegisterClicked = {
                        navController.navigate(Screens.Register.name)
                    },
                    onLoginClicked = {
                        currentUser = it
                        navController.navigate(Screens.Main.name) {
                            popUpTo(Screens.Login.name) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Screens.Register.name) {
                RegisterView(
                    onRegisterClicked = {
                        navController.popBackStack(Screens.Login.name, false)
                    }
                )
            }

            composable(Screens.Main.name) {
                val currentContext = LocalContext.current
                MainView(sendMail = {
                    Log.d("LoginApp", currentUser.toString())
                    currentUser?.let { sendMail(it, currentContext) }
                })
            }
        }
    }
}

fun sendMail(currentUser: User, context: Context) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        setDataAndType(Uri.parse("mailto:"), "text/plain")

        putExtra(Intent.EXTRA_EMAIL, arrayOf(currentUser.email))
        putExtra(Intent.EXTRA_TEXT, "DIT IS EEN DEMO MAIL")
        putExtra(Intent.EXTRA_SUBJECT, "Demo in de les")
    }

    context.startActivity(Intent.createChooser(intent, context.getString(R.string.chooser_text)))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopAppBar(currentScreen: Screens, canNavigateUp: Boolean, navigateUp: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = currentScreen.titleId)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigate_back)
                    )
                }
            }
        }
    )
}
