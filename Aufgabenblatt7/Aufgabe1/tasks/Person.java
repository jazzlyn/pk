import java.util.LinkedList;

public class Person {
	//TODO Implementieren Sie hier die Klasse Person
    // set class variables
    String vorname;
    String nachname;
    String geschlecht;
    int alter;
    int sozialversicherungsnummer;
    static int level = 0;

    // initialize linked list
    LinkedList<Person> child;

    /**
     * assign constructor params to class instance
     * @param vorname
     * @param nachname
     * @param geschlecht
     * @param alter
     * @param sozialversicherungsnummer
     */
    Person(String vorname, String nachname, String geschlecht, int alter, int sozialversicherungsnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.alter = alter;
        this.sozialversicherungsnummer = sozialversicherungsnummer;
        this.child = new LinkedList();
    }

    /**
     * creates new child, checks hash code and if no match, adds child to linked list
     * @param p Person object
     */
    void neuesKind(Person p) {
        for (int i = 0; i < child.size(); i++) {
            if (this.child.get(i).equals(p)) {
                return;
            }
        }
        this.child.add(p);
    }

    /**
     * matches hashCode from all childs with child we want to add
     * @param p child, we want to add
     * @return true if match
     */
    public boolean equals(Person p) {
        return this.hashCode() == p.hashCode();
    }

    /**
     * creates hashes for vorname, nachname and sozialversicherungsnummer
     * @return the hash
     */
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 5 + vorname.hashCode();
        hash = hash * 27 + nachname.hashCode();
        hash = hash * 53 + sozialversicherungsnummer;
        return hash;
    }

    /**
     * creates complete String for print
     * @return complete output
     */
    @Override
    public String toString() {
        // top level, root element
        String s = "# " + vorname + " " + nachname + ", " + geschlecht + ", " + alter + " Jahre, Svnr: " + sozialversicherungsnummer;
        // after that helper variable +1
        level++;
        // iterate through child list,
        for (int i = 0; i < child.size(); i++) {
            Object elem = child.get(i);
            s = s + "\n";
            for (int j = 0; j < level; j++) {
                s = s + " ";
            }
            // elem.toString recursive call!!
            s = s + elem;
        }
        level--;
        return s;
    }

}
