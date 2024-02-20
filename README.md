**TO-DO APP**

Steps to run the application

**Prequisites:**

1. Install Java (Latest Version)
2. Install IDE (Preferred: Eclipse) (Latest Version)
3. Install Docker (as we are running MySQL database on Docker) (Latest version)
4. Install Mysql Shell (https://dev.mysql.com/doc/mysql-shell/8.0/en/mysql-shell-install.html)

**Step 1: Clone the repository:**

Open Eclipse -> Window -> Show View-> Other -> Git Repositories.
In the Git repository section -> Clone a Git repository -> Clone URI -> Paste the link to the github repo [https://github.com/username/repository.git](https://github.com/rajsaurav4055/ToDoApp.git)

**Step 2: Import the project**
Once the repo is cloned, right-click on the git repo (in the git repository section) -> Import Projects -> Finish

**Step 3: Connecting ToDo App to MySQL database**
Open Docker -> Open Terminal -> In the terminal run the following command:
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle

Check docker for a running instance of MySQL database.

**Step 4: Start the Application**
Navigate to Mytodoapplication.java in the project -> Right click -> Run As -> Java Application

**Step 5: Open the ToDO app on Chrome**
Once the application is running, Open Chrome.
The App will be hosted at http://localhost:8080/

The login credentials are:
Username: admin
Password: admin

Login and feel free to add, update, delete and manage you todos.

**Step 6: Verify the connection with MySQL**
6.1. To check the table in MySQL, make sure you have MySQL Shell installed.
6.2. To connect to MySQL, open Terminal and run the following command:
        **mysqlsh** and press Enter 

     Then run **\connect todos-user@localhost:3306**
     Then enter the password: **dummytodos**
     Then connect to the schema using the command: **\use todos**
     Now to write sql statements type: **\sql**
     And start using the commands like **select * from todo;**

**Run Tests**

To Run tests navigate to the classes under src/test/java in Eclipse and Open 
**TodoControllerJpaTest.java** and **WelcomeControllerTest.java**

Right click -> Run As-> JUnit Test.
The status of the Test can be seen in the JUnit tab beside console.

**Note** TodoRepositoryIntegrationTest isn't working at the moment as it needs an embedded database different from production database, which I wasn't able to configure due to time constraints.

