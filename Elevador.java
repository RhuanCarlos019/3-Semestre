import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Elevador extends JFrame {
    private JButton[] botoesChamar;
    private JButton[] botoesAndar;
    private JTextArea display;

    private int[] posicaoElevadores;
    private int[] direcaoElevadores;

    public Elevador() {
        super("Sistema de Elevadores");

        // Inicializando variáveis
        botoesChamar = new JButton[2];
        botoesAndar = new JButton[6];
        display = new JTextArea();
        posicaoElevadores = new int[]{0, 0}; // Posição inicial dos elevadores (Térreo)
        direcaoElevadores = new int[]{0, 0}; // 0 para parado, 1 para subindo, -1 para descendo

        // Configurando a interface gráfica
        JPanel panel = new JPanel(new GridLayout(6, 2));

        for (int i = 0; i < 6; i++) {
            final int andar = i;
            botoesAndar[i] = new JButton(String.valueOf(i));
            botoesAndar[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int andarSolicitado = Integer.parseInt(((JButton) e.getSource()).getText());
                    moverElevador(0, andarSolicitado);
                }
            });
            panel.add(botoesAndar[i]);

            botoesChamar[i % 2] = new JButton("Chamar");
            botoesChamar[i % 2].setBackground(Color.GREEN);
            botoesChamar[i % 2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int elevadorMaisProximo = obterElevadorMaisProximo(andar);
                    moverElevador(elevadorMaisProximo, andar);
                }
            });
            panel.add(botoesChamar[i % 2]);
        }

        display.setEditable(false);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(display), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    // Retorna o índice do elevador mais próximo do andar especificado
    private int obterElevadorMaisProximo(int andar) {
        int elevadorMaisProximo = 0;
        int distanciaMinima = Math.abs(posicaoElevadores[0] - andar);
        for (int i = 1; i < posicaoElevadores.length; i++) {
            int distancia = Math.abs(posicaoElevadores[i] - andar);
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                elevadorMaisProximo = i;
            }
        }
        return elevadorMaisProximo;
    }

    // Move o elevador para o andar especificado
    private void moverElevador(final int indiceElevador, final int andar) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int andarAtual = posicaoElevadores[indiceElevador];
                int andarDestino = andar;
                direcaoElevadores[indiceElevador] = andarAtual < andarDestino ? 1 : -1;

                display.append("Elevador " + (indiceElevador + 1) + " está se movendo...\n");
                while (andarAtual != andarDestino) {
                    try {
                        Thread.sleep(2000); // Delay de 2 segundos por andar
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    andarAtual += direcaoElevadores[indiceElevador];
                    posicaoElevadores[indiceElevador] = andarAtual;
                    display.setText("Elevador " + (indiceElevador + 1) + " chegou ao " + (andarAtual >= 0 ? "andar " + andarAtual : "subsolo") + "\n");
                }
                display.append("Bem-vindo! Por favor, entre no Elevador " + (indiceElevador + 1) + "\n");
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Elevador();
            }
        });
    }
}
