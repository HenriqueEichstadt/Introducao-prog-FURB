import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/*
 * Nome: Henrique Alexsander Eichstädt
 * Data: 21/09/2018
 */
public class PreProva1 extends Furbot {

    @Override
    public void inteligencia() throws Exception {

        // Limpa console
        limparConsole();
        // Variável para pegar numeros primos
        int numNaPosicao = 0;
        // Variavel para ver qual o menor numero impar
        int menorNumImpar = 1000;
        // contador para somar todos os numeros
        int somaDeTodosOsNumeros = 0;

        // Se for o mapa onde o robô começa andando para a esquerda (MAPA 1)
        if (!ehObjetoDoMundoTipo("Parede", ESQUERDA)) {

            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

            // Andar a esquerda
            andarEsquerda();

            // Anda Enquanto não tiver parede Abaixo
            while (!ehObjetoDoMundoTipo("parede", ABAIXO)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda abaixo
                andarAbaixo();

            }
            // Anda enquanto não tiver parede a Direita
            while (!ehObjetoDoMundoTipo("parede", DIREITA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda a Direita
                andarDireita();

            }
            // Anda enquanto não tiver parede Acima
            while (!ehObjetoDoMundoTipo("parede", ACIMA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda Acima
                andarAcima();

            }
            // Anda enquanto não tiver parede a Esquerda
            while (!ehObjetoDoMundoTipo("parede", ESQUERDA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda a esquerda
                andarEsquerda();

            }
            // Anda enquanto não tiver parede Acima
            while (!ehObjetoDoMundoTipo("parede", ACIMA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda Acima
                andarAcima();

            }
            // Anda enquanto não tiver parede a direita
            while (!ehObjetoDoMundoTipo("parede", DIREITA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // Anda a direita
                andarDireita();

            }
            // Anda enquanto não tiver parede acima
            while (!ehObjetoDoMundoTipo("parede", ACIMA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // anda acima
                andarAcima();

            }
            // anda enquanto não tiver parede a esquerda
            while (!ehObjetoDoMundoTipo("parede", ESQUERDA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // anda a esquerda
                andarEsquerda();

            }
            //anda enquanto não for fim acima
            while (!ehFim(ACIMA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // anda acima
                andarAcima();

            }
            // anda enquanto não encontrar o tesouro a esquerda
            while (!ehObjetoDoMundoTipo("tesouro", ESQUERDA)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // anda a esquerda
                andarEsquerda();
            }

            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

// ----------------------------------------------------------------------------------------------
            // Se for o mapa onde o robô começa andando pra baixo (MAPA 2)
        } else if (!ehObjetoDoMundoTipo("parede", ABAIXO)) {

            // anda enquanto não encontrar a parede abaixo
            while (!ehObjetoDoMundoTipo("parede", ABAIXO)) {

                //Verifica se Tem Número na posição
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    // Pega o numero
                    numNaPosicao = numero.getValor();
                    somaDeTodosOsNumeros += numNaPosicao;
                    // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                    if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                        // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                        menorNumImpar = numNaPosicao;
                    }
                    numNaPosicao = 0;
                }
                // Se tem Alien na posição
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // se o robo tiver mais que 10 pontos
                    if (somaDeTodosOsNumeros > 10) {
                        // perde 10 pontos
                        somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                    } // se tiver menos que 10 pontos
                    else {
                        // seus pontos vão a zero
                        somaDeTodosOsNumeros = 0;
                    }
                }

                // anda para baixo
                andarAbaixo();
            }
            // anda enquanto não encontrar a parede a direita
            while (!ehObjetoDoMundoTipo("parede", DIREITA)) {
                
                            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }
                
                // anda para a direita
                andarDireita();
            }
            // anda enquanto não encontrar a parede abaixo
            while (!ehObjetoDoMundoTipo("parede", ABAIXO)) {
                
                            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

                // anda para baixo
                andarAbaixo();
            }
            //anda enquanto não for fim a Direita
            while (!ehFim(DIREITA)) {
                
                            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

                // anda para a direita
                andarDireita();
            }
            // anda enquanto não for fim abaixo
            while (!ehFim(ABAIXO)) {
                
                            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

                // anda para baixo
                andarAbaixo();
            }
            // anda enquanto não encontrar o tesouro a esquerda
            while (!ehObjetoDoMundoTipo("tesouro", ESQUERDA)) {
                
                            //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }

                // anda para a esquerda
                andarEsquerda();

            }

                        //Verifica se Tem Número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                // Pega o numero
                numNaPosicao = numero.getValor();
                somaDeTodosOsNumeros += numNaPosicao;
                // Ve se o numero é impar  e se é menor que o ultimo numero impar na posição
                if (numNaPosicao % 2 == 1 && menorNumImpar >= numNaPosicao) {

                    // Variavel menorNumImpar recebe o valor caso seja menor que o seu valor atual
                    menorNumImpar = numNaPosicao;
                }
                numNaPosicao = 0;
            }
            // Se tem Alien na posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // se o robo tiver mais que 10 pontos
                if (somaDeTodosOsNumeros > 10) {
                    // perde 10 pontos
                    somaDeTodosOsNumeros = somaDeTodosOsNumeros - 10;
                } // se tiver menos que 10 pontos
                else {
                    // seus pontos vão a zero
                    somaDeTodosOsNumeros = 0;
                }
            }
            
        }
        
        // Faz o robo falar
        diga("Encontrei o tesouro!");
        if (menorNumImpar > 0) {
            diga("(Questão A) O menor Numero ímpar no percurso foi:  " + menorNumImpar);
        } else {
            diga("Não foi encontrado nenhum número ímpar no percurso!");
        }
        if (somaDeTodosOsNumeros > 0) {
            diga("(Questão B) O robô tem  " + somaDeTodosOsNumeros + "pontos!");
        } else {
            diga("(Questão B) O robô tem 0 pontos");
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("PreProva1.xml");
    }

}
