import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.telaum.telas.Cadastrado
import br.com.fiap.telaum.telas.Cadastro
import br.com.fiap.telaum.telas.Login
import br.com.fiap.telaum.ui.theme.TelaUmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaUmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // guardar o historico de navegação
                    val navController = rememberNavController()
                    // startDestination -> tela inicial
                    NavHost(navController = navController, startDestination = "Login"){
                        composable(route = "Login"){
                            Login(navController)
                        }
                        composable(route = "Cadastro"){
                            Cadastro()
                        }
                        composable(route = "Cadastrado"){
                            Cadastrado(navController)
                        }
                    }
                }
            }
        }
    }
}