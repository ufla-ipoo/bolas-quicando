import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo com um chão e algumas bolas que caem com efeito da gravidade.
 * 
 * @author Julio César Alves
 * @version 2023.10.20
 */
public class Mundo extends World
{

    /**
     * Constrói o mundo e chama a preparação do cenário
     * 
     */
    public Mundo()
    {    
        // Cria o mundo com 800 x 600 células de 1 pixel de tamanho
        super(800, 600, 1);
        // Inicia o cenário
        prepare();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e os adiciona ao mundo.
     */
    private void prepare()
    {
        Bola bola = new Bola(20, 50);
        addObject(bola,100,50);

        Bola bola2 = new Bola(40, 100);
        addObject(bola2,200,100);
        
        for (int i = 0; i < 10; i++) {
            Chao chao = new Chao();
            addObject(chao,100*i,540);
        }
    }
}
