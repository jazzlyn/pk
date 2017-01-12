// TODO: Implementieren Sie hier ein Archiv.
import java.util.LinkedList;

public class ArchivImpl implements Archiv {
    LinkedList<Meerestier> archiv = new LinkedList<Meerestier>();

    @Override
    public void registrieren(Meerestier m) {
        archiv.add(m);
    }

    @Override
    public void ausraeumen() {
        for (int i = 0; i < archiv.size(); i++) {
            archiv.get(i).ausraeumen();
        }
    }

    @Override
    public void einordnen() {
        int regal = 1;
        for (int i = 0; i < archiv.size(); i++) {
            archiv.get(i).einordnen(regal);
            regal++;
        }
    }

    @Override
    public void neuWiegen(int[] gewicht) {
        for (int i = 0; i < archiv.size(); i++) {
            archiv.get(i).abwiegen(gewicht[i]);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < archiv.size(); i++) {
            s += archiv.get(i) + "\n";
        }
        return s;
    }
}

