# Librarian Management System
LMS controls itself similarly to an old car which rolls up the radiator and "ready"s up the Warehouse class, getting from all files the necessary materials
+ Users
+ Bills
+ Books, with authors and categories\

LMS starts with StarterView, which you put in the account's username and password.
Once found, the program gets you to another view, depending on the account's AccessLevel
+ AdminView shows total finances and has the EmployeeChartView
  which has a table where you edit, delete or add employees lower than you (Managers and Librarians)
+ ManagerView shows a table holding stocks of less than 5 books in the Books archive.
  The buttons include a book-adding bill system, which creates a new "Bill" called Bob for restocking purposes.
  Another button is BookStock where just like EmployeeChart, you add, delete and edit books in the archive.
+ LibrarianView is a little more straightforward, in the sense that all you do is create bills, which are placed in their toString format in the texts/bills folder.
  There they have their id, date, the list of included books and the total price and who did the bill (this is set to not happen is case of Bobs).

The project is in beta-2 phase. The link of the repository is down below.
Thank you and enjoy the rest of this old car.

LMS link: https://github.com/EnderDE77/librarian-ideal