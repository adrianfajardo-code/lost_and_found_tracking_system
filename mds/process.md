CampusLostFound/
│
├── src/
│   ├── model/                   # Data structures
│   │     ├── User.java
│   │     ├── Item.java
│   │     ├── Claim.java
│   │     ├── Comment.java       # New class for comments
│   │
│   ├── dao/                     # Database logic
│   │     ├── DBConnection.java
│   │     ├── UserDAO.java
│   │     ├── ItemDAO.java
│   │     ├── ClaimDAO.java
│   │     ├── CommentDAO.java    # Handles comments table
│
│   ├── ui/                      # GUI windows
│   │     ├── LoginFrame.java
│   │     ├── AdminDashboard.java
│   │     ├── StudentDashboard.java
│   │     ├── ItemForm.java      # Add/Edit item + upload image
│   │     ├── ClaimForm.java
│   │     ├── CommentForm.java   # Add/view comments
│
│   ├── app/
│   │     └── Main.java           # Launch app
