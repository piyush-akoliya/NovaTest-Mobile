# 🚀 NovaTest-Mobile | Appium + Cucumber + Java Framework

**NovaTest-Mobile** is a modern, scalable mobile test automation framework built using Appium, Cucumber (BDD), and Java. It supports automated testing of Android and iOS applications with clean architecture, CI/CD readiness, and visually rich reporting using Allure — all integrated with Azure DevOps.

---

## 🧰 Tech Stack
```bash
| Tool           | Purpose                                           |
|----------------|---------------------------------------------------|
| Appium         | Mobile app automation (Android/iOS)               |
| Cucumber       | BDD with feature files and step definitions       |
| Java           | Core programming for automation logic             |
| Maven          | Dependency & project lifecycle management         |
| Azure DevOps   | CI/CD pipeline integration                        |
| Allure         | Interactive, real-time test reporting             |
```
---

## 📁 Project Structure

```bash
NovaTest-Mobile/
├── src/
│   ├── main/java/com/novatest/mobile/
│   │   ├── base/               # Driver setup, Hooks, BaseTest
│   │   ├── pages/              # Page Object classes
│   │   ├── stepdefinitions/    # Cucumber step definitions
│   │   ├── utils/              # Config reader, waits, mobile actions
│   │   └── runners/            # Test runners
│   └── test/resources/
│       ├── features/           # .feature files (BDD)
│       ├── config.properties   # Configurations for device, platform, etc.
│       ├── testdata/           # Test data files
│       └── allure.properties   # Allure report configuration
└── pom.xml                     # Maven configuration file 
```

---

## 🧪 Key Features

- ✅ Native, hybrid & web app testing support  
- ✅ Appium-based cross-platform execution  
- ✅ BDD with readable test scenarios  
- ✅ Page Object Model (POM) design  
- ✅ Reusable utilities for waits, actions, and configs  
- ✅ Cucumber Hooks for pre/post test actions  
- ✅ Detailed Allure HTML reports with screenshots  
- ✅ Azure DevOps–ready for CI/CD integration  

---

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher  
- Maven installed  
- Appium server running  
- Connected Android/iOS device or emulator  
- Allure CLI (for generating reports)  

## Setup

```bash
git clone https://github.com/yourusername/NovaTest-Mobile.git
cd NovaTest-Mobile
mvn clean install
```

---

## 🧭 Run Tests

```bash
mvn test
```

---

## 📊 Generate Allure Report

```bash
allure serve target/allure-results
```

---

## 🔁 Azure DevOps Integration

1. Add a pipeline with a Maven build task (`mvn test`).  
2. Publish Allure results as pipeline artifacts.  
3. Schedule or trigger runs on code pushes.  

---

## 🛠️ Configuration (`config.properties`)

Edit `src/test/resources/config.properties` to set device, platform, and environment settings. Example:

```properties
platformName=Android
deviceName=emulator-5554
appPackage=com.example.app
appActivity=com.example.app.MainActivity
```

---

## 📌 Reporting

This framework uses **Allure Reports**, providing:

- Step-by-step execution  
- Scenario breakdown  
- Screenshots on failure  
- Timeline view and attachments  

---

## 🧠 Best Practices Followed

- Modular & scalable architecture  
- Single Responsibility Principle (SRP) in class design  
- Thread-safe driver handling  
- Configuration-driven environment management  
- Clean separation of logic, test, and data  

---

## 👨‍💻 Author

Designed & maintained by **[Piyush Akoliya]**  
GitHub: [github.com/piyush-akoliya](https://github.com/piyush-akoliya)

---

## 📄 License

This project is intended for educational and internal testing purposes. Feel free to fork and extend it as needed.
```