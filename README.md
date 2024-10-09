# Bank-Application
This project involves the development of a comprehensive bank application featuring user authentication, account management, and transaction processing. The application is built using Spring Boot, Java, and PostgreSQL, and includes several key components.

**Objective:** Develop a secure bank application that allows users to log in, view their account details, perform transactions (deposit, withdraw, transfer), and view transaction history.

### Technology Stack

- **Backend:** Spring Boot (Java), Thymeleaf, Hibernate (for server-side rendering)
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS and BootStrap-5
- **Security:** Spring Security for authentication and authorization
- **Build Tool:** Maven

### Key Components

1. **Project Setup**
   - Create a Spring Boot project using Spring Initializr (https://start.spring.io/).
   - Include dependencies for Spring Web, Spring Data JPA, Spring Security, and PostgreSQL Driver.

2. **Database Configuration**
   - Configure PostgreSQL in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/bankdb
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Entity Classes**
   - Create entity classes to represent the database tables:
     - **User:** Represents a bank user with fields like `username`, `email`, and `password`.
     - **Account:** Represents a user account with fields like `id`, `user_id`, `account_type`, `balance`.
     - **Transaction:** Represents a transaction with fields like `id`, `account_id`, `type`, `amount`, `timestamp`.

4. **Repositories**
   - Create repository interfaces extending `JpaRepository` for each entity to perform CRUD operations.
     ```java
     public interface UserRepository extends JpaRepository<User, Long> {
         Optional<User> findByUsername(String username);
     }
     ```

5. **Service Layer**
   - Implement service classes to handle business logic:
     - **UserService:** Handles user registration, authentication, and fetching user details.
       
6. **Security Configuration**
   - Configure Spring Security to secure endpoints and handle user authentication:
     ```java
     @Configuration
     @EnableWebSecurity
     public class SecurityConfig extends WebSecurityConfigurerAdapter {
         @Override
         protected void configure(AuthenticationManagerBuilder auth) throws Exception {
             auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
         }

         @Override
         protected void configure(HttpSecurity http) throws Exception {
             http
                 .authorizeRequests()
                     .antMatchers("/login", "/register").permitAll()
                     .anyRequest().authenticated()
                     .and()
                 .formLogin()
                     .loginPage("/login")
                     .permitAll()
                     .and()
                 .logout()
                     .permitAll();
         }
     }
     ```

7. **Controller Layer**
   - Implement controllers to handle HTTP requests:
     - **AuthController:** Manages login and registration.
     - **DashboardController:** Displays user dashboard with account details and transaction options.
     - **TransactionController:** Handles deposit, withdrawal, and transfer requests.

8. **Frontend**
   - Use Thymeleaf templates to render views for login, dashboard, and transaction history.
   - Optionally, create a RESTful API to be consumed by a JavaScript frontend.

### Example Use Cases

1. **User Registration:** - Users can register with a username and password, which gets hashed and stored in the database.

2. **Login:** - Users authenticate using their credentials.

3. **Account Management:** - Users can view their account balance and transaction history.

4. **Transactions:** - Users can deposit, withdraw, or transfer money, with all transactions recorded in the database.
   
### Figure 1. Bank Application Index Page
![index](https://github.com/user-attachments/assets/5b8a6f44-b81f-47d9-bccc-75a0ed3928a4)

### Figure 2. Bank Application Registration Page
![register](https://github.com/user-attachments/assets/f6a8b34c-27b9-4128-a3cd-f357d8ab3a4e)

### Figure 3. Bank Application Login Page
![login](https://github.com/user-attachments/assets/9b389c0d-425b-4368-9b18-69905faa3ffb)

### Figure 4. Bank Application Dashboard Page
![dashboard](https://github.com/user-attachments/assets/26ccb3b2-a889-4f58-a119-92ab1ed041b6)

### Figure 5. Bank Application Transaction Page
![transaction](https://github.com/user-attachments/assets/9262a295-325c-4183-a4f5-187ece04f7d8)








# Installation Instructions for Bank Application

### Clone the Repository

1. Open your terminal or command prompt.
2. Clone the repository:
   ```bash
   git clone https://github.com/shahfaizanramju/Bank-Application.git
   ```
3. Navigate to the project directory:
   ```bash
   cd Bank-Application
   ```

#### Set Up PostgreSQL Database

1. Log in to your PostgreSQL server using:
   ```bash
   psql -U postgres
   ```
   (Replace `postgres` with your username if different.)

2. Create a new database:
   ```sql
   CREATE DATABASE bank_application;
   ```

3. Exit the PostgreSQL prompt:
   ```sql
   \q
   ```

#### Configure Application Properties

1. Open the `src/main/resources/application.properties` file in your project.
2. Configure the database connection settings:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/bank_application
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
   Replace `your_username` and `your_password` with your PostgreSQL credentials.

#### Build the Application

1. In your terminal, ensure you're in the project root directory.
2. Build the application using Maven:
   ```bash
   mvn clean install
   ```

#### Run the Application
- Start the application
   ```bash
   mvn spring-boot:run
   ```

#### Access the Application
- Open your web browser and navigate to `http://localhost:8080` to access the bank application.

### Additional Notes

- Make sure that PostgreSQL is running before starting the application.
- If you encounter any issues, check the logs in the terminal for error messages that can help with troubleshooting.
