import java.util.ArrayList;

public class Member {
    public int ID;
    public String name;
    public String course;
    public String password;
    public Kitab issuedBooks1;
    public Kitab issuedBooks2;

    public int issuedBooksID2;
    public int issuedBooksID1;

    public Member() {
    }

    public Member(int ID) {
        this.ID = ID;
    }

    public Member(int ID, String name, String course, String password) {
        this.ID = ID;
        this.name = name;
        this.course = course;
        this.password = password;
    }

    public Member(int ID, String name, String course, String password, Kitab issuedBooks1, Kitab issuedBooks2) {
        this.ID = ID;
        this.name = name;
        this.course = course;
        this.password = password;
        this.issuedBooks1 = issuedBooks1;
        this.issuedBooks2 = issuedBooks2;
    }


    public Member(int ID, String name, String course, String password, int issuedBooks1, int issuedBooks2) {
        this.ID = ID;
        this.name = name;
        this.course = course;
        this.password = password;
        this.issuedBooksID1 = issuedBooks1;
        this.issuedBooksID2 = issuedBooks2;
    }

    public ArrayList<Member> fillMember(){

        ArrayList<Member> mmbSample = new ArrayList<>();
        mmbSample.add(new Member(1001, "barkha", "bsc", "0000"));
        mmbSample.add(new Member(1002, "abhishek", "bsc", "0000"));
        mmbSample.add(new Member(1003, "krishna", "bsc", "0000"));
        mmbSample.add(new Member(1004, "sarthak", "bsc", "0000"));

        return mmbSample;
    }

    public void listMember(ArrayList<Member> mmb){
        System.out.println("------------------------------------------------------");
        System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
        System.out.println("------------------------------------------------------");
        for (Member member:mmb) {
            System.out.println(member);
        }
        System.out.println("------------------------------------------------------");
    }

    public void addMember(int id, String name, String course, String password, ArrayList<Member> mmb){
        Member member = new Member(id,name,course,password);
        mmb.add(member);
    }

    public void deleteMember(int id,ArrayList<Member> mmb){
        Member sampleMember = new Member();
        boolean test = false;

        for (Member member: mmb) {
            if (id == member.ID){
                sampleMember = member;

                System.out.println(sampleMember.name + " is removed from the list");
                test = true;
            }
        }

        if (test) {
            mmb.remove(sampleMember);
        } else System.out.println("Please enter valid student ID.");
    }

    public Member searchMember(int id, ArrayList<Member> mmb){
        Member sampleMember = new Member();
        for (Member member: mmb) {
            if (id == member.ID){
                sampleMember = member;
            }
        }
        return sampleMember;
    }

    public void issueBook(int kitabID,int memberID,ArrayList<Member> mmb,ArrayList<Kitab> ktb){
        Kitab sampleKitab = new Kitab();
        Member sampleMember = new Member();

        try {
            Kitab returnKitab = sampleKitab.searchKitab2(kitabID, ktb);
            Member returnMember = sampleMember.searchMember(memberID,mmb);

            if (returnMember.issuedBooks1 == null){
                returnMember.issuedBooks1 = returnKitab;
            } else if (returnMember.issuedBooks2 == null){
                returnMember.issuedBooks2 = returnKitab;
            }

            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Book named " + returnKitab.name + " has been successfully issued to " + returnMember.name);
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
            System.out.println(returnMember);
        } catch (Exception e){
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Cannot process the request. Please check IDs. Also only two books can be issued per member.");
            System.out.println("----------------------------------------------------------------------------------------------");

        }
    }

    public void returnBook(int kitabID, int memberID,ArrayList<Member> mmb,ArrayList<Kitab> ktb){
        Kitab sampleKitab = new Kitab();
        Member sampleMember = new Member();

        try {
            Kitab returnKitab = sampleKitab.searchKitab2(kitabID, ktb);
            Member returnMember = sampleMember.searchMember(memberID,mmb);

            if (returnMember.issuedBooks1 != null || returnMember.issuedBooks2 != null) {
                if (returnMember.issuedBooks1 == returnKitab) {
                    returnMember.issuedBooks1 = null;
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("Book named " + returnKitab.name + " has been successfully returned by " + returnMember.name);
                    System.out.println("-------------------------------------------------------------------------------------------");
                } else if (returnMember.issuedBooks2 == returnKitab) {
                    returnMember.issuedBooks2 = null;
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("Book named " + returnKitab.name + " has been successfully returned by " + returnMember.name);
                    System.out.println("-------------------------------------------------------------------------------------------");
                }
            } else System.out.println("The member has not issued mentioned book");


            System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
            System.out.println(returnMember);
        } catch (Exception e){
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Cannot process the request. Please check IDs. Also only two books can be issued per member.");
            System.out.println("----------------------------------------------------------------------------------------------");

        }
    }

    public void pauseMembership(Member member, ArrayList<Member> mmbPaused, ArrayList<Member> mmb){
        mmbPaused.add(member);
        mmb.remove(member);
    }

    public void resumeMembership(Member member, ArrayList<Member> mmbPaused, ArrayList<Member> mmb){
        mmbPaused.remove(member);
        mmb.add(member);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getPassword() {
        return password;
    }

    public Kitab getIssuedBooks1() {
        return issuedBooks1;
    }

    public Kitab getIssuedBooks2() {
        return issuedBooks2;
    }

    @Override
    public String toString() {
        return ID + "     " + name + "     " + course + "     " + issuedBooks1 + " , " + issuedBooks2;
    }
}
