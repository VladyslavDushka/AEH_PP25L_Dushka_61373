package pl.pp;
    public class Magazyn {
        private int numerMagazynu;
        private int dostepnaPrzestrzen;
        private String wlasciciel;
        private String email;
        private String numerTelefonu;

        public Magazyn(int numerMagazynu, int dostepnaPrzestrzen, String wlasciciel, String email, String numerTelefonu) {
            this.numerMagazynu = numerMagazynu;
            this.dostepnaPrzestrzen = dostepnaPrzestrzen;
            this.wlasciciel = wlasciciel;
            this.email = email;
            this.numerTelefonu = numerTelefonu;
        }

        public int getNumerMagazynu() { return numerMagazynu; }
        public void setNumerMagazynu(int numerMagazynu) { this.numerMagazynu = numerMagazynu; }

        public int getDostepnaPrzestrzen() { return dostepnaPrzestrzen; }
        public void setDostepnaPrzestrzen(int dostepnaPrzestrzen) { this.dostepnaPrzestrzen = dostepnaPrzestrzen; }

        public String getWlasciciel() { return wlasciciel; }
        public void setWlasciciel(String wlasciciel) { this.wlasciciel = wlasciciel; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getNumerTelefonu() { return numerTelefonu; }
        public void setNumerTelefonu(String numerTelefonu) { this.numerTelefonu = numerTelefonu; }

        public void dodajTowar(int ilosc) {
            if (ilosc <= dostepnaPrzestrzen) {
                dostepnaPrzestrzen -= ilosc;
                System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
            } else {
                System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
            }
        }

        public void usunTowar(int ilosc) {
            int zajete = 5000 - dostepnaPrzestrzen;
            if (ilosc <= zajete) {
                dostepnaPrzestrzen += ilosc;
                System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
            } else {
                System.out.println("Nie można usunąć więcej towaru niż aktualnie znajduje się w magazynie.");
            }
        }

        public void sprawdzZajetosc() {
            int zajete = 5000 - dostepnaPrzestrzen;
            System.out.println("Zajęta przestrzeń magazynowa: " + zajete + " jednostek.");
            System.out.println("Dostępna przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        }

        public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
            this.email = nowyEmail;
            this.numerTelefonu = nowyTelefon;
            System.out.println("Zaktualizowano dane kontaktowe właściciela.");
            System.out.println("Nowy email: " + email);
            System.out.println("Nowy numer telefonu: " + numerTelefonu);
        }

        public static void main(String[] args) {
            Magazyn m = new Magazyn(1, 5000, "Krzysztof Piatek", "Krzys@gmail.com", "123456789");

            m.dodajTowar(3000);
            m.usunTowar(1000);
            m.dodajTowar(2500);
            m.sprawdzZajetosc();
            m.aktualizujKontakt("owner@magazyn.pl", "+48 123 456 789");
            m.dodajTowar(1000);
        }
    }

