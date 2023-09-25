package br.com.fiap.telaum.telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.telaum.R
import br.com.fiap.telaum.ui.theme.TelaUmTheme
import br.com.fiap.telaum.ui.theme.font_titulo


@Composable
fun Login(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    var cpf by remember {
        mutableStateOf("")
    }
    var lembrar by remember {
        mutableStateOf(false)
    }
    val tamanho = 0.8f
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            // ---- header ---------
            Column(
                // deixar a imagem sempre no centro
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFF022003))
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                // vamos adicionar uma imagem
                Text(
                    text = "Recyapp",
                    fontSize = 20.sp,
                    color = Color(0xFFFFFFFF),
                    fontFamily = font_titulo

                )
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    painter = painterResource(R.drawable.imagem_findo),
                    contentDescription = "moça",
                    // vamos deixar a imagem menor
                    modifier = Modifier
                        //mudando formato da imagem
                        .clip(shape = RoundedCornerShape(10.dp))
                        .size(100.dp),
                    // vamos mexer na escala da imagem
                    // nossa imagem tava com bordas em cima, com esse fillHeight ele
                    // corta a imagem para ocupar o espaço
                    // agora o fillBounds estica a imagem
                    // Crop da um "zoom" ate caber no espaco
                    contentScale = ContentScale.Crop

                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-30).dp)
                        .fillMaxWidth()
                        .height(350.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xfff9f6f6)),
                    // para dar uma elevada no card, deixar uma sombra
                    elevation = CardDefaults.cardElevation(4.dp),
                    border = BorderStroke(width = 2.dp, Color(0xFF022003))
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0x4FAFF0B2))
                            .padding(32.dp)
                    ) {
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            modifier = Modifier.fillMaxWidth(),
                            // para ficar tudo na mesma linha, nao expandir
                            singleLine = true,
                            label = {
                                Text(text = "Digite seu email")
                            },
                            placeholder = {
                                Text(text = "Digite seu email")
                            },
                            shape = RoundedCornerShape(25.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF009688),
                                unfocusedBorderColor = Color.Black,
                            ),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.email_24),
                                    contentDescription = "icone email"
                                )
                            },

                            textStyle = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        OutlinedTextField(
                            value = senha,
                            onValueChange = { senha = it },
                            modifier = Modifier.fillMaxWidth(),
                            // para ficar tudo na mesma linha, nao expandir
                            singleLine = true,
                            label = {
                                Text(text = "Digite sua senha")
                            },
                            placeholder = {
                                Text(text = "Digite sua senha")
                            },
                            shape = RoundedCornerShape(32.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF009688),
                                unfocusedBorderColor = Color.Black
                            ),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.lock_24),
                                    contentDescription = "icone cadeado"
                                )
                            }
                        )
                        val scaleMultiplier = 0.6f
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            // checked -> ela esta marcada ou nao?
                            Checkbox(
                                checked = lembrar,
                                onCheckedChange = {
                                    lembrar = it
                                },
                                modifier = Modifier.scale(scaleMultiplier)
                            )
                            Text(text = "Lembrar-me", fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.height(38.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = { navController.navigate("Cadastrado") },
                                border = BorderStroke(4.dp, Color(0xFF000000)),
                                shape = CircleShape,
                                modifier = Modifier.size(width = 140.dp, height = 55.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor =
                                    Color(0xFF022003),
                                    contentColor = Color(0xFFFFFFFF)
                                ),
                            ) {
                                Row(
                                    //fazendo a row ter o tamanho do botao
                                    modifier = Modifier.fillMaxWidth(),
                                    // evenly deixa os espacamentos igualmente
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Text(text = "Entrar")
                                    // Colocando uma imagem (icone)
                                    // Icon(imageVector = Icons.Default.Done, contentDescription = "")

                                }


                            }
                            Spacer(
                                modifier = Modifier
                                    .height(38.dp)
                                    .width(5.dp)
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(
                                    onClick = { navController.navigate("Cadastro") },
                                    border = BorderStroke(4.dp, Color(0xFF000000)),
                                    shape = CircleShape,
                                    modifier = Modifier.size(width = 150.dp, height = 55.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor =
                                        Color(0xFF022003),
                                        contentColor = Color(0xFFFFFFFF)
                                    )
                                ) {
                                    Row(
                                        //fazendo a row ter o tamanho do botao
                                        modifier = Modifier.fillMaxWidth(),
                                        // evenly deixa os espacamentos igualmente
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        Text(text = "Cadastrar-se")
                                        // Colocando uma imagem (icone)
                                        // Icon(imageVector = Icons.Default.Done, contentDescription = "")

                                    }


                                }

                            }
                        }
                    }
                }

            }


        }
    }
}

