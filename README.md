🔹 **Project Overview**
Full‑stack Monolithic Application combining backend (Spring Boot, Java, Maven) and frontend (HTML, CSS, JavaScript).

Designed to help users track daily expenses with categories, filters, and dashboards.

Organized into two main modules:

backend/ → REST APIs, database integration, business logic.

frontend/ → User interface for adding, viewing, and analyzing expenses.

🔹** Key Features**
User Management: Add and manage users securely.

Expense Categories: Create categories with icons for better visualization.

Expense Tracking: Add, edit, and delete expenses with date filters.

Dashboard View: Summarized totals, category‑wise breakdown, and date‑range reports.

Database Integration: Uses MySQL (or H2 for testing) with JPA repositories.

Responsive Frontend: Simple and clean UI built with HTML, CSS, and JavaScript.

🔹 **Tech Stack**
Backend: Java, Spring Boot, Maven, JPA/Hibernate, MySQL/H2.

Frontend: HTML, CSS, JavaScript.

Tools: Git, STS (Spring Tool Suite), MySQL Workbench.

🔹** How to Run**
Clone the repo:

bash
git clone https://github.com/Gugashri30/Expense_Tracker_Full_Stack_Monolithic__Application.git
Navigate to backend and run:

bash
mvn spring-boot:run
Open frontend index.html in browser.

Backend runs at http://localhost:8080, frontend connects via API calls.

🔹 **Future Enhancements**
Add authentication (Spring Security + JWT).

Improve UI with React/Angular.

Export reports to PDF/Excel.

Add charts for expense visualization.
