
import java.util.ArrayList;
import java.util.LinkedList;

class Graph {

    private int V;   // No. of vertices
    private LinkedList<Person> adj[]; //Adjacency Lists
    boolean c = true;
    int current = 0;
    ArrayList<Person> basvurular = new ArrayList<>(); // basvurular
    Queue kuyruk2 = new Queue();
    ArrayList<Person> alıcılar = new ArrayList<>();

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(Person w) {
     
        if (!basvurular.isEmpty()) {
            for (int i = 0; i < basvurular.size(); i++) {

                if (basvurular.get(i).tc.equalsIgnoreCase(w.tc)) {
                    System.out.println("Bu TC ile aynı kayıt mevcut.Bir kişiyi 2 kere ekleyemezsiniz .");
                    c = false;
                    return;

                }

            }
        }
         c=true;
        if (w.bagisciMi) {
            this.current++;
            adj[this.current].add(w);
        }
        if (w.aliciMi) {

            for (int i = 0; i < this.V; i++) {
                if (!adj[i].isEmpty()) {
                    if (adj[i].get(0).isMatch(w)) {
                        if (adj[i].get(0).tc.equalsIgnoreCase(w.tc)) {
                            continue;
                        }

                        adj[i].add(w);
                        // return;

                    }
                }

            }

            basvurular.add(w);
            if (!w.bagisciMi) {
                kuyruk2.insert(w); // alıcı kuyruğu
            }

            for (int i = 0; i < this.V; i++) {
                for (int j = 0; j < basvurular.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (!adj[i].isEmpty()) {
                        if (adj[i].get(0).isMatch(basvurular.get(j))) {
                            if (!adj[i].get(0).tc.equalsIgnoreCase(basvurular.get(j).tc)) {
                                if (!this.isThere(basvurular.get(j), i)) {
                                    adj[i].add(basvurular.get(j));

                                }

                            }

                        }
                    }

                }

            }

        }
        System.out.println("Kaydınız başarıyla oluşturulmuştur ...");
    }

    public boolean isThere(Person p, int x) {

        for (int j = 0; j < adj[x].size(); j++) {
            if (adj[x].get(j) == p) {
                return true;

            }

        }
        return false;

    }

    public boolean there(String p) {

        for (int j = 0; j < this.V; j++) {
            for (int t = 0; t < adj[j].size(); t++) {
                if (adj[j].get(t).tc.equalsIgnoreCase(p)) {
                    return true;

                }
            }

        }
        return false;

    }

    public boolean isBasvuran(String tc) {
        for (int i = 0; i < this.basvurular.size(); i++) {
            if (this.basvurular.get(i).tc.equals(tc)) {
                return true;
            }
        }
        return false;

    }

    public void printGraph() {

        for (int i = 0; i < this.V; i++) {
            if (!adj[i].isEmpty()) {
                System.out.println(adj[i]);
            }

        }

    }

    public void printQueue() {

        if (!kuyruk2.isEmpty()) {
            System.out.print("Kana ihtiyaç duyanların Kuyruğu : ");
            int s = kuyruk2.index ;
            for (int i = 0; i < s; i++) {
                alıcılar.add(kuyruk2.delete());
                System.out.println(alıcılar.get(i));
            }
            for (int i = 0; i < alıcılar.size(); i++) {
                kuyruk2.insert(alıcılar.get(i));
            }
        } else {
            System.out.println("Kan'a ihtiyaç duyan kimse bulunmadığı için  Kan alıcı kuyruğu boştur.");
        }

    }

    public Person getPerson(String tc) {
        // gelen tc li elemanı döndür.
        for (int j = 0; j < this.V; j++) {
            for (int t = 0; t < adj[j].size(); t++) {
                if (adj[j].get(t).tc.equalsIgnoreCase(tc)) {
                    return adj[j].get(t); // bulursa döndürür

                }
            }

        }
        return null; // bulmazsa null döndürür

    }

    public Person getP(String tc) {
        for (int i = 0; i < basvurular.size(); i++) {
            if (basvurular.get(i).tc.equalsIgnoreCase(tc)) {
                return basvurular.get(i);
            }
        }
        return null;
    }

}
