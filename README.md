# restAssured API Test Framework

API Testing Framework using `restAssured` with `GitHub Actions` workflow for generating and publishing test report

## 🚀 Description:

Automated CRUD (i.e., `POST`, `GET`, `PUT`, `DELETE`) operations using `restAssured`

## 🚀 Prerequisites:

- [JAVA](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MAVEN](https://maven.apache.org/)
- [restAssured](https://rest-assured.io/)
- [Go Rest APIs](https://gorest.co.in)

## 🚀 Installation Steps:

- [Fork](https://github.com/leindecker/nba-api-test/fork) and Clone the repository `nba-api-test`
- Move to the `nba-api-test` directory:

## 🚀 Test Execution:

- To run the tests on your terminal:

```commandline
mvn test -Dcucumber.filter.tags="${CUCUMBER_TAG}
```

## 🚀 Reporting:

- Every push to a new branch or Pull Request to branhc [origin/main] will trigger CI/CD Github Actions

Allure Reportare generate at the URL below:

https://leindecker.github.io/nba-api-test/

- Allure Reports - Locally

```commandline
 allure serve
```

## 🚀 Notes:

- `.github/workflows/package_update.yml` workflow would ensure the dependencies are up-to-date
- Tests are always run on the latest dependencies ✅
