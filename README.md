# 🧪 Magento E-Commerce Test Automation Project

This is a test automation project built for the Magento e-commerce demo site.  
The framework uses **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and **Allure Reporting**.

---

## 📌 Project Features

- 🔍 Product search (valid & invalid)
- 🛒 Add to cart and complete purchase
- 🛡️ Basic security validation (XSS input detection)
- 🧪 TestNG test suite support
- 📊 Allure HTML reports

---

## 🛠️ Tech Stack

| Tool        | Version        |
|-------------|----------------|
| Java        | 17+            |
| Maven       | 3.6+           |
| Selenium    | 4+             |
| TestNG      | 7+             |
| Allure      | 2.24.0         |
| Browser     | Chrome (default) |

---

## 📂 Project Structure


│ ├── main
│ │ └── java
│ │ ├── pages/ # Page Object Model classes
│ │ ├── base/ # Base setup for WebDriver
│ │ └── utils/ # Input validation / helpers
│ └── test
│ └── java
│ └── tests/ # TestNG test classes
├── Executable_File.xml
├── pom.xml
└── README.md
## ✅ How to Run the Project??(2 Ways):
Way 1 : Download as A project and Open it from IDE like (IntelliJ) then Run 'Executable_File.xml' as normal Run then open terminal and enter this command 'allure serve allure-results' for allure report.
Way2 : using Command Line >> git clone https://github.com/AbdelrahmanAyman11/MagentoProject1.git >> 'Executable_File.xml' as normal Run then open terminal and enter this command 'allure serve allure-results' for allure report.


🔐 Security Tests
This project includes basic input validation via:

InputValidator.java for detecting potential XSS patterns

Example in SecurityValidationTest.java to simulate unsafe inputs

🙋‍♂️ Author
Abdelrahman Ayman Fahmy
 | Software Tester |


