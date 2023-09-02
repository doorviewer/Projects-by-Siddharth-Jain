import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Commands_sql {

    static boolean flag = false;
    static Connection con = ConnectC.createC();
    public static Member searchMember(int id){
        Member searchMember = new Member();
        try {

            String q = "select * from memberTable where memberID=?";

            System.out.println("after string q");

            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,id);

            ResultSet set = prep.executeQuery();

            while (set.next()) {

                int memberID = set.getInt(1);
                String name = set.getString(2);
                String course = set.getString(3);
                String password = set.getString(4);
                int issuebookID1 = set.getInt(5);
                int issuebookID2 = set.getInt(6);

                 searchMember = new Member(memberID,name,course,password,issuebookID1,issuebookID2);

//                System.out.println("------------------------------------------------------");
//                System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
//                System.out.println("------------------------------------------------------");
//                System.out.println(memberID + "     " + name + "     " + course + "     " + issuebook1 + "," + issuebook2);
//                System.out.println("------------------------------------------------------");

                flag = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (flag){
            System.out.println("Member found!");
        } else {
            System.out.println("Something went wrong, please try again later.");
        }
        return searchMember;
    }

    public static void addMember(Member member){
        try {

            String q = "insert into memberTable(memberID,name,course,password,issuebook1,issuebook2,switch) values (?,?,?,?,?,?,?)";

            int zero =0;

            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,member.getID());
            prep.setString(2,member.getName());
            prep.setString(3,member.getCourse());
            prep.setString(4,member.getPassword());
            prep.setInt(5,zero);
            prep.setInt(6,zero);
            prep.setInt(7,zero);

            prep.executeUpdate();
            flag = true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        if (flag){
            System.out.println("Member added successfully to the database!");
        } else {
            System.out.println("Something went wrong, please try again later.");
        }
    }

    // delete member
    public static void deleteMember(Member member){
        try {

            String q = "delete from memberTable where memberID=?";

            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,member.getID());

            prep.executeUpdate();

            flag = true;

        } catch (Exception e){
            e.printStackTrace();
        }
        if (flag){
            System.out.println("Member removed successfully");
        } else {
            System.out.println("Something went wrong, please try again later.");
        }
    }

    public static void listMembers(){
        try {

            String q = "select* from memberTable";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){

                int memberID = set.getInt(1);
                String name = set.getString(2);
                String course = set.getString(3);
                int issuebook1 = set.getInt(5);
                int issuebook2 = set.getInt(6);

                System.out.println("------------------------------------------------------");
                System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
                System.out.println("------------------------------------------------------");
                System.out.println(memberID + "     " + name + "     " + course + "     " + issuebook1 + "," + issuebook2);
                System.out.println("------------------------------------------------------");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int statusMembership(int id){
        //0 means resume. 1 means pause.
        int status = 56;
        try {
            String q = "select * from memberTable where memberID=?";
            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1, id);

            ResultSet set = prep.executeQuery();
            while (set.next()){
                status = set.getInt(7);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //=====================================================================================================================================

    public static void addKitab(Kitab kitab){
        try {

            String q = "insert into kitabTable(kitabID,name,author,switch) values (?,?,?,?)";

            PreparedStatement prep = con.prepareStatement(q);

            prep.setInt(1,kitab.getID());
            prep.setString(2,kitab.getName());
            prep.setString(3,kitab.getAuthor());
            prep.setInt(4,0);

            prep.executeUpdate();

            flag = true;

        }catch (Exception e) {
            e.printStackTrace();
        }

        if (flag){
            System.out.println("Book added successfully to the database!");
        } else {
            System.out.println("Something went wrong, please try again later.");
        }
    }

    public static void listKitab(){
        try {

            String q = "select* from kitabTable";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){

                int kitabID = set.getInt(1);
                String name = set.getString(2);
                String author = set.getString(3);

                System.out.println("------------------------------------------------------");
                System.out.println("ID" + "     " + "NAME" + "     " + "AUTHOR");
                System.out.println("------------------------------------------------------");
                System.out.println(kitabID + "     " + name + "     " + author);
                System.out.println("------------------------------------------------------");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void deleteKitab(Kitab kitab){
        try {

            String q = "delete from kitabTable where kitabID=?";

            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,kitab.getID());

            prep.executeUpdate();

            flag = true;

        } catch (Exception e){
            e.printStackTrace();
        }
        if (flag){
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Something went wrong, please try again later.");
        }
    }

    public static void issueBook(int memberID, int kitabID){

        try{

            String q = "update kitabTable set switch=1 where kitabID=?";
            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,kitabID);
            prep.executeUpdate();

//=======================================================================
            String q2 = "update memberTable set issuebook?=? where memberID=?";

            PreparedStatement prep1 = con.prepareStatement(q2);
            prep1.setInt(1,1);
            prep1.setInt(2,0);
            ResultSet set = prep1.executeQuery();
            prep1.close();

//            System.out.println(set.getInt(5));

//            if (set.getInt(5) == 0 ){
//                prep1.setInt(1,1);
//                prep1.setInt(5,kitabID);
//            } else if (set.getInt(6) ==0) {
//                prep1.setInt(1,2);
//                prep1.setInt(6,kitabID);
//            } else System.out.println("Only two books can be issued at a time.");

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void test1(int memberID){

        try{

            String q = "select * from memberTable where memberID=?";
            PreparedStatement prep = con.prepareStatement(q);
            prep.setInt(1,memberID);

            ResultSet set = prep.executeQuery();
            int out = set.getInt(5);
            System.out.println(out);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
