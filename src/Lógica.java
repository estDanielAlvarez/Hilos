import javax.swing.JLabel;

public class Lógica extends Thread {
    private JLabel auto;
    private Carrera pos;
    private long tiempoInicio;

    public Lógica(JLabel auto, Carrera pos) {
        this.auto = auto;
        this.pos = pos;
    }

    @Override
    public void run() {
        tiempoInicio = System.currentTimeMillis();
        while (true) {
            try {
                sleep((int) (Math.random() * 1000));
                int autoPosX = auto.getLocation().x;
                int metaPosX = pos.getmeta().getLocation().x - 10;

                if (autoPosX < metaPosX) {
                    auto.setLocation(autoPosX + 25, auto.getLocation().y);
                    pos.repaint();
                } else {
                    long tiempoTotalMs = System.currentTimeMillis() - tiempoInicio;
                    double tiempoTotalSegundos = tiempoTotalMs / 1000.0;
                    pos.registrarTiempo(auto.getText(), (long) tiempoTotalSegundos);
                    break;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}