### Issue Tracker

#### Description
An issue tracking web application which supports the following services:
- Create a new issue using the corresponding form
- Edit an existing issue
- View issue details
- Display a list of the stored issues

#### Project structure
- Class **IssueTrackerApplication** acts as the application's entry point
- Package **controllers** contains the defined routes/endpoints
- Package **services** includes methods that are called by controllers
- **repository** package has methods used by services
- Package **entities** defines the application's model
- Package **security** utilizes Spring Security

### Technologies used
- Spring Boot 2.7
- Apache Maven
- Apache Tomcat 9