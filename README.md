# hrmSys
Demo for Human Resource Management System

# Human Resource Management System (HRMS)

## Overview

GDOU from the experimental course assignments, with the system rights management, human resources file management, compensation management.
Permissions are fine-grained down to the button level.

## Features

- **Spring Boot**: Leverage the power of the Spring Boot framework to develop a robust and scalable HRMS.
- **MyBatis**: Utilize MyBatis for seamless integration with a MySQL database, ensuring efficient data management.
- **Lombok**: Enhance code readability and conciseness with Lombok annotations, reducing boilerplate code.
- **Druid**: Benefit from the connection pooling capabilities of Druid for optimized database interactions.
- **Knife4j**: Enable easy and interactive API documentation using Knife4j, simplifying the understanding of your HRMS APIs.
- **Sa-Token**: Implement secure and customizable authentication and authorization with Sa-Token.
- **JUnit**: Ensure code reliability with JUnit for comprehensive testing.

## Getting Started

1. **Prerequisites**: Make sure you have Java and Maven installed on your system.

2. **Clone the Repository**: 
    ```bash
    git clone https://github.com/your-username/hrms.git
    cd hrms
    ```

3. **Database Setup**: Configure your MySQL database settings in the `application.properties` file.

4. **Build and Run**: 
    ```bash
    mvn clean install
    java -jar target/hrms-1.0.0.jar
    ```

5. **Access the API Documentation**: Visit [http://localhost:8080/doc.html](http://localhost:8080/doc.html) for the interactive API documentation.

## Contributing

We welcome contributions from the community. Feel free to open issues, submit pull requests, or provide feedback.

## License

This HRMS project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

Special thanks to the developers and contributors who have dedicated their time and effort to make this HRMS project possible.

Happy coding! 🚀
