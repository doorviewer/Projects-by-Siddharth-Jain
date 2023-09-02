import java.util.ArrayList;

public class Kitab {
    public int ID;
    public String name;
    public String author;

    public Kitab() {
    }

    public Kitab(int ID) {
        this.ID = ID;
    }

    public Kitab(int ID, String name, String author) {
        this.ID = ID;
        this.name = name;
        this.author = author;
    }

    public ArrayList<Kitab> fillKitab(){
        ArrayList<Kitab> ktb = new ArrayList<>();
        ktb.add(new Kitab(1, "C++", "vipin"));
        ktb.add(new Kitab(3, "sida", "sid"));
        ktb.add(new Kitab(4, "sid", "sid"));
        ktb.add(new Kitab(5, "sid", "sid"));

        return ktb;
    }

    public void listKitab(ArrayList<Kitab> ktb){
        System.out.println("------------------------------------------------------");
        System.out.println("ID" + "     " + "NAME" + "     " + "AUTHOR");
        System.out.println("------------------------------------------------------");
        for (Kitab kitab:ktb) {
            System.out.println(kitab.ID + "     " + kitab.name + "     " + kitab.author);
        }
        System.out.println("------------------------------------------------------");
    }

    public void addKitab(int id, String name, String author, ArrayList<Kitab> ktb){
        Kitab newKitab = new Kitab(id,name,author);
        ktb.add(newKitab);
    }

    public Kitab searchKitab1(String name, String author, ArrayList<Kitab> ktb){

        Kitab searchKitab = new Kitab();

        for (Kitab kitab1: ktb) {
            if (name.equals(kitab1.name) && author.equals(kitab1.author)){
                searchKitab = kitab1;
            }
        }
        return searchKitab;
    }

    public Kitab searchKitab2(int id, ArrayList<Kitab> ktb){
        Kitab searchKitab = new Kitab();

        for (Kitab kitab1: ktb) {
            if (id == kitab1.ID){
                searchKitab = kitab1;
            }
        }
        return searchKitab;
    }

    public void removeKitab(Kitab kitab, ArrayList<Kitab> ktb){
        ktb.remove(kitab);
    }

//    @Override
//    public Kitab infoMember() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter book ID: ");
//        int id = scanner.nextInt();
//        System.out.println("Please enter book name: ");
//        String name = scanner.next();
//        System.out.println("Please enter author");
//        String author = scanner.next();
//
//        return new Kitab(id,name,author);
//    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
//        return ID + "     " + name + "     " + author;
        return name;
    }
}
