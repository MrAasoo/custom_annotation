# Roman Numeral to Integer Converter (Learning Project - Java Custom Annotations)

This is a simple Java project for learning purposes. It converts **Roman numerals to integers**, using:

- ✅ Custom annotations for input validation
- 🔍 Strict Roman numeral format checking
- 🧪 JUnit 5 tests for correctness

---

## 🚀 Features

- `@RomanValidation` annotation to enforce Roman numeral input
- Character-level and regex-based format validation
- Central validator to wrap method calls
- Designed for beginners exploring Java annotations and testing

---

## 📁 Project Structure

```
annotation/
├── src
│   ├── main
│   │   └── java
│   │   │   └── com
│   │   │      └── aasoo
│   │   │          └── annotation
│   │   │              ├── annotation
│   │   │              │   └── RomanValidation.java
│   │   │              │   └── RomanValue.java
│   │   │              └── mapper
│   │   │                  └── RomanMapping.java
│   │   │              └── utils
│   │   │                  └── Converter.java
│   │   │              └── validator
│   │   │                  └── FormatValidator.java
│   │   │                  └── RomanValidator.java
│   │   │              └── Main.java
│   │   └── resources
│   └── test
│       └── java
│       │   └── com
│       │       └── aasoo
│       │           └── annotation
│       │               └── RomanConverterTest.java
│       └── resources
└── build.gradle
└── README.md
└── settings.gradle
``` 

---

## 🧪 Running the Project (Gradle)

### Prerequisites

- Java 8 or higher
- Gradle installed (`gradle -v`)
- JUnit 5 for testing
- IDE like IntelliJ IDEA or Eclipse (optional but recommended)

### Setup

1. Add the following to your `build.gradle`:

```groovy
plugins {
    id 'java'
}

group = 'com.aasoo'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}

test {
    useJUnitPlatform()
}
```

2. Run tests:

```bash
./gradlew test
```

---

## ✅ Sample Usage

```java
package com.aasoo.annotation;

import com.aasoo.annotation.validator.RomanValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from the console
        System.out.println("Enter a Roman numeral:"); // Prompt the user to enter a Roman numeral
        String romanNumeral = sc.nextLine().toUpperCase(); // Read the input and convert it to uppercase for consistency
        try {
            int result = RomanValidator.convertRomanToInt(romanNumeral); // Invoke the romanToInt method with validation
            System.out.println("The integer value of the Roman numeral " + romanNumeral + " is: " + result); // Print the result
        } catch (Exception e) {
            System.out.println("Invalid Roman numeral: " + romanNumeral); // Print an error message if the input is invalid
            System.out.println("Error: " + e.getMessage()); // Print the error message from the exception
        } finally {
            sc.close(); // Close the Scanner to prevent resource leaks
        }
    }
}
```


---

## 🧠 Example Valid Inputs

| Roman   | Output |
|---------|--------|
| I       | 1      |
| IV      | 4      |
| XCIV    | 94     |
| MCMXCIV | 1994   |

---

## ❌ Example Invalid Inputs

| Input | Error                        |
|-------|------------------------------|
| IXCV  | Invalid Roman numeral format |
| ABC   | Invalid Roman character      |
| IIII  | Invalid Roman numeral format |

---

This project is for educational purposes only.
Feel free to explore, modify, and learn from it!

---