public class Print {

    public void LMS_main() {
        System.out.println("""
                Welcome to Library Management System
                ----------------------------------------------------
                a. Close program
                b. About LMS
                       Login as:
                1. Admin
                2. Member
                ----------------------------------------------------
                """);
    }

    public void LHS_info(){
        System.out.println("""
                --------------------------------------------------------------------------------------------------------
                A library is a collection of materials, books or media that are accessible
                 for use and not just for display purposes. A library provides physical (hard copies) 
                 or digital access (soft copies) materials, and may be a physical location
                 or a virtual space, or both. A library's collection can include printed materials
                 and other physical resources in many formats such as DVD, CD and cassette as well as
                 access to information, music or other content held on bibliographic databases.
                 --------------------------------------------------------------------------------------------------------
                """);
    }

    public void admin_0() {
        System.out.println("""
                ----------------------------------------------------
                0. Logout
                1. Library member
                2. Add book
                3. Book details
                4. Issue book
                5. Return book
                6. Delete book
                7. Help\s
                ----------------------------------------------------
                """);
    }

        public void admin_1 () {
            System.out.println("""
                    ----------------------------------------------------
                    1. Create member
                    2. Show member details
                    3. Delete member
                    4. Pause membership
                    5. Restart membership
                    6. Show all members
                    7. Previous menu
                    8. Logout\s
                    ----------------------------------------------------
                    """);
        }

        public void admin_01(){
            System.out.println("""
                    ----------------------------------------------------
                    1. Search by member ID
                    2. Show all member
                    ----------------------------------------------------
                    """);
        }

        public void admin_3 () {
            System.out.println("""
                    ----------------------------------------------------
                    Please choose one of the following:
                    1. Search by book name and author
                    2. Search by book ID
                    3. List of all books
                    ----------------------------------------------------
                    """);
        }

        public void admin_ () {
            System.out.println("""
                                    
                    """);
        }

        public void admin_6(){
            System.out.println("""
                    --------------------------------------------
                    HELP option selected.
                    ____________________________________________
                    """);
        }

        public void mem_1(){
            System.out.println("""
                    0. Logout
                    1. Library member
                    2. Book details
                    3. Help
                    """);
        }
}
