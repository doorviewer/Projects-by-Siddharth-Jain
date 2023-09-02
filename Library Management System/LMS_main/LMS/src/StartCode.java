import java.util.ArrayList;
import java.util.Scanner;

public class StartCode {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Kitab kitab = new Kitab();
        Member member = new Member();
        Print print = new Print();

        ArrayList<Member> mmb =  member.fillMember();
        ArrayList<Kitab> ktb =  kitab.fillKitab();

        ArrayList<Member> mmbPaused = new ArrayList<>();

        boolean switchLMS = true;

        while (switchLMS) {

            boolean switchAdmin = true;
            boolean switchMember = true;

            print.LMS_main();
            String LMS_main = scanner.next();

            switch (LMS_main) {
                case "a" -> {
                    System.out.println("Closing the LHS program. Please visit again soon.");
                    switchLMS = false;
                }
                case "b" -> print.LHS_info();

                case "1" -> {

                        System.out.println("Please enter admin ID");
                        String adminID = scanner.next();
                        System.out.println("Please enter admin password");
                        String adminPassword = scanner.next();
                        if (adminID.equals("w") && adminPassword.equals("w")) {

                            while (switchAdmin) {

                            print.admin_0();
                            String admin_0 = scanner.next();

                            switch (admin_0) {

                                case "0" -> {
                                    System.out.println("--------Logged out successfully----------");
                                    System.out.println(" ");
                                    switchAdmin = false;
                                }

                                case "1" -> {
                                    boolean memberSwitch_admin = true;
                                    while (memberSwitch_admin) {
                                        // member manipulation
                                        print.admin_1();
                                        String admin_1 = scanner.next();
                                        switch (admin_1) {
                                            case "1" -> {
                                                //create member
                                                System.out.println("Please enter new member ID: ");
                                                int new_id = scanner.nextInt();
                                                System.out.println("Please enter new member name: ");
                                                String new_name = scanner.next();
                                                System.out.println("Please enter new member course: ");
                                                String new_course = scanner.next();
                                                System.out.println("Please enter new member password: ");
                                                String new_password = scanner.next();

                                                member.addMember(new_id, new_name, new_course, new_password, mmb);
                                                Member newMember = new Member(new_id, new_name, new_course, new_password);

                                                Commands_sql.addMember(newMember);

                                                System.out.println("Please verify: ");
                                                member.listMember(mmb);
                                            }

                                            case "2" -> {
                                                //Show member details
                                                print.admin_01();
                                                String admin_01 = scanner.next();

                                                switch (admin_01) {
                                                    case "1" -> {
                                                        // search by member ID
                                                        System.out.println("Please enter the member ID");
                                                        int memberID = scanner.nextInt();
//                                                        member.searchMember(memberID, mmb);

                                                        Commands_sql.searchMember(memberID);
                                                    }
                                                    case "2" -> {
                                                        // Show all members
//                                                        member.listMember(mmb);
                                                        Commands_sql.listMembers();
                                                    }
                                                }
                                            }

                                            case "3" -> {
                                                // delete member
                                                System.out.println("Please enter member ID: ");
                                                int searchID = scanner.nextInt();
//                                                member.deleteMember(searchID, mmb);

                                                Member deleteMember = new Member(searchID);
                                                Commands_sql.deleteMember(deleteMember);

                                                member.listMember(mmb);
                                            }

                                            case "4" -> {
                                                // pause membership
                                                System.out.println("Please enter member ID: ");
                                                int pauseID = scanner.nextInt();
                                                Member pauseMember = member.searchMember(pauseID, mmb);
                                                mmbPaused.add(pauseMember);
                                                mmb.remove(pauseMember);

                                                System.out.println("Membership of " + pauseMember.name + " has been paused.");
                                                member.listMember(mmb);
                                            }

                                            case "5" -> {
                                                // resume membership
                                                System.out.println("Here is the list of paused memberships");
                                                member.listMember(mmbPaused);

                                                System.out.println("Please enter member ID: ");
                                                int resumeID = scanner.nextInt();
                                                Member resumeMember = member.searchMember(resumeID, mmbPaused);
                                                mmb.add(resumeMember);
                                                System.out.println("Membership of " + resumeMember.name + " has been resumed.");
                                                member.listMember(mmb);
                                            }

                                            case "6" -> {
//                                                member.listMember(mmb);
                                                Commands_sql.listMembers();
                                            }

                                            case "7" -> {
                                                //previous menu
                                                memberSwitch_admin = false;
                                            }

                                            case "8" -> {
                                                //logout
                                                memberSwitch_admin = false;
                                                System.out.println("---------------Logged out successfully---------------");
                                            }
                                        }
                                    }
                                }

                                case "2" -> {
                                    //Add book
                                    System.out.println("Please enter new book ID: ");
                                    int new_id = scanner.nextInt();
                                    System.out.println("Please enter new book name: ");
                                    String new_name = scanner.next();
                                    System.out.println("Please enter new book author: ");
                                    String new_author = scanner.next();

                                    Kitab addKitab = new Kitab(new_id, new_name, new_author);
                                    Commands_sql.addKitab(addKitab);

//                                    kitab.addKitab(new_id, new_name, new_author, ktb);
                                    Commands_sql.listKitab();
                                }

                                case "3" -> {
                                    //book details
                                    print.admin_3();
                                    String admin_3 = scanner.next();
                                    switch (admin_3) {
                                        case "1" -> {
                                            System.out.println("Please enter the book name: ");
                                            String searchName = scanner.next();
                                            System.out.println("Please enter the author name: ");
                                            String searchAuthor = scanner.next();

                                            Kitab kitab001 = kitab.searchKitab1(searchName, searchAuthor, ktb);

                                            if (kitab001.name == null) {
                                                System.out.println("Incorrect details. Please check again.");
                                            } else
                                                System.out.println("Book found!  ID: " + kitab001.ID + " ,Name: " + kitab001.name + " ,Author: " + kitab001.author);
                                        }
                                        case "2" -> {
                                            System.out.println("Please enter the book ID: ");
                                            int newID = scanner.nextInt();

                                            Kitab kitab002 = kitab.searchKitab2(newID, ktb);

                                            if (kitab002.ID == 0) {
                                                System.out.println("Incorrect details. Please check again.");
                                            } else
                                                System.out.println("Book found!  ID: " + kitab002.ID + " ,Name: " + kitab002.name + " ,Author: " + kitab002.author);
                                        }

                                        case "3" -> {
                                            // book list
//                                            kitab.listKitab(ktb);
                                            Commands_sql.listKitab();
                                        }
                                    }
                                }

                                case "4" -> {
                                    //issue book
                                    System.out.println("Please enter the book ID: ");
                                    int issue_ID = scanner.nextInt();
                                    System.out.println("Please enter the student ID: ");
                                    int issueMemberID = scanner.nextInt();
                                    member.issueBook(issue_ID, issueMemberID, mmb, ktb);
                                }

                                case "5" -> {
                                    //return book
                                    member.listMember(mmb);
                                    System.out.println("Please enter the student ID");
                                    int memberID = scanner.nextInt();
                                    System.out.println("Please enter the book ID to be returned");
                                    int kitabID = scanner.nextInt();
                                    member.returnBook(kitabID, memberID, mmb, ktb);
                                    member.listMember(mmb);
                                }

                                case "6"->{
                                    //delete book
                                    System.out.println("Please enter book ID: ");
                                    int id = scanner.nextInt();
                                    Kitab deleteKitab = new Kitab(id);
                                    Commands_sql.deleteKitab(deleteKitab);
                                }

                                case "7" -> {
                                    print.admin_6();
                                }
                            }
                        }
                    } else
                            System.out.println("------- Incorrect username or password. Please check again.-----------");
                }

                case "2" -> {
                    System.out.println("Please enter member ID: ");
                    int idLogin = scanner.nextInt();
                    System.out.println("Please enter password");
                    String passwordLogin = scanner.next();

//                    Member mainMember = member.searchMember(idLogin, mmb);
                    Member mainMember = new Member(idLogin);

                    if (mainMember.password.equals(passwordLogin) && Commands_sql.statusMembership(mainMember.ID)==0) {
                        while (switchMember) {
                            System.out.println("Welcome " + mainMember.name + "!");
                            print.mem_1();
                            String mem_1 = scanner.next();
                            switch (mem_1) {
                                case "0" -> {
                                    //log out
                                    switchMember = false;
                                }

                                case "1" -> {
                                    //Library member details
                                    System.out.println("ID" + "     " + "NAME" + "     " + "COURSE" + "     " + "BOOKS ISSUED");
                                    System.out.println(mainMember);
                                }

                                case "2" -> {
                                    //book details
                                    print.admin_3();
                                    String mem_2 = scanner.next();
                                    switch (mem_2) {
                                        case "1" -> {
                                            System.out.println("Please enter the book name: ");
                                            String searchName = scanner.next();
                                            System.out.println("Please enter the author name: ");
                                            String searchAuthor = scanner.next();

                                            Kitab kitab001 = kitab.searchKitab1(searchName, searchAuthor, ktb);

                                            if (kitab001.name == null) {
                                                System.out.println("Incorrect details. Please check again.");
                                            } else
                                                System.out.println("Book found!  ID: " + kitab001.ID + " ,Name: " + kitab001.name + " ,Author: " + kitab001.author);
                                        }
                                        case "2" -> {
                                            System.out.println("Please enter the book ID: ");
                                            int newID = scanner.nextInt();

                                            Kitab kitab002 = kitab.searchKitab2(newID, ktb);

                                            if (kitab002.ID == 0) {
                                                System.out.println("Incorrect details. Please check again.");
                                            } else
                                                System.out.println("Book found!  ID: " + kitab002.ID + " ,Name: " + kitab002.name + " ,Author: " + kitab002.author);
                                        }

                                        case "3" -> {
                                            // Help
                                            System.out.println("_______________-----------HELP Option Selected____________-----------");

                                        }
                                    }
                                }
                            }
                        }
                    } else System.out.println("------- Incorrect username or password. Please check again.-----------");
                }
            }
        }
    }
}
