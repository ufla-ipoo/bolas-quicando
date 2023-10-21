import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa uma bola que cai acelerando com o tempo devido ao efeito da gravidade
 * e quica no chão voltando para o alto com a velocidade amortecida.
 * 
 * Esse código é inspirado no exemplo bouncing-balls do livro de Barnes e Kolling.
 * 
 * @author Julio César Alves
 * @version 2023.10.20
 */
public class Bola extends Actor
{
    // simula o efeito da gravidade
    private static final double GRAVIDADE = 0.7;
    // velocidade inicial que a bola cai
    private double velocidadeVertical = 1;
    // posição Y da bola usando double para aumentar a precisão
    private double posY;
    // amortecimento, quando a bola quica a velocidade que ela
    // volta é amenizada pelo amortecimento
    private int amortecimento = 2;
    
    /*
     * Cria uma bola com o diâmetro e a posição Y passados
     * 
     * Obs.: a bola precisa ser posicionada com o m´étodo setLocation na
     * mesma posição Y informada aqui.
     */
    public Bola(int diametro, int posY) {
        // guarda a posição Y da bola como double
        this.posY = posY;
        // muda o tamanho da imagem de acordo com o diâmetro passado
        getImage().scale(diametro, diametro);
        // define que a direção da bola é para baixo (270 graus)
        setRotation(270);    
    }
    
    /**
     * Act - do whatever the Bola wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {    
        // se a bola ainda está em movimento
        if (velocidadeVertical != 0) {
            // para simular a gravidade, fazemos a velocidade aumentar de acordo com a gravidade
            velocidadeVertical += GRAVIDADE;
            // e aplicamos a velocidade na posição vertical da bola
            posY += velocidadeVertical;            
            // atualizamos então a posição da bola com a nova posição Y
            // e aumentando dois na posição X (faz a bola ir para a direita)
            setLocation(getX()+2, (int)posY);
            
            // se a bola tocou o chão e estava caindo (velocidade positiva)
            if (isTouching(Chao.class) && velocidadeVertical > 0) {
                // ela quica, ou seja, sua velocidade se torna negativa (faz a bola subir)                
                velocidadeVertical = -velocidadeVertical + amortecimento;
            
                // se a velocidade de subida é muito baixa, faz a bola parar
                // (sem isso a bola ficaria quicando sem parar)
                if (velocidadeVertical > -1) {
                    velocidadeVertical = 0;
                }
            }
        }
    }
}
